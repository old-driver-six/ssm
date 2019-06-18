package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Meeting;

public interface MeetingMapper {
    int deleteByPrimaryKey(String meetingId);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(String meetingId);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKeyWithBLOBs(Meeting record);

    int updateByPrimaryKey(Meeting record);
}