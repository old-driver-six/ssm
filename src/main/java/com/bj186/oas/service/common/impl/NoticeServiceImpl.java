package com.bj186.oas.service.common.impl;

import com.bj186.oas.mapper.DepartmentMapper;
import com.bj186.oas.pojo.Department;
import com.bj186.oas.service.common.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public Department selectDepByKey(Integer id) {
        Department department = departmentMapper.selectByPrimaryKey(id);
        return department;
    }
}
