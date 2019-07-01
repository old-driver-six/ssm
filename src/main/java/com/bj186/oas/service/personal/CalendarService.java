package com.bj186.oas.service.personal;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.Calendar;

import java.util.Date;

/**
 * 日程表
 */
public interface CalendarService {
    /**
     * 创建行程,除了创建行程时间以外,其他字段都需要传递进来
     * @param calendar
     * @return
     */
    OAResoult insertCalendar(Calendar calendar) throws NullNameException;

    /**
     * 只允许修改日程起始时间,和行程大概内容,行程级别,附件
     * @param calendarStarttime 行程开始时间
     * @param calendarSendtime  行程结束时间
     * @param calendarType      行程级别
     * @param calendarContent   行程内容
     * @param calendarAdjuncturl 附件
     * @param cid           行程id
     * @return
     */
    OAResoult updateCalendar(Date calendarStarttime,Date calendarSendtime,String calendarType,String calendarContent,String calendarAdjuncturl,String cid) throws NullNameException;
}
