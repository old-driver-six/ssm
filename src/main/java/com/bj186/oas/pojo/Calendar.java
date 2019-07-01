package com.bj186.oas.pojo;

import java.util.Date;

public class Calendar {
    /**
     * 日程id
     */
    private String calendarId;

    /**
     * 员工信息
     */
    private Integer calendarStffId;

    /**
     * 事务类型
     */
    private String calendarType;

    /**
     * 开始时间
     */
    private Date calendarStarttime;

    /**
     * 结束时间
     */
    private Date calendarSendtime;

    /**
     * 附件在服务器的地址
     */
    private String calendarAdjuncturl;

    /**
     * 日程创建时间
     */
    private Date calerdarCreatetime;

    /**
     * 日程类容
     */
    private String calendarContent;

    /**
     * 日程id
     * @return calendar_id 日程id
     */
    public String getCalendarId() {
        return calendarId;
    }

    /**
     * 日程id
     * @param calendarId 日程id
     */
    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId == null ? null : calendarId.trim();
    }

    /**
     * 员工信息
     * @return calendar_stff_id 员工信息
     */
    public Integer getCalendarStffId() {
        return calendarStffId;
    }

    /**
     * 员工信息
     * @param calendarStffId 员工信息
     */
    public void setCalendarStffId(Integer calendarStffId) {
        this.calendarStffId = calendarStffId;
    }

    /**
     * 事务类型
     * @return calendar_type 事务类型
     */
    public String getCalendarType() {
        return calendarType;
    }

    /**
     * 事务类型
     * @param calendarType 事务类型
     */
    public void setCalendarType(String calendarType) {
        this.calendarType = calendarType == null ? null : calendarType.trim();
    }

    /**
     * 开始时间
     * @return calendar_startTime 开始时间
     */
    public Date getCalendarStarttime() {
        return calendarStarttime;
    }

    /**
     * 开始时间
     * @param calendarStarttime 开始时间
     */
    public void setCalendarStarttime(Date calendarStarttime) {
        this.calendarStarttime = calendarStarttime;
    }

    /**
     * 结束时间
     * @return calendar_sendTime 结束时间
     */
    public Date getCalendarSendtime() {
        return calendarSendtime;
    }

    /**
     * 结束时间
     * @param calendarSendtime 结束时间
     */
    public void setCalendarSendtime(Date calendarSendtime) {
        this.calendarSendtime = calendarSendtime;
    }

    /**
     * 附件在服务器的地址
     * @return calendar_adjunctUrl 附件在服务器的地址
     */
    public String getCalendarAdjuncturl() {
        return calendarAdjuncturl;
    }

    /**
     * 附件在服务器的地址
     * @param calendarAdjuncturl 附件在服务器的地址
     */
    public void setCalendarAdjuncturl(String calendarAdjuncturl) {
        this.calendarAdjuncturl = calendarAdjuncturl == null ? null : calendarAdjuncturl.trim();
    }

    /**
     * 日程创建时间
     * @return calerdar_createTime 日程创建时间
     */
    public Date getCalerdarCreatetime() {
        return calerdarCreatetime;
    }

    /**
     * 日程创建时间
     * @param calerdarCreatetime 日程创建时间
     */
    public void setCalerdarCreatetime(Date calerdarCreatetime) {
        this.calerdarCreatetime = calerdarCreatetime;
    }

    /**
     * 日程类容
     * @return calendar_content 日程类容
     */
    public String getCalendarContent() {
        return calendarContent;
    }

    /**
     * 日程类容
     * @param calendarContent 日程类容
     */
    public void setCalendarContent(String calendarContent) {
        this.calendarContent = calendarContent == null ? null : calendarContent.trim();
    }
}