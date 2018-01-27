package com.ms.tjgf.bean;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/25.
 */

public class PrivateSchoolData implements Serializable{
    //招式返回数据
    private String id;//": "15",
    private String style_id;//": "8",
    private String tj_faction_id;//": "7",
    private String course_type_id;//": "2",
    private String course_address;//": "上海浦东",
    private String price;//": "21.00",
    private String content;//": "123456789",
    private String course_name;//": "taiji123",
    private String teacher_id;//": "1",
    private String course_date;//": "1516431739",
    private String long_time;//": "60分钟",
    private String course_total;//": "0",
    private String max_people;//": "30",
    private String sign_num;//": "2",
    private String status;//": "1",
    private String is_del;//"": "0",
    private String is_open;//"": "1",
    private String close_reason;//"": "",
    private String created_at;//"": "0",
    private String updated_at;//"": "0",
    private String image;//"": "http://ozt7jo2zh.bkt.clouddn.com/taiji/20180119/163505842707.png"
    //套路返回的数据
    private String name;//": "课程包1",
    private String is_quick;//": "1",
    private String tj_style_id;//": "1",
    private String start_time;//": "1500121",
    private String course_sum;//": "20",
    //表示
    private String type="0";//0表示招式、1表示套路





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCourse_address() {
        return course_address;
    }

    public void setCourse_address(String course_address) {
        this.course_address = course_address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getCourse_date() {
        return course_date;
    }

    public void setCourse_date(String course_date) {
        this.course_date = course_date;
    }

    public String getLong_time() {
        return long_time;
    }

    public void setLong_time(String long_time) {
        this.long_time = long_time;
    }

    public String getCourse_total() {
        return course_total;
    }

    public void setCourse_total(String course_total) {
        this.course_total = course_total;
    }

    public String getMax_people() {
        return max_people;
    }

    public void setMax_people(String max_people) {
        this.max_people = max_people;
    }

    public String getSign_num() {
        return sign_num;
    }

    public void setSign_num(String sign_num) {
        this.sign_num = sign_num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_del() {
        return is_del;
    }

    public void setIs_del(String is_del) {
        this.is_del = is_del;
    }

    public String getIs_open() {
        return is_open;
    }

    public void setIs_open(String is_open) {
        this.is_open = is_open;
    }

    public String getClose_reason() {
        return close_reason;
    }

    public void setClose_reason(String close_reason) {
        this.close_reason = close_reason;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIs_quick() {
        return is_quick;
    }

    public void setIs_quick(String is_quick) {
        this.is_quick = is_quick;
    }

    public String getTj_style_id() {
        return tj_style_id;
    }

    public void setTj_style_id(String tj_style_id) {
        this.tj_style_id = tj_style_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getCourse_sum() {
        return course_sum;
    }

    public void setCourse_sum(String course_sum) {
        this.course_sum = course_sum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
