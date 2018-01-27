package com.ms.tjgf.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/15.
 */

public class OutDoorBean implements Serializable {
    private BasePager pager;
    private List<OutDoorData> list;

    public BasePager getPager() {
        return pager;
    }

    public void setPager(BasePager pager) {
        this.pager = pager;
    }

    public List<OutDoorData> getList() {
        return list;
    }

    public void setList(List<OutDoorData> list) {
        this.list = list;
    }
}
