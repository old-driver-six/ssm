package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Staff;

import java.util.List;

public interface StaffMapper {
    List<Staff> selectStaffAll();

    int deleteByPrimaryKey(Integer staffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staffId);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}