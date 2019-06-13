package com.bj186.crm.pojo;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer gID;

    private  String goodsName;


    @Override
    public String toString() {
        return "Goods{" +
                "gID=" + gID +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }


    public Integer getgID() {
        return gID;
    }

    public void setgID(Integer gID) {
        this.gID = gID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
