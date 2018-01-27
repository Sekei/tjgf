package com.ms.tjgf.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/20.
 */

public class MatchBean implements Serializable {
    private BasePager pager;
    private List<MatchListBean> list;

    public BasePager getPager() {
        return pager;
    }

    public void setPager(BasePager pager) {
        this.pager = pager;
    }

    public List<MatchListBean> getList() {
        return list;
    }

    public void setList(List<MatchListBean> list) {
        this.list = list;
    }
}
