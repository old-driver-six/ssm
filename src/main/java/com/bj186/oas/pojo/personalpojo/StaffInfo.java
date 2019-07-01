package com.bj186.oas.pojo.personalpojo;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息和其他表的详细信息
 * @param <T>
 */
public class StaffInfo<T> implements Serializable {
    private String staffName;
    private String depName;
    private String positionName;
    private List<T> dataInfo;

    public List<T> getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(List<T> dataInfo) {
        this.dataInfo = dataInfo;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "StaffInfo{" +
                "staffName='" + staffName + '\'' +
                ", depName='" + depName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", dataInfo=" + dataInfo +
                '}';
    }
}
