package com.ms.tjgf.mvp.friendinfo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/16.
 */

public class FriendInfoBean implements Serializable {
    private String id;
    private List<String> ninegrid;

    public FriendInfoBean(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getNinegrid() {
        return ninegrid;
    }

    public void setNinegrid(List<String> ninegrid) {
        this.ninegrid = ninegrid;
    }

}
