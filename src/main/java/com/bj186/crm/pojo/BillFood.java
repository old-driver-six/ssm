package com.bj186.crm.pojo;

import java.io.Serializable;

public class BillFood implements Serializable {
    private Long bfID;
    private Bill bill;
    private Food food;
    private Integer number;

    @Override
    public String toString() {
        return "BillFood{" +
                "bfID=" + bfID +
                ", bill=" + bill +
                ", food=" + food +
                ", number=" + number +
                '}';
    }

    public Long getBfID() {
        return bfID;
    }

    public void setBfID(Long bfID) {
        this.bfID = bfID;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}