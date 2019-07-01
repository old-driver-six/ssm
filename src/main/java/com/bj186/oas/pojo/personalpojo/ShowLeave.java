package com.bj186.oas.pojo.personalpojo;

import java.io.Serializable;

/**
 * 请假简略信息!
 */
public class ShowLeave extends StaffInfo implements Serializable {
    private Long leaveCeatetime;    //创建情假条的时间戳
    private String leaveState;  //请假最终状态:0为同意,1位驳回
    private Integer leaveTime;  //请假时间(单位天)
    private String leaveId;     //请假表id

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public Long getLeaveCeatetime() {
        return leaveCeatetime;
    }

    public void setLeaveCeatetime(Long leaveCeatetime) {
        this.leaveCeatetime = leaveCeatetime;
    }

    public String getLeaveState() {
        return leaveState;
    }

    public void setLeaveState(String leaveState) {
        this.leaveState = leaveState;
    }

    public Integer getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Integer leaveTime) {
        this.leaveTime = leaveTime;
    }

    @Override
    public String toString() {
        return "ShowLeave{" +
                "leaveCeatetime=" + leaveCeatetime +
                ", leaveState='" + leaveState + '\'' +
                ", leaveTime=" + leaveTime +
                ", leaveId='" + leaveId + '\'' +
                '}';
    }
}
