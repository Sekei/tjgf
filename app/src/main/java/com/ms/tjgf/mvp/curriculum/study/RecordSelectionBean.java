package com.ms.tjgf.mvp.curriculum.study;

import java.io.Serializable;

/**
 * Created by MissSekei on 2018/1/26.
 */

public class RecordSelectionBean implements Serializable {
    private int coachposition;
    private int tricksposition;
    private int seriesposition;

    public int getCoachposition() {
        return coachposition;
    }

    public void setCoachposition(int coachposition) {
        this.coachposition = coachposition;
    }

    public int getTricksposition() {
        return tricksposition;
    }

    public void setTricksposition(int tricksposition) {
        this.tricksposition = tricksposition;
    }

    public int getSeriesposition() {
        return seriesposition;
    }

    public void setSeriesposition(int seriesposition) {
        this.seriesposition = seriesposition;
    }
}
