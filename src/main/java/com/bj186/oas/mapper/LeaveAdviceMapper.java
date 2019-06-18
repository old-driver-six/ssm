package com.bj186.oas.mapper;

import com.bj186.oas.pojo.LeaveAdvice;

public interface LeaveAdviceMapper {
    int deleteByPrimaryKey(String leaveadviceId);

    int insert(LeaveAdvice record);

    int insertSelective(LeaveAdvice record);

    LeaveAdvice selectByPrimaryKey(String leaveadviceId);

    int updateByPrimaryKeySelective(LeaveAdvice record);

    int updateByPrimaryKey(LeaveAdvice record);
}