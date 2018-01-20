package com.ms.tjgf.network.bean;

import com.ms.tjgf.network.RespBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/20.
 */

public class DynamicBean extends RespBean {
    private DynamicPager pager;
    private List<DynamicData> data;

    public DynamicPager getPager() {
        return pager;
    }

    public void setPager(DynamicPager pager) {
        this.pager = pager;
    }

    @Override
    public List<DynamicData> getData() {
        return data;
    }

    public void setData(List<DynamicData> data) {
        this.data = data;
    }

    public class DynamicPager implements Serializable {
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

    public class DynamicData implements Serializable {
        private String id;//": "8",
        private String type;//": "0",
        private String title;//": "",
        private String body;//": "好好努力！！！",
        private String num_favorite;//": "10",
        private String num_praise;//": "25",
        private String num_reply;//": "3",
        private String location;//": "北京",
        private String created_at;//": "3小时前",
        private String labels_str;//": "上海,秋天",
        private String[] pics;//": [],
        private String[] video;//
        private String nickname;//": "感悟人生",
        private String avatar;//": "http://ozt7jo2zh.bkt.clouddn.com/taiji/20180119/174720315552.jpg",
        private String isPraised;//": "1"　//已经点赞

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

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
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

        public String getNum_reply() {
            return num_reply;
        }

        public void setNum_reply(String num_reply) {
            this.num_reply = num_reply;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getLabels_str() {
            return labels_str;
        }

        public void setLabels_str(String labels_str) {
            this.labels_str = labels_str;
        }

        public String[] getPics() {
            return pics;
        }

        public void setPics(String[] pics) {
            this.pics = pics;
        }

        public String[] getVideo() {
            return video;
        }

        public void setVideo(String[] video) {
            this.video = video;
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

}
