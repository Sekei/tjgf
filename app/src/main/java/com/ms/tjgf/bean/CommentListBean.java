package com.ms.tjgf.bean;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/23.
 */

public class CommentListBean implements Serializable {
    private String id;//": "2",
    private String user_id;//": "2",
    private String body;//": "测试一下啦",
    private String created_at;//": "58分前",
    private String nickname;//": "淡定小青年",
    private String avatar;//": "http://ozt7jo2zh.bkt.clouddn.com/taiji/20180123/104514385428.png",
    private String isPraised;//": 0

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIsPraised() {
        return isPraised;
    }

    public void setIsPraised(String isPraised) {
        this.isPraised = isPraised;
    }
}
