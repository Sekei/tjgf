package com.ms.tjgf.network;

/**
 * Created by fangt on 2018/1/18.
 */

public class RespBean<T> {
    public int status;
    public String msg;
    public T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString(){
        return "status = " + status + " msg = " + msg + " data = " + data;
    }
}
