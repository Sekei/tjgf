package com.ms.tjgf.bean;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/23.
 */

public class BasePager implements Serializable {
    private String count;//": "8",
    private String pagesize;//": 10,
    private String pagecount;//": 1,
    private String page;//": 1

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }

    public String getPagecount() {
        return pagecount;
    }

    public void setPagecount(String pagecount) {
        this.pagecount = pagecount;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
