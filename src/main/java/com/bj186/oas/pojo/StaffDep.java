package com.bj186.oas.pojo;

public class StaffDep {
    /**
     * 自增主键
     */
    private Integer sdId;

    /**
     * 员工ID（外键  员工表）
     */
    private Integer sdStaffid;

    /**
     * 部门ID(外键  一个员工对应一个部门)
     */
    private Integer sdDepid;

    /**
     * 自增主键
     * @return sd_id 自增主键
     */
    public Integer getSdId() {
        return sdId;
    }

    /**
     * 自增主键
     * @param sdId 自增主键
     */
    public void setSdId(Integer sdId) {
        this.sdId = sdId;
    }

    /**
     * 员工ID（外键  员工表）
     * @return sd_staffId 员工ID（外键  员工表）
     */
    public Integer getSdStaffid() {
        return sdStaffid;
    }

    /**
     * 员工ID（外键  员工表）
     * @param sdStaffid 员工ID（外键  员工表）
     */
    public void setSdStaffid(Integer sdStaffid) {
        this.sdStaffid = sdStaffid;
    }

    /**
     * 部门ID(外键  一个员工对应一个部门)
     * @return sd_depId 部门ID(外键  一个员工对应一个部门)
     */
    public Integer getSdDepid() {
        return sdDepid;
    }

    /**
     * 部门ID(外键  一个员工对应一个部门)
     * @param sdDepid 部门ID(外键  一个员工对应一个部门)
     */
    public void setSdDepid(Integer sdDepid) {
        this.sdDepid = sdDepid;
    }
}