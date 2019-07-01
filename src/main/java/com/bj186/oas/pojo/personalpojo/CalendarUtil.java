package com.bj186.oas.pojo.personalpojo;

import com.bj186.oas.pojo.Calendar;

import java.io.Serializable;

/**
 * 查出需要的数据!
 */
public class CalendarUtil extends Calendar implements Serializable {
    private StaffInfo staffInfo;

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }
}
