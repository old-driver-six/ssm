package com.bj186.oas.entity.system;

import com.bj186.oas.pojo.Power;
import com.bj186.oas.pojo.Staff;

import java.util.ArrayList;
import java.util.List;

public class User extends Staff {
    private Integer positionId;
    private Integer depId;

    public List<Integer> getPowerIdList() {
        return powerIdList;
    }

    public void setPowerIdList(List<Integer> powerIdList) {
        this.powerIdList = powerIdList;
    }

    private List<Integer> powerIdList = new ArrayList<>();

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

}
