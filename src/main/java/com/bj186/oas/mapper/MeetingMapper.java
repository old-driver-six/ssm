package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Meeting;

public interface MeetingMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(String meetingId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Meeting record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Meeting record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Meeting selectByPrimaryKey(String meetingId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Meeting record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeyWithBLOBs(Meeting record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Meeting record);
}