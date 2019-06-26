package com.bj186.oas.pojo;

import java.util.Date;

public class Rule {
    /**
     * 规章表ID
     */
    private Integer ruleId;

    /**
     * 规章部门id(外键到department)
     */
    private Integer ruleDepartmentid;

    /**
     * 制定人ID(外键到staff)
     */
    private Integer ruleCreatorid;

    /**
     * 制定人
     */
    private String ruleName;

    /**
     * 发布时间
     */
    private Date ruleReleasedate;

    /**
     * 制度标题
     */
    private String ruleTitle;

    /**
     * 状态
     */
    private Integer ruleState;

    /**
     * 规章表内容
     */
    private String ruleContent;

    /**
     * 规章表ID
     * @return rule_id 规章表ID
     */
    public Integer getRuleId() {
        return ruleId;
    }

    /**
     * 规章表ID
     * @param ruleId 规章表ID
     */
    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 规章部门id(外键到department)
     * @return rule_departmentId 规章部门id(外键到department)
     */
    public Integer getRuleDepartmentid() {
        return ruleDepartmentid;
    }

    /**
     * 规章部门id(外键到department)
     * @param ruleDepartmentid 规章部门id(外键到department)
     */
    public void setRuleDepartmentid(Integer ruleDepartmentid) {
        this.ruleDepartmentid = ruleDepartmentid;
    }

    /**
     * 制定人ID(外键到staff)
     * @return rule_creatorId 制定人ID(外键到staff)
     */
    public Integer getRuleCreatorid() {
        return ruleCreatorid;
    }

    /**
     * 制定人ID(外键到staff)
     * @param ruleCreatorid 制定人ID(外键到staff)
     */
    public void setRuleCreatorid(Integer ruleCreatorid) {
        this.ruleCreatorid = ruleCreatorid;
    }

    /**
     * 制定人
     * @return rule_creator 制定人
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * 制定人
     * @param ruleCreator 制定人
     */
    public void setRuleName(String ruleCreator) {
        this.ruleName = ruleCreator == null ? null : ruleCreator.trim();
    }

    /**
     * 发布时间
     * @return rule_releaseDate 发布时间
     */
    public Date getRuleReleasedate() {
        return ruleReleasedate;
    }

    /**
     * 发布时间
     * @param ruleReleasedate 发布时间
     */
    public void setRuleReleasedate(Date ruleReleasedate) {
        this.ruleReleasedate = ruleReleasedate;
    }

    /**
     * 制度标题
     * @return rule_title 制度标题
     */
    public String getRuleTitle() {
        return ruleTitle;
    }

    /**
     * 制度标题
     * @param ruleTitle 制度标题
     */
    public void setRuleTitle(String ruleTitle) {
        this.ruleTitle = ruleTitle == null ? null : ruleTitle.trim();
    }

    /**
     * 状态
     * @return rule_state 状态
     */
    public Integer getRuleState() {
        return ruleState;
    }

    /**
     * 状态
     * @param ruleState 状态
     */
    public void setRuleState(Integer ruleState) {
        this.ruleState = ruleState;
    }

    /**
     * 规章表内容
     * @return rule_content 规章表内容
     */
    public String getRuleContent() {
        return ruleContent;
    }

    /**
     * 规章表内容
     * @param ruleContent 规章表内容
     */
    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent == null ? null : ruleContent.trim();
    }
}