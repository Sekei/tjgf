package com.ms.tjgf.mvp.curriculum.master;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/25.
 */

public class HttpApiMaster implements Serializable {
    private int page;//页号

    public HttpApiMaster(int page) {
        this.page = page;
    }
}
