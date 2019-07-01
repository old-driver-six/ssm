package com.bj186.oas.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Meeting {
    /**
     * 会议id
     */
    private String meetingId;

    /**
     * 会议标题
     */
    private String meetingTitle;

    /**
     * 会议类型
     */
    private String meetingType;

    /**
     * 会议发起人员工
     */
    private Integer meetingStaffId;

    private String staffName;
    private Integer meetingState;

    /**
     *可见部门
     */
    private List<Department> departments = new ArrayList<>();

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getMeetingState() {
        return meetingState;
    }

    public void setMeetingState(Integer meetingState) {
        this.meetingState = meetingState;
    }

    /**
     * 会议位置
     */
    private String meetingLocation;

    /**
     * 会议时间
     */
    private Date meetingTime;

    /**
     * 会议大概内容
     */
    private String meetingContent;

    /**
     * 会议id
     * @return meeting_id 会议id
     */
    public String getMeetingId() {
        return meetingId;
    }

    /**
     * 会议id
     * @param meetingId 会议id
     */
    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId == null ? null : meetingId.trim();
    }

    /**
     * 会议标题
     * @return meeting_title 会议标题
     */
    public String getMeetingTitle() {
        return meetingTitle;
    }

    /**
     * 会议标题
     * @param meetingTitle 会议标题
     */
    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle == null ? null : meetingTitle.trim();
    }

    /**
     * 会议类型
     * @return meeting_type 会议类型
     */
    public String getMeetingType() {
        return meetingType;
    }

    /**
     * 会议类型
     * @param meetingType 会议类型
     */
    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType == null ? null : meetingType.trim();
    }

    /**
     * 会议发起人员工
     * @return meeting_stff_id 会议发起人员工
     */
    public Integer getMeetingStaffId() {
        return meetingStaffId;
    }

    /**
     * 会议发起人员工
     * @param meetingStaffId 会议发起人员工
     */
    public void setMeetingStaffId(Integer meetingStaffId) {
        this.meetingStaffId = meetingStaffId;
    }

    /**
     * 会议位置
     * @return meeting_location 会议位置
     */
    public String getMeetingLocation() {
        return meetingLocation;
    }

    /**
     * 会议位置
     * @param meetingLocation 会议位置
     */
    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation == null ? null : meetingLocation.trim();
    }

    /**
     * 会议时间
     * @return meeting_time 会议时间
     */
    public Date getMeetingTime() {
        return meetingTime;
    }

    /**
     * 会议时间
     * @param meetingTime 会议时间
     */
    public void setMeetingTime(Date meetingTime) {
        this.meetingTime = meetingTime;
    }

    /**
     * 会议大概内容
     * @return meeting_content 会议大概内容
     */
    public String getMeetingContent() {
        return meetingContent;
    }

    /**
     * 会议大概内容
     * @param meetingContent 会议大概内容
     */
    public void setMeetingContent(String meetingContent) {
        this.meetingContent = meetingContent == null ? null : meetingContent.trim();
    }
}