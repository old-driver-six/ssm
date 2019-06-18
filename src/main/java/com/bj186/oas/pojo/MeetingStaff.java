package com.bj186.oas.pojo;

public class MeetingStaff {
    /**
     * 会议参与人详情表id
     */
    private String meetingstaffId;

    /**
     * 会议idw外键关联会议表
     */
    private String meetingstaffMeetingId;

    /**
     * 参与会议的部门,外键关联部门表
     */
    private Integer meetingstaffEmpid;

    /**
     * 如果只是几个人的会议,则可以直接选员工id
     */
    private Integer meetingstaffStffid;

    /**
     * 会议参与人详情表id
     * @return meetingStaff_id 会议参与人详情表id
     */
    public String getMeetingstaffId() {
        return meetingstaffId;
    }

    /**
     * 会议参与人详情表id
     * @param meetingstaffId 会议参与人详情表id
     */
    public void setMeetingstaffId(String meetingstaffId) {
        this.meetingstaffId = meetingstaffId == null ? null : meetingstaffId.trim();
    }

    /**
     * 会议idw外键关联会议表
     * @return meetingStaff_meeting_id 会议idw外键关联会议表
     */
    public String getMeetingstaffMeetingId() {
        return meetingstaffMeetingId;
    }

    /**
     * 会议idw外键关联会议表
     * @param meetingstaffMeetingId 会议idw外键关联会议表
     */
    public void setMeetingstaffMeetingId(String meetingstaffMeetingId) {
        this.meetingstaffMeetingId = meetingstaffMeetingId == null ? null : meetingstaffMeetingId.trim();
    }

    /**
     * 参与会议的部门,外键关联部门表
     * @return meetingStaff_empid 参与会议的部门,外键关联部门表
     */
    public Integer getMeetingstaffEmpid() {
        return meetingstaffEmpid;
    }

    /**
     * 参与会议的部门,外键关联部门表
     * @param meetingstaffEmpid 参与会议的部门,外键关联部门表
     */
    public void setMeetingstaffEmpid(Integer meetingstaffEmpid) {
        this.meetingstaffEmpid = meetingstaffEmpid;
    }

    /**
     * 如果只是几个人的会议,则可以直接选员工id
     * @return meetingStaff_stffId 如果只是几个人的会议,则可以直接选员工id
     */
    public Integer getMeetingstaffStffid() {
        return meetingstaffStffid;
    }

    /**
     * 如果只是几个人的会议,则可以直接选员工id
     * @param meetingstaffStffid 如果只是几个人的会议,则可以直接选员工id
     */
    public void setMeetingstaffStffid(Integer meetingstaffStffid) {
        this.meetingstaffStffid = meetingstaffStffid;
    }
}