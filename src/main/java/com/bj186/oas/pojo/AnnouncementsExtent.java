package com.bj186.oas.pojo;

public class AnnouncementsExtent {
    /**
     * 公告范围表id
     */
    private Integer announcementsextentId;

    /**
     * 公告部门ID(外键到department表)
     */
    private Integer announcementsextentDepartmentid;

    /**
     * 公告ID(外键到announcements表)
     */
    private Integer announcementsextentAnnouncementsid;

    /**
     * 公告范围表id
     * @return announcementsExtent_id 公告范围表id
     */
    public Integer getAnnouncementsextentId() {
        return announcementsextentId;
    }

    /**
     * 公告范围表id
     * @param announcementsextentId 公告范围表id
     */
    public void setAnnouncementsextentId(Integer announcementsextentId) {
        this.announcementsextentId = announcementsextentId;
    }

    /**
     * 公告部门ID(外键到department表)
     * @return announcementsExtent_departmentId 公告部门ID(外键到department表)
     */
    public Integer getAnnouncementsextentDepartmentid() {
        return announcementsextentDepartmentid;
    }

    /**
     * 公告部门ID(外键到department表)
     * @param announcementsextentDepartmentid 公告部门ID(外键到department表)
     */
    public void setAnnouncementsextentDepartmentid(Integer announcementsextentDepartmentid) {
        this.announcementsextentDepartmentid = announcementsextentDepartmentid;
    }

    /**
     * 公告ID(外键到announcements表)
     * @return announcementsExtent_announcementsId 公告ID(外键到announcements表)
     */
    public Integer getAnnouncementsextentAnnouncementsid() {
        return announcementsextentAnnouncementsid;
    }

    /**
     * 公告ID(外键到announcements表)
     * @param announcementsextentAnnouncementsid 公告ID(外键到announcements表)
     */
    public void setAnnouncementsextentAnnouncementsid(Integer announcementsextentAnnouncementsid) {
        this.announcementsextentAnnouncementsid = announcementsextentAnnouncementsid;
    }
}