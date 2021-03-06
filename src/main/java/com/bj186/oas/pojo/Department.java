package com.bj186.oas.pojo;

import java.util.ArrayList;
import java.util.List;

public class Department {
    /**
     * 部门编号（自增主键）
     */
        private Integer depId;

    /**
     * 部门名称
     */
    private String depName;

    /**
     * 部门经理ID
     */
    private Integer depManagerid;

    /**
     * 部门人数
     */
    private Integer depNumber;

    /**
     * 部门职能
     */
    private String depDescribe;

    public List<Announcements> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcements> announcements) {
        this.announcements = announcements;
    }

    /**
     * 公告列表
     */
    private List<Announcements> announcements = new ArrayList<>();
    /**
     * 员工
     */
    private List<Staff> staffList = new ArrayList<>();

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    /**
     * 报销
     */
    private List<Reimburse> reimburses = new ArrayList<>();

    public List<Reimburse> getReimburses() {
        return reimburses;
    }

    public void setReimburses(List<Reimburse> reimburses) {
        this.reimburses = reimburses;
    }


    /**
     * 制度列表
     */
    private List<Rule> rules = new ArrayList<>();

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    /**
     * 部门编号（自增主键）
     * @return dep_id 部门编号（自增主键）
     */
    public Integer getDepId() {
        return depId;
    }

    /**
     * 部门编号（自增主键）
     * @param depId 部门编号（自增主键）
     */
    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    /**
     * 部门名称
     * @return dep_name 部门名称
     */
    public String getDepName() {
        return depName;
    }

    /**
     * 部门名称
     * @param depName 部门名称
     */
    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    /**
     * 部门经理ID
     * @return dep_managerid 部门经理ID
     */
    public Integer getDepManagerid() {
        return depManagerid;
    }

    /**
     * 部门经理ID
     * @param depManagerid 部门经理ID
     */
    public void setDepManagerid(Integer depManagerid) {
        this.depManagerid = depManagerid;
    }

    /**
     * 部门人数
     * @return dep_number 部门人数
     */
    public Integer getDepNumber() {
        return depNumber;
    }

    /**
     * 部门人数
     * @param depNumber 部门人数
     */
    public void setDepNumber(Integer depNumber) {
        this.depNumber = depNumber;
    }

    /**
     * 部门职能
     * @return dep_describe 部门职能
     */
    public String getDepDescribe() {
        return depDescribe;
    }

    /**
     * 部门职能
     * @param depDescribe 部门职能
     */
    public void setDepDescribe(String depDescribe) {
        this.depDescribe = depDescribe == null ? null : depDescribe.trim();
    }
}