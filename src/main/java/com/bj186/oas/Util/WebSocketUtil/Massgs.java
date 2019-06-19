package com.bj186.oas.Util.WebSocketUtil;

import java.io.Serializable;

/**
 * 消息处理类
 */
public class Massgs implements Serializable {
    private String uid;
    private String msg;

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
}
