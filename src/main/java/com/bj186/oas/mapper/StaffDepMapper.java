package com.bj186.oas.mapper;

import com.bj186.oas.pojo.StaffDep;

public interface StaffDepMapper {
    int deleteByPrimaryKey(Integer sdId);

    int insert(StaffDep record);

    int insertSelective(StaffDep record);

    StaffDep selectByPrimaryKey(Integer sdId);

    int updateByPrimaryKeySelective(StaffDep record);

    int updateByPrimaryKey(StaffDep record);
}