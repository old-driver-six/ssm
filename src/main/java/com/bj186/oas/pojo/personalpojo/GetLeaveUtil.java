package com.bj186.oas.pojo.personalpojo;

import java.sql.Timestamp;

/**
 * 请假条件查询工具类
 */
public class GetLeaveUtil {
    private Integer sid;            //通过用户id查询
    private Integer leaveTime;      //请假天数查询下
    private Integer sendTime;       //请假天数查询上
    private Timestamp createDate;   //请假起始范围日期1
    private Timestamp sendDate;     //请假起始范围日期1
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
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
}
