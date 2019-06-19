package com.bj186.oas.Util;

import java.io.Serializable;

/**
 * 返回结果工具类
 * @param <T>
 */
public class OAResoult<T> implements Serializable {
    private int status;     //状态
    private String msg;     //消息
    private T date;         //数据

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "NoteResoult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
