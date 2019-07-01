package com.bj186.oas.pojo;

public class MeetingStaff {
    /**
     * 会议idw外键关联会议表
     */
    private String meetingstaffMeetingId;

    /**
     * 参与会议的部门,外键关联部门表
     */
    private Integer meetingstaffEmpid;

    public String getMeetingstaffMeetingId() {
        return meetingstaffMeetingId;
    }

    public void setMeetingstaffMeetingId(String meetingstaffMeetingId) {
        this.meetingstaffMeetingId = meetingstaffMeetingId;
    }

    public Integer getMeetingstaffEmpid() {
        return meetingstaffEmpid;
    }

    public void setMeetingstaffEmpid(Integer meetingstaffEmpid) {
        this.meetingstaffEmpid = meetingstaffEmpid;
    }
}