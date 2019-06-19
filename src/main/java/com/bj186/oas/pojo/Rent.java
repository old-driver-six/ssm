package com.bj186.oas.pojo;

import java.util.Date;

public class Rent {
    /**
     * 租赁id(主键)
     */
    private Integer rentId;

    /**
     * 固定资产id（外键）
     */
    private Integer rentFixid;

    /**
     * 租赁数量
     */
    private Integer rentNumber;

    /**
     * 租赁起始时间
     */
    private Date rentStarttime;

    /**
     * 租赁结束时间
     */
    private Date rentEndtime;

    /**
     * 租赁状态
     */
    private Integer rentCond;

    /**
     * 租赁id(主键)
     * @return rent_id 租赁id(主键)
     */
    public Integer getRentId() {
        return rentId;
    }

    /**
     * 租赁id(主键)
     * @param rentId 租赁id(主键)
     */
    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    /**
     * 固定资产id（外键）
     * @return rent_fixid 固定资产id（外键）
     */
    public Integer getRentFixid() {
        return rentFixid;
    }

    /**
     * 固定资产id（外键）
     * @param rentFixid 固定资产id（外键）
     */
    public void setRentFixid(Integer rentFixid) {
        this.rentFixid = rentFixid;
    }

    /**
     * 租赁数量
     * @return rent_number 租赁数量
     */
    public Integer getRentNumber() {
        return rentNumber;
    }

    /**
     * 租赁数量
     * @param rentNumber 租赁数量
     */
    public void setRentNumber(Integer rentNumber) {
        this.rentNumber = rentNumber;
    }

    /**
     * 租赁起始时间
     * @return rent_starttime 租赁起始时间
     */
    public Date getRentStarttime() {
        return rentStarttime;
    }

    /**
     * 租赁起始时间
     * @param rentStarttime 租赁起始时间
     */
    public void setRentStarttime(Date rentStarttime) {
        this.rentStarttime = rentStarttime;
    }

    /**
     * 租赁结束时间
     * @return rent_endtime 租赁结束时间
     */
    public Date getRentEndtime() {
        return rentEndtime;
    }

    /**
     * 租赁结束时间
     * @param rentEndtime 租赁结束时间
     */
    public void setRentEndtime(Date rentEndtime) {
        this.rentEndtime = rentEndtime;
    }

    /**
     * 租赁状态
     * @return rent_cond 租赁状态
     */
    public Integer getRentCond() {
        return rentCond;
    }

    /**
     * 租赁状态
     * @param rentCond 租赁状态
     */
    public void setRentCond(Integer rentCond) {
        this.rentCond = rentCond;
    }
}