package com.bj186.oas.service.common.impl;

import com.bj186.oas.mapper.DepartmentMapper;
import com.bj186.oas.mapper.StaffMapper;
import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.pojo.Department;
import com.bj186.oas.service.common.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private DepartmentMapper departmentMapper;
    @Override
    public Department selectDepByKey(Integer id) {
        Department department = departmentMapper.selectByPrimaryKey(id);
        return department;
    }
}
