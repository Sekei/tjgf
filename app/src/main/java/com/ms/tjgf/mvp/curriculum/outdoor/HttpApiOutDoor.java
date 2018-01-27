package com.ms.tjgf.mvp.curriculum.outdoor;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/25.
 */

public class HttpApiOutDoor implements Serializable {
    private int page;//页号

    public HttpApiOutDoor(int page) {
        this.page = page;
    }
}
