package com.ms.tjgf.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/26.
 */

public class StudyFactionBean implements Serializable {
    private String id;//": "1",
    private String name;//": "国家普及推广",
    private String inherit;//": null,
    private String sort;//": "0",
    private String created_at;//": null,
    private String updated_at;//": null,
    private List<StudyStyle> style;//": [

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInherit() {
        return inherit;
    }

    public void setInherit(String inherit) {
        this.inherit = inherit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public List<StudyStyle> getStyle() {
        return style;
    }

    public void setStyle(List<StudyStyle> style) {
        this.style = style;
    }
}
