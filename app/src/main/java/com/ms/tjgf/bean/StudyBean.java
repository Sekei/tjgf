package com.ms.tjgf.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/26.
 */

public class StudyBean implements Serializable{
    private List<StudyFactionBean> faction;

    public List<StudyFactionBean> getFaction() {
        return faction;
    }

    public void setFaction(List<StudyFactionBean> faction) {
        this.faction = faction;
    }
}
