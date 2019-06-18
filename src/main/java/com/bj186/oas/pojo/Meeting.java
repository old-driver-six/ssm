package com.bj186.oas.pojo;

import java.util.Date;

public class Meeting {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oas_meeting.meeting_id
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    private String meetingId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oas_meeting.meeting_title
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    private String meetingTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oas_meeting.meeting_type
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    private String meetingType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oas_meeting.meeting_stff_id
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    private Integer meetingStffId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oas_meeting.meeting_location
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    private String meetingLocation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oas_meeting.meeting_time
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    private Date meetingTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oas_meeting.meeting_content
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    private String meetingContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oas_meeting.meeting_id
     *
     * @return the value of oas_meeting.meeting_id
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public String getMeetingId() {
        return meetingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oas_meeting.meeting_id
     *
     * @param meetingId the value for oas_meeting.meeting_id
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId == null ? null : meetingId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oas_meeting.meeting_title
     *
     * @return the value of oas_meeting.meeting_title
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public String getMeetingTitle() {
        return meetingTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oas_meeting.meeting_title
     *
     * @param meetingTitle the value for oas_meeting.meeting_title
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle == null ? null : meetingTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oas_meeting.meeting_type
     *
     * @return the value of oas_meeting.meeting_type
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public String getMeetingType() {
        return meetingType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oas_meeting.meeting_type
     *
     * @param meetingType the value for oas_meeting.meeting_type
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType == null ? null : meetingType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oas_meeting.meeting_stff_id
     *
     * @return the value of oas_meeting.meeting_stff_id
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public Integer getMeetingStffId() {
        return meetingStffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oas_meeting.meeting_stff_id
     *
     * @param meetingStffId the value for oas_meeting.meeting_stff_id
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public void setMeetingStffId(Integer meetingStffId) {
        this.meetingStffId = meetingStffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oas_meeting.meeting_location
     *
     * @return the value of oas_meeting.meeting_location
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public String getMeetingLocation() {
        return meetingLocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oas_meeting.meeting_location
     *
     * @param meetingLocation the value for oas_meeting.meeting_location
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation == null ? null : meetingLocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oas_meeting.meeting_time
     *
     * @return the value of oas_meeting.meeting_time
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public Date getMeetingTime() {
        return meetingTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oas_meeting.meeting_time
     *
     * @param meetingTime the value for oas_meeting.meeting_time
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public void setMeetingTime(Date meetingTime) {
        this.meetingTime = meetingTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oas_meeting.meeting_content
     *
     * @return the value of oas_meeting.meeting_content
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public String getMeetingContent() {
        return meetingContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oas_meeting.meeting_content
     *
     * @param meetingContent the value for oas_meeting.meeting_content
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    public void setMeetingContent(String meetingContent) {
        this.meetingContent = meetingContent == null ? null : meetingContent.trim();
    }
}