package com.bj186.oas.controller.systemController;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.entity.system.Like;
import com.bj186.oas.entity.system.User;
import com.bj186.oas.pojo.*;
import com.bj186.oas.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController  extends HttpServlet {

    @Autowired
    private UserService userService;
    private Integer pageSize;
    private Integer pageNum;

    /**
     * 根据ID查询员工 详细信息
     * @return staff 员工对象
     */
    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public Staff selectByPrimaryKey(@RequestBody Staff staff){
        System.out.println(staff.getStaffId());
        return userService.selectByPrimaryKey(staff.getStaffId());
    }

    @RequestMapping("/bbb")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("staffId"));
    }

    @RequestMapping("index")
    public String index() {
        return "/system/user-management";
    }

    @RequestMapping("detailed")
    public String detailed() {
        return "/system/detailed";
    }

    @RequestMapping("/index2")
    public String index2() {
        System.out.println("view here");
        return "/statics/html/index2.html";
    }


    /**
     * 查询数据总数
     * @return
     */
    @RequestMapping("/staffCount")
    @ResponseBody
    public Integer selectCount() {
        return userService.selectCount("oas_staff");
    }

    /**
     * 模糊查询 初次显示
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public Object select(
          @RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize
     ,@RequestParam(name="filed",required = true, defaultValue ="") String filed, @RequestParam(name="value",required = true, defaultValue = "") String value
//            @RequestBody Like like
          ,@RequestParam("uId") Integer uId
    ) {
        System.out.println(filed);
        System.out.println(value);
        System.out.println(uId);
        System.out.println(pageNum);
        System.out.println(pageSize);
//        Like like = new Like();
//        like.setuId(10002);
//        like.setFiled("dep_name");
//        like.setValue("行政部");
//        like.setPageSize(10);
//        like.setPageNum(1);

        List<Staff> staffList;
//        Staff staff = userService.selectByPrimaryKey(like.getuId());
        Staff staff = userService.selectByPrimaryKey(uId);
        System.out.println(staff.getDepartment().getDepName());

//        staffList = userService.selectByDep(staff.getDepartment().getDepName(), like.getFiled(), like.getValue(), like.getPageSize(), like.getPageNum());
        staffList = userService.selectByDep(staff.getDepartment().getDepName(),filed, value, pageSize, pageNum);

        if(staffList==null){
            return "你不权查询其他部门";
        }

        Integer count=staffList.size();

//        if(like.getFiled()==null||like.getValue()==null){
//            count = selectCount();
//        }

        if(filed.equals("")||value.equals("")){
            count = selectCount();
        }
        System.out.println(staffList);
        OAResoult<List<Staff>> oaResoult = new OAResoult();
        oaResoult.setCode(0);
        oaResoult.setMsg("");
        oaResoult.setCount(count);
        oaResoult.setData(staffList);
        System.out.println(oaResoult);
        return oaResoult;
    }

    /**
     * 模糊查询
     * @return
     */
    @RequestMapping("/selectLike")
    @ResponseBody
    public Object selectLike(@RequestBody Like like) {

        Integer count = selectCount();
        OAResoult<List<Staff>> oaResoult = new OAResoult();
        oaResoult.setCode(0);
        oaResoult.setMsg("");
        oaResoult.setCount(count);
        oaResoult.setData(userService.select(like.getFiled(), like.getValue(), like.getPageSize(),like.getPageNum()));
        System.out.println(oaResoult);
        return oaResoult;
    }

    /**
     * 全部查询
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Staff> selectAll() {
        return userService.selectAll();
    }

    /**
     * 插入数据
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public String insert() {
        return userService.insert(new User());
    }

    /**
     * 停职功能
     * @return
     */
    @RequestMapping("/Suspension")
    @ResponseBody
    public Integer Suspension(@RequestBody Staff  staff) {
        Integer suspension = userService.Suspension(staff.getStaffId());
        return suspension;
    }

    /**
     * 修改数据根据主键 包含全部信息
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody User user) {
        if(userService.update(user).equals("success"))
            return "修改成功";
        else
            return "修改失败";

    }

    /**
     * 修改数据根据主键 动态SQL
     * @return
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody

    public String updateByPrimaryKeySelective(@RequestBody Staff staff1) {
        Staff staff = userService.selectByPrimaryKey(staff1.getStaffId());
        staff.setStaffName("叶2");
        staff.setStaffPhone("13281989189");
        staff.setStaffIdntitycardid("511521199712166158");

        Department department = new Department();
        department.setDepId(2);
        staff.setDepartment(department);

        Position position = new Position();
        position.setPositionId(1);
        staff.setPosition(position);

        return userService.updateByPrimaryKeySelective(staff);
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        return userService.delete(10003);
    }

}
