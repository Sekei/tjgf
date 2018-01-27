package com.ms.tjgf.bean;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/26.
 */

public class StudyTeacher implements Serializable{
    private String id;//": "2",
    private String name;//": "自修2",
    private String style_id;//": "3",
    private String tj_faction_id;//": "3",
    private String course_type_id;//": "3",
    private String teacher_id;//": "2",
    private String count;//": "20",
    private String introduce;//": "12354",
    private String created_at;//": "0",
    private String updated_at;//": "0",
    private String teacher_name;//": "黄二仙",
    private String learn;//": 0,
    private String count_time;//": "00:00:00",
    private String image;//": ""

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

    public String getStyle_id() {
        return style_id;
    }

    public void setStyle_id(String style_id) {
        this.style_id = style_id;
    }

    public String getTj_faction_id() {
        return tj_faction_id;
    }

    public void setTj_faction_id(String tj_faction_id) {
        this.tj_faction_id = tj_faction_id;
    }

    public String getCourse_type_id() {
        return course_type_id;
    }

    public void setCourse_type_id(String course_type_id) {
        this.course_type_id = course_type_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getLearn() {
        return learn;
    }

    public void setLearn(String learn) {
        this.learn = learn;
    }

    public String getCount_time() {
        return count_time;
    }

    public void setCount_time(String count_time) {
        this.count_time = count_time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
