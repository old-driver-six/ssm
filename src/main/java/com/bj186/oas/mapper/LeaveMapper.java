package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Leave;

public interface LeaveMapper {
    int deleteByPrimaryKey(String leaveId);

    int insert(Leave record);

    int insertSelective(Leave record);

    Leave selectByPrimaryKey(String leaveId);

    int updateByPrimaryKeySelective(Leave record);

    int updateByPrimaryKeyWithBLOBs(Leave record);

    int updateByPrimaryKey(Leave record);
}