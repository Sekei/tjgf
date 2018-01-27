package com.ms.tjgf.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/26.
 */

public class StudyStyle implements Serializable {
    private String id;//": "3",
    private String faction_id;//": "1",
    private String name;//": "88式太极拳",
    private String sort;//": "0",
    private String created_at;//": null,
    private String updated_at;//": null,
    private List<StudyTeacher> teacher;//": [

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFaction_id() {
        return faction_id;
    }

    public void setFaction_id(String faction_id) {
        this.faction_id = faction_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<StudyTeacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<StudyTeacher> teacher) {
        this.teacher = teacher;
    }
}
