package com.ms.tjgf.mvp.register;

import android.util.Base64;

import com.ms.tjgf.utils.Base64Utils;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/24.
 */

public class HttpApiRegister implements Serializable {
    private String phone;//：手机号
    private String sms;//: 输入的接收到的验证码，不要加密
    private String password;//: 输入的密码，要加密

    public HttpApiRegister(String phone, String sms, String password) {
        this.phone = phone;
        this.sms = sms;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
