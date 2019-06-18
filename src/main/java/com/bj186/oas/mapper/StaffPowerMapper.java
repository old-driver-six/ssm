package com.bj186.oas.mapper;

import com.bj186.oas.pojo.StaffPower;

public interface StaffPowerMapper {
    int deleteByPrimaryKey(Integer spId);

    int insert(StaffPower record);

    int insertSelective(StaffPower record);

    StaffPower selectByPrimaryKey(Integer spId);

    int updateByPrimaryKeySelective(StaffPower record);

    int updateByPrimaryKey(StaffPower record);
}