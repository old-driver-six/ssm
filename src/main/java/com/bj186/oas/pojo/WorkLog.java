package com.bj186.oas.pojo;

import com.bj186.oas.pojo.personalpojo.Paging;

import java.util.Date;

public class WorkLog {
    private Paging paging;

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    /**
     * 工作日志ID(自增)
     */
    private Integer worklogId;

    /**
     * 日志名称
     */
    private String worklogName;

    /**
     * 创建时间
     */
    private Date worklogCreatedate;

    /**
     * 日志修改时间
     */
    private Date worklogUpdatetime;

    /**
     * 创建人ID（外键 一对一 对应员工表id）
     */
    private Integer worklogCreateid;

    /**
     * 日志内容
     */
    private String worklogContent;

    /**
     * 工作日志ID(自增)
     * @return worklog_id 工作日志ID(自增)
     */
    public Integer getWorklogId() {
        return worklogId;
    }

    /**
     * 工作日志ID(自增)
     * @param worklogId 工作日志ID(自增)
     */
    public void setWorklogId(Integer worklogId) {
        this.worklogId = worklogId;
    }

    /**
     * 日志名称
     * @return worklog_name 日志名称
     */
    public String getWorklogName() {
        return worklogName;
    }

    /**
     * 日志名称
     * @param worklogName 日志名称
     */
    public void setWorklogName(String worklogName) {
        this.worklogName = worklogName == null ? null : worklogName.trim();
    }

    /**
     * 创建时间
     * @return worklog_createdate 创建时间
     */
    public Date getWorklogCreatedate() {
        return worklogCreatedate;
    }

    /**
     * 创建时间
     * @param worklogCreatedate 创建时间
     */
    public void setWorklogCreatedate(Date worklogCreatedate) {
        this.worklogCreatedate = worklogCreatedate;
    }

    /**
     * 日志修改时间
     * @return worklog_updatetime 日志修改时间
     */
    public Date getWorklogUpdatetime() {
        return worklogUpdatetime;
    }

    /**
     * 日志修改时间
     * @param worklogUpdatetime 日志修改时间
     */
    public void setWorklogUpdatetime(Date worklogUpdatetime) {
        this.worklogUpdatetime = worklogUpdatetime;
    }

    /**
     * 创建人ID（外键 一对一 对应员工表id）
     * @return worklog_createID 创建人ID（外键 一对一 对应员工表id）
     */
    public Integer getWorklogCreateid() {
        return worklogCreateid;
    }

    /**
     * 创建人ID（外键 一对一 对应员工表id）
     * @param worklogCreateid 创建人ID（外键 一对一 对应员工表id）
     */
    public void setWorklogCreateid(Integer worklogCreateid) {
        this.worklogCreateid = worklogCreateid;
    }

    /**
     * 日志内容
     * @return worklog_content 日志内容
     */
    public String getWorklogContent() {
        return worklogContent;
    }

    /**
     * 日志内容
     * @param worklogContent 日志内容
     */
    public void setWorklogContent(String worklogContent) {
        this.worklogContent = worklogContent == null ? null : worklogContent.trim();
    }

}