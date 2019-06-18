package com.bj186.oas.mapper;

import com.bj186.oas.pojo.MeetingStaff;

public interface MeetingStaffMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(String meetingstaffId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(MeetingStaff record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(MeetingStaff record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    MeetingStaff selectByPrimaryKey(String meetingstaffId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(MeetingStaff record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(MeetingStaff record);
}