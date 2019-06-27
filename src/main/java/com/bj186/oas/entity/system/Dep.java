package com.bj186.oas.entity.system;

public class Dep {
    /**
     * 部门编号（自增主键）
     */
    private Integer depId;

    /**
     * 部门名称
     */
    private String depName;

    @Override
    public String toString() {
        return "Dep{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", staffName='" + staffName + '\'' +
                ", depNumber=" + depNumber +
                ", depDescribe='" + depDescribe + '\'' +
                '}';
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getDepNumber() {
        return depNumber;
    }

    public void setDepNumber(Integer depNumber) {
        this.depNumber = depNumber;
    }

    public String getDepDescribe() {
        return depDescribe;
    }

    public void setDepDescribe(String depDescribe) {
        this.depDescribe = depDescribe;
    }

    /**
     * 部门经理
     */
    private String staffName;

    /**
     * 部门人数
     */
    private Integer depNumber;

    /**
     * 部门职能
     */
    private String depDescribe;
}
