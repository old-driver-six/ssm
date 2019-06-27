package com.bj186.oas.entity.common;

import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.pojo.Rule;

import java.util.List;

public class RuleInsertBean extends Rule {
    private Integer uId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uID) {
        this.uId = uID;
    }
}
