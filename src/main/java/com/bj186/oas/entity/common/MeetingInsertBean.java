package com.bj186.oas.entity.common;

import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.pojo.Meeting;

import java.util.List;

public class MeetingInsertBean extends Meeting {
    private List<String> depNames;

    public List<String> getDepNames() {
        return depNames;
    }

    public void setDepNames(List<String> departments) {
        this.depNames = departments;
    }
}
