package com.bj186.oas.pojo;

import com.bj186.oas.entity.common.NoticeInsertBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Announcements{
    /**
     * 公告ID
     */
    private Integer announcementsId;

    /**
     * 通告时间
     */
    private Date announcementsDate;

    /**
     * 公告内容
     */
    private String announcementsContent;

    /**
     * 通告人ID(外键到staff)
     */
    private Integer announcementsNotifierid;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getNotifieridName() {
        return notifieridName;
    }

    public void setNotifieridName(String notifieridName) {
        this.notifieridName = notifieridName;
    }

    /**
     * 通告人名称
     */
    private String notifieridName;

    /**
     * 公告标题
     */
    private String announcementsTopic;

    /**
     * 
     */
    private Integer announcementsState;

    /**
     *可见部门
     */
    private List<Department> departments = new ArrayList<>();

    /**
     * 公告ID
     * @return announcements_id 公告ID
     */
    public Integer getAnnouncementsId() {
        return announcementsId;
    }

    /**
     * 公告ID
     * @param announcementsId 公告ID
     */
    public void setAnnouncementsId(Integer announcementsId) {
        this.announcementsId = announcementsId;
    }

    /**
     * 通告时间
     * @return announcements_date 通告时间
     */
    public Date getAnnouncementsDate() {
        return announcementsDate;
    }

    /**
     * 通告时间
     * @param announcementsDate 通告时间
     */
    public void setAnnouncementsDate(Date announcementsDate) {
        this.announcementsDate = announcementsDate;
    }

    /**
     * 公告内容
     * @return announcements_content 公告内容
     */
    public String getAnnouncementsContent() {
        return announcementsContent;
    }

    /**
     * 公告内容
     * @param announcementsContent 公告内容
     */
    public void setAnnouncementsContent(String announcementsContent) {
        this.announcementsContent = announcementsContent == null ? null : announcementsContent.trim();
    }

    /**
     * 通告人ID(外键到staff)
     * @return announcements_notifierId 通告人ID(外键到staff)
     */
    public Integer getAnnouncementsNotifierid() {
        return announcementsNotifierid;
    }

    /**
     * 通告人ID(外键到staff)
     * @param announcementsNotifierid 通告人ID(外键到staff)
     */
    public void setAnnouncementsNotifierid(Integer announcementsNotifierid) {
        this.announcementsNotifierid = announcementsNotifierid;
    }

    /**
     * 公告标题
     * @return announcements_topic 公告标题
     */
    public String getAnnouncementsTopic() {
        return announcementsTopic;
    }

    /**
     * 公告标题
     * @param announcementsTopic 公告标题
     */
    public void setAnnouncementsTopic(String announcementsTopic) {
        this.announcementsTopic = announcementsTopic == null ? null : announcementsTopic.trim();
    }

    /**
     * 
     * @return announcements_state 
     */
    public Integer getAnnouncementsState() {
        return announcementsState;
    }

    /**
     * 
     * @param announcementsState 
     */
    public void setAnnouncementsState(Integer announcementsState) {
        this.announcementsState = announcementsState;
    }

    @Override
    public String toString() {
        return "Announcements{" +
                "announcementsId=" + announcementsId +
                ", announcementsDate=" + announcementsDate +
                ", announcementsContent='" + announcementsContent + '\'' +
                ", announcementsNotifierid=" + announcementsNotifierid +
                ", announcementsTopic='" + announcementsTopic + '\'' +
                ", announcementsState=" + announcementsState +
                '}';
    }
}