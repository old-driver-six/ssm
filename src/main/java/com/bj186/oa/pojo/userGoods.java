package com.bj186.oa.pojo;

import java.io.Serializable;

public class userGoods implements Serializable {
    private Long ugID;
    private Long uID;
    private Long gID;

    public Long getUgID() {
        return ugID;
    }

    public void setUgID(Long ugID) {
        this.ugID = ugID;
    }

    public Long getuID() {
        return uID;
    }

    public void setuID(Long uID) {
        this.uID = uID;
    }

    public Long getgID() {
        return gID;
    }

    public void setgID(Long gID) {
        this.gID = gID;
    }

    @Override
    public String toString() {
        return "userGoods{" +
                "ugID=" + ugID +
                ", uID=" + uID +
                ", gID=" + gID +
                '}';
    }
}
