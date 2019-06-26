package com.bj186.oas.entity.common;

import com.bj186.oas.pojo.Announcements;

import java.util.List;

public class NoticeInsertBean extends Announcements{
    private Integer uId;
    private List<String> depNames;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uID) {
        this.uId = uID;
    }

    public List<String> getDepNames() {
        return depNames;
    }

    public void setDepNames(List<String> departments) {
        this.depNames = departments;
    }
}
