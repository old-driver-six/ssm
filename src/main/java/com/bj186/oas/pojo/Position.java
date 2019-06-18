package com.bj186.oas.pojo;

public class Position {
    /**
     * 职位ID
     */
    private Integer positionId;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 职位简介
     */
    private String positionDescribe;

    /**
     * 职位ID
     * @return position_id 职位ID
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * 职位ID
     * @param positionId 职位ID
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * 职位名称
     * @return position_name 职位名称
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * 职位名称
     * @param positionName 职位名称
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    /**
     * 职位简介
     * @return position_describe 职位简介
     */
    public String getPositionDescribe() {
        return positionDescribe;
    }

    /**
     * 职位简介
     * @param positionDescribe 职位简介
     */
    public void setPositionDescribe(String positionDescribe) {
        this.positionDescribe = positionDescribe == null ? null : positionDescribe.trim();
    }
}