package com.bj186.oas.mapper;

import com.bj186.oas.pojo.MeetingStaff;

public interface MeetingStaffMapper {
    int deleteByPrimaryKey(String meetingstaffId);

    int insert(MeetingStaff record);

    int insertSelective(MeetingStaff record);

    MeetingStaff selectByPrimaryKey(String meetingstaffId);

    int updateByPrimaryKeySelective(MeetingStaff record);

    int updateByPrimaryKey(MeetingStaff record);
}