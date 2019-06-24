package com.bj186.oas.Util;

import java.io.Serializable;

/**
 * 消息处理类
 */
public class Massgs<T> implements Serializable {
    private T TableKey;        //表的主键;
    private String sid="系统消息";        //发件人id,不指定则为系统

    private String uid; //要发送的用户id
    private String msg; //发送的消息类容

    public T getTableKey() {
        return TableKey;
    }

    public void setTableKey(T tableKey) {
        TableKey = tableKey;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Massgs{" +
                "TableKey=" + TableKey +
                ", sid='" + sid + '\'' +
                ", uid='" + uid + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
