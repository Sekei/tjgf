package com.ms.tjgf.bean;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/24.
 */

public class MsgStatus implements Serializable {
    private int status;//1,"
    private String msg;

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
}
