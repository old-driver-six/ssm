package com.bj186.oas.service.system.systemImpl;

import com.bj186.oas.mapper.StaffMapper;
import com.bj186.oas.pojo.*;
import com.bj186.oas.service.system.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private StaffMapper staffMapper;

    /**
     * 根据ID查询
     * @param staffID
     * @return staff对象
     */
    @Override
    public Staff selectByPrimaryKey(Integer staffID) {
        Staff staff = staffMapper.selectByPrimaryKey(staffID);
        return staff;

    }

    @Override
    public Staff select(String filed,String value,Integer pageSize,Integer pageNum) {
        return null;
    }

    /**
     *  插入员工方法
     * @param staff
     * @return success 成功 error 失败
     */
    @Override
    public String insert(Staff staff) {
        if(staffMapper.insert(staff)==1){
            return "success";
        }
        return "error";
    }

    @Override
    public String update(Staff staff) {
        return null;
    }

    @Override
    public String delete(Integer staffID) {
        return null;
    }
}
