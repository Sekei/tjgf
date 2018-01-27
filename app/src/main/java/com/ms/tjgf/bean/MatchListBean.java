package com.ms.tjgf.bean;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/20.
 */

public class MatchListBean implements Serializable {
    private String id;//": "7",
    private String thumb;//": "http://ozt7jo2zh.bkt.clouddn.com/taiji/20180120/151014718913.png",
    private String name;//": " 中国2017太极功夫大赛",
    private String hold_time;//": "2018-01-20 15:10:39",
    private String hold_company;//": "门申科技",
    private String introduce;//": " 中国2017太极功夫大赛",
    private String join_status;//": "0",
    private String join_nums;//": "0",
    private String created_at;//": "2018-01-20 15:10:39",
    private String status;//": "1"

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHold_time() {
        return hold_time;
    }

    public void setHold_time(String hold_time) {
        this.hold_time = hold_time;
    }

    public String getHold_company() {
        return hold_company;
    }

    public void setHold_company(String hold_company) {
        this.hold_company = hold_company;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getJoin_status() {
        return join_status;
    }

    public void setJoin_status(String join_status) {
        this.join_status = join_status;
    }

    public String getJoin_nums() {
        return join_nums;
    }

    public void setJoin_nums(String join_nums) {
        this.join_nums = join_nums;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
