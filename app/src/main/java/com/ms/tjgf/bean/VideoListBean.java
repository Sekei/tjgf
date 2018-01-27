package com.ms.tjgf.bean;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/23.
 */

public class VideoListBean implements Serializable {
    private String id;//": "14",
    private String type;//": "2",
    private String title;//": "陈式第6招",
    private String num_favorite;//": "10",
    private String num_praise;//": "50",
    private String pics;//": "http://ozt7jo2zh.bkt.clouddn.com/taiji/20180119/181908600465.png",
    private String video;//": "http://ozt7jo2zh.bkt.clouddn.com/taiji/20180119/181611938241.mp4",
    private String nickname;//": "淡定小青年",
    private String isPraised;//": "0"

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNum_favorite() {
        return num_favorite;
    }

    public void setNum_favorite(String num_favorite) {
        this.num_favorite = num_favorite;
    }

    public String getNum_praise() {
        return num_praise;
    }

    public void setNum_praise(String num_praise) {
        this.num_praise = num_praise;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIsPraised() {
        return isPraised;
    }

    public void setIsPraised(String isPraised) {
        this.isPraised = isPraised;
    }
}
