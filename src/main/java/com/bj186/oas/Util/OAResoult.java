package com.bj186.oas.Util;

import java.io.Serializable;

/**
 * 返回结果工具类
 * @param <T>
 */
public class OAResoult<T> implements Serializable {
    private Integer Code;//状态
    private String msg;//信息
    private Integer count;//总数
    private T data;//数据

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OAResoult{" +
                "Code=" + Code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
