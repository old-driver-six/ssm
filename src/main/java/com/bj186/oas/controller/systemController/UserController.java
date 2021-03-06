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


    @RequestMapping("index")
    public String index() {
        return "system/user-manage";
    }

    @RequestMapping("detailed")
    public String detailed() {
        return "system/user-detailed";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "system/user-state";
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
     * 重置密码
     * @return
     */
    @RequestMapping("/updateRes")
    @ResponseBody
    public OAResoult updateRes(@RequestBody Users users) {
        Integer integer = userService.updateRes(users);
        System.out.println(integer);
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(integer);
        oaResoult.setMsg("已重置密码为手机号后六位");
        return oaResoult;
    }


    /**
     * 模糊查询 初次显示
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public OAResoult select(
          @RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize
     ,@RequestParam(name="filed",required = true, defaultValue ="") String filed, @RequestParam(name="value",required = true, defaultValue = "") String value
    ) {
        System.out.println(filed);
        System.out.println(value);
        System.out.println(pageNum);
        System.out.println(pageSize);

        List<Staff> staffList;
        staffList = userService.select(filed, value, pageSize, pageNum);

        Integer count=staffList.size();

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
    public OAResoult insert(@RequestBody User user) {
        System.out.println(111);
        user.getDepartment().setDepId(user.getDepId());
        user.getPosition().setPositionId(user.getPositionId());
        Integer insert = userService.insert(user, user.getPowerIdList());
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(insert);
        System.out.println();
        return oaResoult;
    }

    /**
     * 停职功能
     * @return
     */
    @RequestMapping("/suspension")
    @ResponseBody
    public OAResoult suspension(@RequestBody Staff  staff) {
        Integer suspension = userService.suspension(staff.getStaffId());
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(suspension);
        System.out.println();
        return oaResoult;
    }

    @RequestMapping("/departure")
    @ResponseBody
    public OAResoult Departure(@RequestBody Staff  staff) {
        Integer suspension = userService.Departure(staff.getStaffId());
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(suspension);
        System.out.println();
        return oaResoult;
    }



    /**
     * 复职功能
     * @return
     */
    @RequestMapping("/office")
    @ResponseBody
    public OAResoult office(@RequestBody Staff  staff) {
        Integer suspension = userService.office(staff.getStaffId());
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(suspension);
        System.out.println();
        return oaResoult;
    }

    /**
     * 修改数据根据主键 包含全部信息
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public OAResoult update(@RequestBody User user) {
        Integer update = userService.update(user);
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(update);
        return oaResoult;

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
