package com.bj186.oas.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Leave {
    /**
     * UUID的请假id
     */
    private String leaveId;

    /**
     * 请假员工的id外键关联员工表
     */
    private Integer leaveStaffId;

    /**
     * 请假紧急程度
     */
    private String leaveProcessing;

    /**
     * 请假标题
     */
    private String leaveTitle;

    /**
     * 请假类型:0,事假;1,年假,2,婚假;3,产假;4:病假;5:其他;
     */
    private String leaveType;

    /**
     * 请假时间(单位天)
     */
    private Integer leaveTime;

    /**
     * 请假起始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date leaveStarttime;

    /**
     * 请假结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date leaveSendtime;

    /**
     * 请假最终状态:0为同意,1位驳回
     */
    private String leaveState;

    /**
     * 创建情假条的时间戳
     */
    private Long leaveCeatetime;

    /**
     * 请假的原因,不能为空
     */
    private String leaveReason;
    private List<LeaveAdvice> leaveAdvices;

    public List<LeaveAdvice> getLeaveAdvices() {
        return leaveAdvices;
    }

    public void setLeaveAdvices(List<LeaveAdvice> leaveAdvices) {
        this.leaveAdvices = leaveAdvices;
    }

    /**
     * UUID的请假id
     * @return leave_Id UUID的请假id
     */
    public String getLeaveId() {
        return leaveId;
    }

    /**
     * UUID的请假id
     * @param leaveId UUID的请假id
     */
    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId == null ? null : leaveId.trim();
    }

    /**
     * 请假员工的id外键关联员工表
     * @return leave_staff_id 请假员工的id外键关联员工表
     */
    public Integer getLeaveStaffId() {
        return leaveStaffId;
    }

    /**
     * 请假员工的id外键关联员工表
     * @param leaveStaffId 请假员工的id外键关联员工表
     */
    public void setLeaveStaffId(Integer leaveStaffId) {
        this.leaveStaffId = leaveStaffId;
    }

    /**
     * 请假紧急程度
     * @return leave_processing 请假紧急程度
     */
    public String getLeaveProcessing() {
        return leaveProcessing;
    }

    /**
     * 请假紧急程度
     * @param leaveProcessing 请假紧急程度
     */
    public void setLeaveProcessing(String leaveProcessing) {
        this.leaveProcessing = leaveProcessing == null ? null : leaveProcessing.trim();
    }

    /**
     * 请假标题
     * @return leave_title 请假标题
     */
    public String getLeaveTitle() {
        return leaveTitle;
    }

    /**
     * 请假标题
     * @param leaveTitle 请假标题
     */
    public void setLeaveTitle(String leaveTitle) {
        this.leaveTitle = leaveTitle == null ? null : leaveTitle.trim();
    }

    /**
     * 请假类型:0,事假;1,年假,2,婚假;3,产假;4:病假;5:其他;
     * @return leave_type 请假类型:0,事假;1,年假,2,婚假;3,产假;4:病假;5:其他;
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * 请假类型:0,事假;1,年假,2,婚假;3,产假;4:病假;5:其他;
     * @param leaveType 请假类型:0,事假;1,年假,2,婚假;3,产假;4:病假;5:其他;
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType == null ? null : leaveType.trim();
    }

    /**
     * 请假时间(单位天)
     * @return leave_time 请假时间(单位天)
     */
    public Integer getLeaveTime() {
        return leaveTime;
    }

    /**
     * 请假时间(单位天)
     * @param leaveTime 请假时间(单位天)
     */
    public void setLeaveTime(Integer leaveTime) {
        this.leaveTime = leaveTime;
    }

    /**
     * 请假起始时间
     * @return leave_startTime 请假起始时间
     */

    public Date getLeaveStarttime() {
        return leaveStarttime;
    }

    /**
     * 请假起始时间
     * @param leaveStarttime 请假起始时间
     */
    public void setLeaveStarttime(Date leaveStarttime) {
        this.leaveStarttime = leaveStarttime;
    }

    /**
     * 请假结束时间
     * @return leave_sendTime 请假结束时间
     */
    public Date getLeaveSendtime() {
        return leaveSendtime;
    }

    /**
     * 请假结束时间
     * @param leaveSendtime 请假结束时间
     */
    public void setLeaveSendtime(Date leaveSendtime) {
        this.leaveSendtime = leaveSendtime;
    }

    /**
     * 请假最终状态:0为同意,1位驳回
     * @return leave_state 请假最终状态:0为同意,1位驳回
     */
    public String getLeaveState() {
        return leaveState;
    }

    /**
     * 请假最终状态:0为同意,1位驳回
     * @param leaveState 请假最终状态:0为同意,1位驳回
     */
    public void setLeaveState(String leaveState) {
        this.leaveState = leaveState == null ? null : leaveState.trim();
    }

    /**
     * 创建情假条的时间戳
     * @return leave_ceateTime 创建情假条的时间戳
     */
    public Long getLeaveCeatetime() {
        return leaveCeatetime;
    }

    /**
     * 创建情假条的时间戳
     * @param leaveCeatetime 创建情假条的时间戳
     */
    public void setLeaveCeatetime(Long leaveCeatetime) {
        this.leaveCeatetime = leaveCeatetime;
    }

    /**
     * 请假的原因,不能为空
     * @return leave_reason 请假的原因,不能为空
     */
    public String getLeaveReason() {
        return leaveReason;
    }

    /**
     * 请假的原因,不能为空
     * @param leaveReason 请假的原因,不能为空
     */
    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason == null ? null : leaveReason.trim();
    }

    @Override
    public String toString() {
        return "Leave{" +
                "leaveId='" + leaveId + '\'' +
                ", leaveStaffId=" + leaveStaffId +
                ", leaveProcessing='" + leaveProcessing + '\'' +
                ", leaveTitle='" + leaveTitle + '\'' +
                ", leaveType='" + leaveType + '\'' +
                ", leaveTime=" + leaveTime +
                ", leaveStarttime=" + leaveStarttime +
                ", leaveSendtime=" + leaveSendtime +
                ", leaveState='" + leaveState + '\'' +
                ", leaveCeatetime=" + leaveCeatetime +
                ", leaveReason='" + leaveReason + '\'' +
                ", leaveAdvices=" + leaveAdvices +
                '}';
    }
}