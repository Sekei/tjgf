package com.ms.tjgf.mvp.curriculum.privateschool;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/25.
 */

public class HttpApiPE implements Serializable {
    private int page;//:页码：不填默认为1
    private String type;//: 0-招式，1-套路（课程包），不填默认为0

    public HttpApiPE(int page, String type) {
        this.page = page;
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
