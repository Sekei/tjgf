package com.ms.tjgf.mvp.news.fistfriend.bean;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/15.
 */

public class CarType  implements Serializable {

    private Integer id;
    private String car_title;   //显示的数据
    private String sortLetters;  //显示数据拼音的首字母

    private String car_title_html;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCar_title() {
        return car_title;
    }
    public void setCar_title(String car_title) {
        this.car_title = car_title;
    }
    public String getSortLetters() {
        return sortLetters;
    }
    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }
    public String getCar_title_html() {
        return car_title_html;
    }
    public void setCar_title_html(String car_title_html) {
        this.car_title_html = car_title_html;
    }
}
