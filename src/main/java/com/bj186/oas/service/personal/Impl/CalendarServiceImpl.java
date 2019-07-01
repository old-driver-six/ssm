package com.bj186.oas.service.personal.Impl;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.mapper.CalendarMapper;
import com.bj186.oas.pojo.Calendar;
import com.bj186.oas.service.personal.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
@Service("calendarService")
public class CalendarServiceImpl implements CalendarService {
    @Autowired
    private CalendarMapper calendarMapper;

    /**
     *
     * @param calendar
     * @return
     * @throws NullNameException
     */
    @Override
    public OAResoult insertCalendar(Calendar calendar) throws NullNameException {
        calendar.setCalerdarCreatetime(new Date());
        int selective = calendarMapper.insertSelective(calendar);
        if(selective==0){
            throw new NullNameException("系统故障!请稍后添加!");
        }
        OAResoult resoult=new OAResoult();
        resoult.setCode(0);
        resoult.setMsg("添加日程成功!");
        return resoult;
    }

    /**
     * 只允许修改日程起始时间,和行程大概内容,行程级别,附件
     * @param calendarStarttime 行程开始时间
     * @param calendarSendtime  行程结束时间
     * @param calendarType      行程级别
     * @param calendarContent   行程内容
     * @param calendarAdjuncturl 附件
     * @return
     */
    @Override
    public OAResoult updateCalendar(Date calendarStarttime, Date calendarSendtime, String calendarType, String calendarContent, String calendarAdjuncturl,String cid) throws NullNameException {
        Calendar calendar=new Calendar();
        calendar.setCalendarContent(calendarContent);
        calendar.setCalendarType(calendarType);
        calendar.setCalendarStarttime(calendarStarttime);
        calendar.setCalendarSendtime(calendarSendtime);
        calendar.setCalendarAdjuncturl(calendarAdjuncturl);
        calendar.setCalendarId(cid);
        int selective = calendarMapper.updateByPrimaryKeySelective(calendar);
        if(selective==0){
            throw new NullNameException("系统故障!修改行程失败!请稍后重试!");
        }
        OAResoult resoult=new OAResoult();
        resoult.setCode(0);
        resoult.setMsg("修改行程成功!");
        return resoult;
    }
}
