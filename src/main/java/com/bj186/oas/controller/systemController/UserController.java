package com.bj186.oas.controller.systemController;

import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Position;
import com.bj186.oas.pojo.Power;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据ID查询员工
     * @return staff 员工对象
     */
    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public Staff selectByPrimaryKey() {
        return userService.selectByPrimaryKey(10001);
    }

    /**
     * 模糊查询
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public List<Staff> select() {
        return userService.select(null,null,2,1);
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
        Staff staff = new Staff();
        staff.setStaffName("叶");
        staff.setStaffPhone("13281989189");
        staff.setStaffAge((byte)21);
        staff.setStaffAdress("成都");
        staff.setStaffBirthday(new Date());
        staff.setStaffEmail("193572912@qq.com");
        staff.setStaffIdntitycardid("511521199712166158");
        staff.setStaffSex("1");
        staff.setStaffWage("15k");

        Department department = new Department();
        department.setDepId(2);
        staff.setDepartment(department);

        Position position = new Position();
        position.setPositionId(1);
        staff.setPosition(position);

        return userService.insert(staff);
    }

    /**
     * 修改数据根据主键 包含全部信息
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update() {
        Staff staff = new Staff();
        staff.setStaffId(10005);
        staff.setStaffName("叶");
        staff.setStaffPhone("13281989189");
        staff.setStaffAge((byte)21);
        staff.setStaffAdress("成都");
        staff.setStaffBirthday(new Date());
        staff.setStaffEmail("193572912@qq.com");
        staff.setStaffIdntitycardid("511521199712166158");

        Department department = new Department();
        department.setDepId(2);
        staff.setDepartment(department);

        return userService.update(staff);
    }

    /**
     * 修改数据根据主键 动态SQL
     * @return
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody

    public String updateByPrimaryKeySelective() {
        Staff staff = userService.selectByPrimaryKey(10002);
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
