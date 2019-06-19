package com.bj186.oas.service.system.systemImpl;

import com.bj186.oas.mapper.StaffMapper;
import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Position;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.system.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private StaffMapper staffMapper;
    @Override
    public Staff select(String name, Integer staffID, String depName, Integer position, Integer pageNumber, Integer pageSize) {
        Staff staff = staffMapper.selectByPrimaryKey(10001);
        Department department = new Department();
        Position position1 = new Position();
        position1.setPositionId(2);
        department.setDepId(2);
        staff.setDepartment(department);
        staff.setStaffId(null);
        staff.setStaffName("刘超");
        staff.setPosition(position1);
        staffMapper.insert(staff);
        return staff;
    }


}
