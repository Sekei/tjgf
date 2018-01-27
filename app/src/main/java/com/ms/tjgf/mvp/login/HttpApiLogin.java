package com.ms.tjgf.mvp.login;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/26.
 */

public class HttpApiLogin implements Serializable {
    private String username;//: 用户名或手机号
    private String sms;//: 输入的接收到的验证码，不要加密
    private String password;// : 输入的密码，要加密

    public HttpApiLogin(String username, String sms, String password) {
        this.username = username;
        this.sms = sms;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
