package com.ms.tjgf.mvp.tjcircle.dynamicdetails;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/23.
 */

public class HttpApiComment implements Serializable {
    private int page;//页号
    private String access_token;

    public HttpApiComment(int page, String access_token) {
        this.page = page;
        this.access_token = access_token;
    }
}
