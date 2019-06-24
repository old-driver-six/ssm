package com.bj186.oas.pojo.personalpojo;

import java.io.Serializable;

/**
 * 请假意见工具类,里面存放了请假的意见id和请假最终状态
 */
public class LeaveOpinionUtil implements Serializable {
    private String leaveState;          //请假最终状态
    private String leaveadviceId;       //请假意见id
    private Integer leaveTime;          //请假天数
    private Integer sid;                //请假人id

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

    public String getLeaveState() {
        return leaveState;
    }

    public void setLeaveState(String leaveState) {
        this.leaveState = leaveState;
    }

    public String getLeaveadviceId() {
        return leaveadviceId;
    }

    public void setLeaveadviceId(String leaveadviceId) {
        this.leaveadviceId = leaveadviceId;
    }

    @Override
    public String toString() {
        return "LeaveOpinionUtil{" +
                "leaveState='" + leaveState + '\'' +
                ", leaveadviceId='" + leaveadviceId + '\'' +
                ", leaveTime=" + leaveTime +
                ", sid=" + sid +
                '}';
    }
}
