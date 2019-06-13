package com.bj186.crm.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Bill implements Serializable {
    private Long billID;
    private Long seatID;
    private Float allPrice;
    private  String date;
    private Long staffID;
    private String state;
    private Set<BillFood> foodSet = new HashSet<BillFood>();

    @Override
    public String toString() {
        return "Bill{" +
                "billID=" + billID +
                ", seatID=" + seatID +
                ", allPrice=" + allPrice +
                ", date='" + date + '\'' +
                ", staffID=" + staffID +
                ", state='" + state + '\'' +
                ", foodSet=" + foodSet +
                '}';
    }

    public Long getBillID() {
        return billID;
    }

    public void setBillID(Long billID) {
        this.billID = billID;
    }

    public Long getSeatID() {
        return seatID;
    }

    public void setSeatID(Long seatID) {
        this.seatID = seatID;
    }

    public Float getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Float allPrice) {
        this.allPrice = allPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getStaffID() {
        return staffID;
    }

    public void setStaffID(Long staffID) {
        this.staffID = staffID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<BillFood> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<BillFood> foodSet) {
        this.foodSet = foodSet;
    }
}
