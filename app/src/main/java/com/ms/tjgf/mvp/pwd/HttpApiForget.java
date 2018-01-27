package com.ms.tjgf.mvp.pwd;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/24.
 */

public class HttpApiForget implements Serializable {
    private String phone;//=手机号
    private String sms;// = 接收到的短信

    public HttpApiForget(String phone, String sms) {
        this.phone = phone;
        this.sms = sms;
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
}
