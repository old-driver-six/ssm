package com.bj186.oas.service.system;

import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Staff;

import java.util.List;

public interface DepService {
    List<Department> selectDep();
    List<Staff> selectDepStaff(String depName);
}
