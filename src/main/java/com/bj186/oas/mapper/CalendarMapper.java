package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Calendar;
import com.bj186.oas.pojo.personalpojo.CalendarUtil;
import com.bj186.oas.pojo.personalpojo.StaffInfo;

import java.util.List;
import java.util.Map;

public interface CalendarMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(String calendarId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Calendar record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Calendar record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Calendar selectByPrimaryKey(String calendarId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Calendar record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeyWithBLOBs(Calendar record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Calendar record);

    StaffInfo<Calendar> getStaffInfo(Integer sid);
}