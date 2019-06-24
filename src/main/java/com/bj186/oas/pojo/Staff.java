package com.bj186.oas.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Staff {
    /**
     * 员工ID（主键 10001自增）
     */
    private Integer staffId;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 员工性别 1为男 0为女
     */
    private String staffSex;

    /**
     * 员工年龄
     */
    private Byte staffAge;

    /**
     * 员工联系方式
     */
    private String staffPhone;

    /**
     * 员工身份证号
     */
    private String staffIdntitycardid;

    /**
     * 员工生日
     */
    private Date staffBirthday;

    /**
     * 员工职位(外键对应职位表)
     */
    private Integer staffPositionid;

    /**
     * 员工地址
     */
    private String staffAdress;

    /**
     * 员工基础工资（例如 5k）
     */
    private String staffWage;

    /**
     * 员工邮箱
     */
    private String staffEmail;

    /**
     * 部门
     */
    private Department department;

    /**
     * 职务
     */
    private Position position;

    /**
     * 权限
     */
    private List<Power> powerList = new ArrayList<>();

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Power> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<Power> powerList) {
        this.powerList = powerList;
    }

    /**
     * 员工ID（主键 10001自增）
     * @return staff_id 员工ID（主键 10001自增）
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * 员工ID（主键 10001自增）
     * @param staffId 员工ID（主键 10001自增）
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * 员工姓名
     * @return staff_name 员工姓名
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 员工姓名
     * @param staffName 员工姓名
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    /**
     * 员工性别 1为男 0为女
     * @return staff_sex 员工性别 1为男 0为女
     */
    public String getStaffSex() {
        return staffSex;
    }

    /**
     * 员工性别 1为男 0为女
     * @param staffSex 员工性别 1为男 0为女
     */
    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex == null ? null : staffSex.trim();
    }

    /**
     * 员工年龄
     * @return staff_age 员工年龄
     */
    public Byte getStaffAge() {
        return staffAge;
    }

    /**
     * 员工年龄
     * @param staffAge 员工年龄
     */
    public void setStaffAge(Byte staffAge) {
        this.staffAge = staffAge;
    }

    /**
     * 员工联系方式
     * @return staff_phone 员工联系方式
     */
    public String getStaffPhone() {
        return staffPhone;
    }

    /**
     * 员工联系方式
     * @param staffPhone 员工联系方式
     */
    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone == null ? null : staffPhone.trim();
    }

    /**
     * 员工身份证号
     * @return staff_idntityCardID 员工身份证号
     */
    public String getStaffIdntitycardid() {
        return staffIdntitycardid;
    }

    /**
     * 员工身份证号
     * @param staffIdntitycardid 员工身份证号
     */
    public void setStaffIdntitycardid(String staffIdntitycardid) {
        this.staffIdntitycardid = staffIdntitycardid == null ? null : staffIdntitycardid.trim();
    }

    /**
     * 员工生日
     * @return staff_birthday 员工生日
     */
    public Date getStaffBirthday() {
        return staffBirthday;
    }

    /**
     * 员工生日
     * @param staffBirthday 员工生日
     */
    public void setSt0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000affBirthday(Date staffBirthday) {
        this.staffBirthday = staffBirthday;
    }

    /**
     * 员工职位(外键对应职位表)
     * @return staff_positionID 员工职位(外键对应职位表)
     */
    public Integer getStaffPositionid() {
        return staffPositionid;
    }

    /**
     * 员工职位(外键对应职位表)
     * @param staffPositionid 员工职位(外键对应职位表)
     */
    public void setStaffPositionid(Integer staffPositionid) {
        this.staffPositionid = staffPositionid;
    }

    /**
     * 员工地址
     * @return staff_adress 员工地址
     */
    public String getStaffAdress() {
        return staffAdress;
    }

    /**
     * 员工地址
     * @param staffAdress 员工地址
     */
    public void setStaffAdress(String staffAdress) {
        this.staffAdress = staffAdress == null ? null : staffAdress.trim();
    }

    /**
     * 员工基础工资（例如 5k）
     * @return staff_wage 员工基础工资（例如 5k）
     */
    public String getStaffWage() {
        return staffWage;
    }

    /**
     * 员工基础工资（例如 5k）
     * @param staffWage 员工基础工资（例如 5k）
     */
    public void setStaffWage(String staffWage) {
        this.staffWage = staffWage == null ? null : staffWage.trim();
    }

    /**
     * 员工邮箱
     * @return staff_email 员工邮箱
     */
    public String getStaffEmail() {
        return staffEmail;
    }

    /**
     * 员工邮箱
     * @param staffEmail 员工邮箱
     */
    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail == null ? null : staffEmail.trim();
    }

}