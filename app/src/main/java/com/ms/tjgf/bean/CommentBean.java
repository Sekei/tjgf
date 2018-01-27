package com.ms.tjgf.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/23.
 */

public class CommentBean implements Serializable {
    private BasePager pager;
    private List<CommentListBean> list;

    public BasePager getPager() {
        return pager;
    }

    public void setPager(BasePager pager) {
        this.pager = pager;
    }

    public List<CommentListBean> getList() {
        return list;
    }

    public void setList(List<CommentListBean> list) {
        this.list = list;
    }
}
