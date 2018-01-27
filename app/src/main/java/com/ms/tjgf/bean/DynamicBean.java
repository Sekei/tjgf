package com.ms.tjgf.bean;

import android.sax.Element;
import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by MissSekei on 2018/1/20.
 */

public class DynamicBean implements Serializable {
    private BasePager pager;
    private List<DynamicData> list;

    public BasePager getPager() {
        return pager;
    }

    public void setPager(BasePager pager) {
        this.pager = pager;
    }

    public List<DynamicData> getList() {
        return list;
    }

    public void setList(List<DynamicData> list) {
        this.list = list;
    }
}
