package com.bj186.oas.entity.system;

public class Like {
    private Integer uId;
    private String filed;
    private String value;
    private Integer pageSize;
    private Integer pageNum;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getFiled() {
        return filed;
    }

    @Override
    public String toString() {
        return "Like{" +
                "uId=" + uId +
                ", filed='" + filed + '\'' +
                ", value='" + value + '\'' +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                '}';
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
