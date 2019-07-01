package com.bj186.oas.pojo.personalpojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 请假条件查询工具类
 */
public class GetLeaveUtil {
    private Integer sid;            //通过用户id查询
    private Integer leaveTime;      //请假天数查询下
    private Integer sendTime;       //请假天数查询上
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;   //请假起始范围日期1
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date sendDate;     //请假起始范围日期1
    private String livd;            //请假意见id查询
    private String lid;             //请假条id查询

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Integer leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getLivd() {
        return livd;
    }

    public void setLivd(String livd) {
        this.livd = livd;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public Integer getSendTime() {
        return sendTime;
    }

    public void setSendTime(Integer sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "GetLeaveUtil{" +
                "sid=" + sid +
                ", leaveTime=" + leaveTime +
                ", sendTime=" + sendTime +
                ", createDate=" + createDate +
                ", sendDate=" + sendDate +
                ", livd='" + livd + '\'' +
                ", lid='" + lid + '\'' +
                '}';
    }
}
