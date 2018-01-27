package com.ms.tjgf.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/15.
 */

public class PrivateSchoolBean implements Serializable {
    private BasePager pager;
    private List<PrivateSchoolData> list;

    public BasePager getPager() {
        return pager;
    }

    public void setPager(BasePager pager) {
        this.pager = pager;
    }

    public List<PrivateSchoolData> getList() {
        return list;
    }

    public void setList(List<PrivateSchoolData> list) {
        this.list = list;
    }
}
