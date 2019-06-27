package com.bj186.oas.controller.systemController;

import com.bj186.oas.entity.system.Dep;
import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.system.DepService;
import com.bj186.oas.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dep")
public class DepController {
    @Autowired
    private DepService depService;
    @Autowired
    private UserService userService;

    /**
     * 查询全部部门信息
     * @return
     */
    public List<Dep> selectDep(){
       List<Dep> depList = new ArrayList<>();
        List<Department> departmentList = depService.selectDep();
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
        return depList;
    }
}
