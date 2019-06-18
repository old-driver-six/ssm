package com.bj186.oas.pojo;

public class LeaveAdvice {
    /**
     * 请假意见的id
     */
    private String leaveadviceId;

    /**
     * 请假条的id,外键关联请假条信息,一张请假条多个意见
     */
    private String advicelid;

    /**
     * 部门意见
     */
    private String advicepart;

    /**
     * 人事意见
     */
    private String advicesum;

    /**
     * 小组意见
     */
    private String advicegroup;

    /**
     * 小组意见状态:0:为同意,1为不同意
     */
    private String advicegroupstate;

    /**
     * 部门意见状态:0:为同意,1为不同意
     */
    private String advicepartstate;

    /**
     * 人事意见状态:0:为同意,1为不同意
     */
    private String advicesumstate;

    /**
     * 请假意见的id
     * @return leaveAdvice_id 请假意见的id
     */
    public String getLeaveadviceId() {
        return leaveadviceId;
    }

    /**
     * 请假意见的id
     * @param leaveadviceId 请假意见的id
     */
    public void setLeaveadviceId(String leaveadviceId) {
        this.leaveadviceId = leaveadviceId == null ? null : leaveadviceId.trim();
    }

    /**
     * 请假条的id,外键关联请假条信息,一张请假条多个意见
     * @return advicelid 请假条的id,外键关联请假条信息,一张请假条多个意见
     */
    public String getAdvicelid() {
        return advicelid;
    }

    /**
     * 请假条的id,外键关联请假条信息,一张请假条多个意见
     * @param advicelid 请假条的id,外键关联请假条信息,一张请假条多个意见
     */
    public void setAdvicelid(String advicelid) {
        this.advicelid = advicelid == null ? null : advicelid.trim();
    }

    /**
     * 部门意见
     * @return advicePart 部门意见
     */
    public String getAdvicepart() {
        return advicepart;
    }

    /**
     * 部门意见
     * @param advicepart 部门意见
     */
    public void setAdvicepart(String advicepart) {
        this.advicepart = advicepart == null ? null : advicepart.trim();
    }

    /**
     * 人事意见
     * @return adviceSum 人事意见
     */
    public String getAdvicesum() {
        return advicesum;
    }

    /**
     * 人事意见
     * @param advicesum 人事意见
     */
    public void setAdvicesum(String advicesum) {
        this.advicesum = advicesum == null ? null : advicesum.trim();
    }

    /**
     * 小组意见
     * @return adviceGroup 小组意见
     */
    public String getAdvicegroup() {
        return advicegroup;
    }

    /**
     * 小组意见
     * @param advicegroup 小组意见
     */
    public void setAdvicegroup(String advicegroup) {
        this.advicegroup = advicegroup == null ? null : advicegroup.trim();
    }

    /**
     * 小组意见状态:0:为同意,1为不同意
     * @return adviceGroupState 小组意见状态:0:为同意,1为不同意
     */
    public String getAdvicegroupstate() {
        return advicegroupstate;
    }

    /**
     * 小组意见状态:0:为同意,1为不同意
     * @param advicegroupstate 小组意见状态:0:为同意,1为不同意
     */
    public void setAdvicegroupstate(String advicegroupstate) {
        this.advicegroupstate = advicegroupstate == null ? null : advicegroupstate.trim();
    }

    /**
     * 部门意见状态:0:为同意,1为不同意
     * @return advicePartState 部门意见状态:0:为同意,1为不同意
     */
    public String getAdvicepartstate() {
        return advicepartstate;
    }

    /**
     * 部门意见状态:0:为同意,1为不同意
     * @param advicepartstate 部门意见状态:0:为同意,1为不同意
     */
    public void setAdvicepartstate(String advicepartstate) {
        this.advicepartstate = advicepartstate == null ? null : advicepartstate.trim();
    }

    /**
     * 人事意见状态:0:为同意,1为不同意
     * @return adviceSumState 人事意见状态:0:为同意,1为不同意
     */
    public String getAdvicesumstate() {
        return advicesumstate;
    }

    /**
     * 人事意见状态:0:为同意,1为不同意
     * @param advicesumstate 人事意见状态:0:为同意,1为不同意
     */
    public void setAdvicesumstate(String advicesumstate) {
        this.advicesumstate = advicesumstate == null ? null : advicesumstate.trim();
    }
}