package com.ms.tjgf.mvp.pwd;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/24.
 */

public class HttpApiReset implements Serializable{
    private String username;
    private String password;

    public HttpApiReset(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
