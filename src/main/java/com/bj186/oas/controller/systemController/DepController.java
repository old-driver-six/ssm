package com.bj186.oas.controller.systemController;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.entity.system.Dep;
import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.system.DepService;
import com.bj186.oas.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dep")
public class DepController {
    @Autowired
    private DepService depService;
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "system/dep-manage";
    }

    @RequestMapping("/dep-detailed")
    public String detailed() {
        return "system/dep-detailed";
    }
    @RequestMapping("/transfer")
    public String transfer() {
        return "system/transfer";
    }
    /**
     * 查询全部部门信息
     * @return
     */
    @RequestMapping("/selectDep")
    @ResponseBody
    public OAResoult selectDep(@RequestParam("uId") Integer uId){
        Staff staff1 = userService.selectByPrimaryKey(uId);
        OAResoult<List<Dep>> oaResoult = new OAResoult();
        List<Dep> depList = new ArrayList<>();

        List<Department> departmentList = depService.selectDep();//获取数据库数据
        //放到指定Dep实体列表内
        for (Department department : departmentList) {
            Dep dep = new Dep();
            dep.setDepId(department.getDepId());
            dep.setDepName(department.getDepName());
            Staff staff = userService.selectByPrimaryKey(department.getDepManagerid());
            dep.setStaffName(staff.getStaffName());
            dep.setDepDescribe(department.getDepDescribe());
            dep.setDepNumber(department.getDepNumber());
            depList.add(dep);
        }

        //放到返回类中
        oaResoult.setCode(0);
        oaResoult.setMsg("");
        oaResoult.setCount(4);
        oaResoult.setData(depList);
        return oaResoult;
    }

    /**
     * 查询部门经理
     * @return
     */
    @RequestMapping("/selectDepStaff")
    @ResponseBody
    public Staff selectDepStaff(@RequestParam("staffName") String staffName){
        Staff staff = userService.selectByName(staffName);
        OAResoult<List<Staff>> oaResoult = new OAResoult();
        return staff;
    }
}
