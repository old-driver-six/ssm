package com.bj186.oa.pojo;

import java.io.Serializable;

public class GoodsDetail implements Serializable {
    private Integer gdID;
    private Goods goods;
    private String details;

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "gdID=" + gdID +
                ", goods=" + goods +
                ", details='" + details + '\'' +
                '}';
    }

    public Integer getGdID() {
        return gdID;
    }

    public void setGdID(Integer gdID) {
        this.gdID = gdID;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
