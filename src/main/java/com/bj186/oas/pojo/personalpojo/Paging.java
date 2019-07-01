package com.bj186.oas.pojo.personalpojo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据
 * @param <T>
 */
public class Paging<T> implements Serializable {
    private Integer cot;  //总数
    private List<T> data;   //数据

    public Integer getCot() {
        return cot;
    }

    public void setCot(Integer cot) {
        this.cot = cot;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "cot=" + cot +
                ", data=" + data +
                '}';
    }
}
