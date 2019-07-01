package com.bj186.oas.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CheckingIn {
    /**
     * 考勤表主键
     */
    private String checkinginId;

    /**
     * 员工ID(关联员表信息,方便查询这个员工的考勤情况)
     */
    private Integer checkStaffId;

    /**
     * 上班时间
     */

    private Date checkinginStarttime;

    /**
     * 下班时间
     */

    private Date checkinginSendtime;

    /**
     * 考勤状态表(0为正常考勤,1为外勤,2为请假,3位不用考勤的日期)
     */
    private String checkinginState;

    /**
     * 考勤表主键
     * @return checkingin_id 考勤表主键
     */
    public String getCheckinginId() {
        return checkinginId;
    }

    /**
     * 考勤表主键
     * @param checkinginId 考勤表主键
     */
    public void setCheckinginId(String checkinginId) {
        this.checkinginId = checkinginId == null ? null : checkinginId.trim();
    }

    /**
     * 员工ID(关联员表信息,方便查询这个员工的考勤情况)
     * @return check_staff_id 员工ID(关联员表信息,方便查询这个员工的考勤情况)
     */
    public Integer getCheckStaffId() {
        return checkStaffId;
    }

    /**
     * 员工ID(关联员表信息,方便查询这个员工的考勤情况)
     * @param checkStaffId 员工ID(关联员表信息,方便查询这个员工的考勤情况)
     */
    public void setCheckStaffId(Integer checkStaffId) {
        this.checkStaffId = checkStaffId;
    }

    /**
     * 上班时间
     * @return checkingin_startTime 上班时间
     */
    public Date getCheckinginStarttime() {
        return checkinginStarttime;
    }

    /**
     * 上班时间
     * @param checkinginStarttime 上班时间
     */
    public void setCheckinginStarttime(Date checkinginStarttime) {
        this.checkinginStarttime = checkinginStarttime;
    }

    /**
     * 下班时间
     * @return checkingin_sendTime 下班时间
     */
    public Date getCheckinginSendtime() {
        return checkinginSendtime;
    }

    /**
     * 下班时间
     * @param checkinginSendtime 下班时间
     */
    public void setCheckinginSendtime(Date checkinginSendtime) {
        this.checkinginSendtime = checkinginSendtime;
    }

    /**
     * 考勤状态表(0为正常考勤,1为外勤,2为请假,3位不用考勤的日期)
     * @return checkingin_state 考勤状态表(0为正常考勤,1为外勤,2为请假,3位不用考勤的日期)
     */
    public String getCheckinginState() {
        return checkinginState;
    }

    /**
     * 考勤状态表(0为正常考勤,1为外勤,2为请假,3位不用考勤的日期)
     * @param checkinginState 考勤状态表(0为正常考勤,1为外勤,2为请假,3位不用考勤的日期)
     */
    public void setCheckinginState(String checkinginState) {
        this.checkinginState = checkinginState == null ? null : checkinginState.trim();
    }

    @Override
    public String
    toString() {
        return "CheckingIn{" +
                "checkinginId='" + checkinginId + '\'' +
                ", checkStaffId=" + checkStaffId +
                ", checkinginStarttime=" + checkinginStarttime +
                ", checkinginSendtime=" + checkinginSendtime +
                ", checkinginState='" + checkinginState + '\'' +
                '}';
    }
}