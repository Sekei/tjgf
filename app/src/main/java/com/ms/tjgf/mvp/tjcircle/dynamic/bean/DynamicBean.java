package com.ms.tjgf.mvp.tjcircle.dynamic.bean;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class DynamicBean implements Serializable {
    private String url;
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
