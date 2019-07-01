package com.bj186.oas.service.system.systemImpl;

import com.bj186.oas.mapper.DepartmentMapper;
import com.bj186.oas.mapper.StaffMapper;
import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.system.DepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("depService")
public class DepServiceImpl implements DepService {
    @Resource
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> selectDep() {
        List<Department> departmentList = departmentMapper.selectDep();
        return departmentList;
    }

    @Override
    public List<Staff> selectDepStaff(String depName) {
        List<Staff> staffList = departmentMapper.selectDepStaff(depName);
        System.out.println(staffList);
        System.out.println(11111);
        return staffList;
    }
}
