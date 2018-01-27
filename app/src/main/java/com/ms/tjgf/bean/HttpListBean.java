package com.ms.tjgf.bean;

/**
 * Created by MissSekei on 2018/1/22.
 */

public class HttpListBean {
    private int page;// 页号，不传默认为1
    private String access_token;// 不传的话，就是未登录，传了就是登录了

    public HttpListBean(int page, String access_token) {
        this.page = page;
        this.access_token = access_token;
    }
}
