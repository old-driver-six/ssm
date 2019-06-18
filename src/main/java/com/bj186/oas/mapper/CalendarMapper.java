package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Calendar;

public interface CalendarMapper {
    int deleteByPrimaryKey(String calendarId);

    int insert(Calendar record);

    int insertSelective(Calendar record);

    Calendar selectByPrimaryKey(String calendarId);

    int updateByPrimaryKeySelective(Calendar record);

    int updateByPrimaryKeyWithBLOBs(Calendar record);

    int updateByPrimaryKey(Calendar record);
}