package com.bj186.oas.entity.common;

import com.bj186.oas.pojo.Announcements;

import java.util.List;

public class NoticeInsertBean{
    private Integer uId;
    private List<String> departments;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uID) {
        this.uId = uID;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }
}
