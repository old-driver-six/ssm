package com.bj186.oas.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Pay {
    /**
     * 薪资id（主键）
     */
    private Integer payId;

    /**
     * 员工编号（外键）
     */
    private Integer payStaffid;
    /**
     * 员工
     */
    private Staff staff;

//    /**
//     * 部门编号（外键）
//     */
//    private Integer payDepid;
//    /**
//     * 部门
//     */
//    private Department department;

    /**
     * 日期
     */
    private Date payDate;

    /**
     * 公积金
     */
    private BigDecimal payAccum;

    /**
     * 基本工资
     */
    private BigDecimal payWage;

    /**
     * 医疗保险
     */
    private BigDecimal payMedical;

    /**
     * 全勤奖
     */
    private BigDecimal payAward;

    /**
     * 员工真实月薪
     */
    private BigDecimal paySalary;
    public Pay() {

    }
    /**
     * 薪资id（主键）
     * @return pay_id 薪资id（主键）
     */
    public Integer getPayId() {
        return payId;
    }

    /**
     * 薪资id（主键）
     * @param payId 薪资id（主键）
     */
    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    /**
     * 员工编号（外键）
     * @return pay_staffid 员工编号（外键）
     */
    public Integer getPayStaffid() {
        return payStaffid;
    }

    /**
     * 员工编号（外键）
     * @param payStaffid 员工编号（外键）
     */
    public void setPayStaffid(Integer payStaffid) {
        this.payStaffid = payStaffid;
    }

//    /**
//     * 部门编号（外键）
//     * @return pay_depid 部门编号（外键）
//     */
//    public Integer getPayDepid() {
//        return payDepid;
//    }
//
//    /**
//     * 部门编号（外键）
//     * @param payDepid 部门编号（外键）
//     */
//    public void setPayDepid(Integer payDepid) {
//        this.payDepid = payDepid;
//    }

    /**
     * 日期
     * @return pay_date 日期
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * 日期
     * @param payDate 日期
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * 公积金
     * @return pay_accum 公积金
     */
    public BigDecimal getPayAccum() {
        return payAccum;
    }

    /**
     * 公积金
     * @param payAccum 公积金
     */
    public void setPayAccum(BigDecimal payAccum) {
        this.payAccum = payAccum;
    }

    /**
     * 基本工资
     * @return pay_wage 基本工资
     */
    public BigDecimal getPayWage() {
        return payWage;
    }

    /**
     * 基本工资
     * @param payWage 基本工资
     */
    public void setPayWage(BigDecimal payWage) {
        this.payWage = payWage;
    }

    /**
     * 医疗保险
     * @return pay_medical 医疗保险
     */
    public BigDecimal getPayMedical() {
        return payMedical;
    }

    /**
     * 医疗保险
     * @param payMedical 医疗保险
     */
    public void setPayMedical(BigDecimal payMedical) {
        this.payMedical = payMedical;
    }

    /**
     * 全勤奖
     * @return pay_award 全勤奖
     */
    public BigDecimal getPayAward() {
        return payAward;
    }

    /**
     * 全勤奖
     * @param payAward 全勤奖
     */
    public void setPayAward(BigDecimal payAward) {
        this.payAward = payAward;
    }

    /**
     * 员工真实月薪
     * @return pay_salary 员工真实月薪
     */
    public BigDecimal getPaySalary() {
        return paySalary;
    }

    /**
     * 员工真实月薪
     * @param paySalary 员工真实月薪
     */
    public void setPaySalary(BigDecimal paySalary) {
        this.paySalary = paySalary;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
//
//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
}