package com.bj186.oas.pojo;

public class Power {
    /**
     * 权限编号（自增主键）
     */
    private Integer powerId;

    /**
     * 权限名称
     */
    private String powerName;

    /**
     * 权限编号（自增主键）
     * @return power_id 权限编号（自增主键）
     */
    public Integer getPowerId() {
        return powerId;
    }

    /**
     * 权限编号（自增主键）
     * @param powerId 权限编号（自增主键）
     */
    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    /**
     * 权限名称
     * @return power_name 权限名称
     */
    public String getPowerName() {
        return powerName;
    }

    /**
     * 权限名称
     * @param powerName 权限名称
     */
    public void setPowerName(String powerName) {
        this.powerName = powerName == null ? null : powerName.trim();
    }
}