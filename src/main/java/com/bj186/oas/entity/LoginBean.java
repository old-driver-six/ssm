package com.bj186.oas.entity;

public class LoginBean {
    private Integer uId;
    private String staffName;
    private String depName;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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

    @Override
    public String toString() {
        return "LoginBean{" +
                "uId=" + uId +
                ", staffName='" + staffName + '\'' +
                ", depName='" + depName + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
