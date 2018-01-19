package com.ms.tjgf.network.bean;

import com.ms.tjgf.network.RespBean;

import java.util.ArrayList;

/**
 * Created by fangt on 2018/1/19.
 */

public class ProvincesBean extends RespBean{

    ArrayList<Provinces> provincesList;

    public ArrayList<Provinces> getProvincesList() {
        return provincesList;
    }

    public void setProvincesList(ArrayList<Provinces> provincesList) {
        this.provincesList = provincesList;
    }

    public class Provinces{
        String id ;
        String name;

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
    }
}
