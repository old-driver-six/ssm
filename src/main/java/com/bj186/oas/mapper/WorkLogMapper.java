package com.bj186.oas.mapper;

import com.bj186.oas.pojo.WorkLog;

public interface WorkLogMapper {
    int deleteByPrimaryKey(Integer worklogId);

    int insert(WorkLog record);

    int insertSelective(WorkLog record);

    WorkLog selectByPrimaryKey(Integer worklogId);

    int updateByPrimaryKeySelective(WorkLog record);

    int updateByPrimaryKeyWithBLOBs(WorkLog record);

    int updateByPrimaryKey(WorkLog record);
}