package com.bj186.oas.pojo;

public class StaffPower {
    /**
     * 用户权限表ID（自增主键）
     */
    private Integer spId;

    /**
     * 员工ID
     */
    private Integer spStaffid;

    /**
     * 权限D
     */
    private Integer spPowerid;

    /**
     * 用户权限表ID（自增主键）
     * @return sp_id 用户权限表ID（自增主键）
     */
    public Integer getSpId() {
        return spId;
    }

    /**
     * 用户权限表ID（自增主键）
     * @param spId 用户权限表ID（自增主键）
     */
    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    /**
     * 员工ID
     * @return sp_staffID 员工ID
     */
    public Integer getSpStaffid() {
        return spStaffid;
    }

    /**
     * 员工ID
     * @param spStaffid 员工ID
     */
    public void setSpStaffid(Integer spStaffid) {
        this.spStaffid = spStaffid;
    }

    /**
     * 权限D
     * @return sp_powerID 权限D
     */
    public Integer getSpPowerid() {
        return spPowerid;
    }

    /**
     * 权限D
     * @param spPowerid 权限D
     */
    public void setSpPowerid(Integer spPowerid) {
        this.spPowerid = spPowerid;
    }
}