package com.ms.tjgf.mvp.news.fistfriend.sort;

import com.ms.tjgf.mvp.news.fistfriend.bean.CarType;

import java.util.Comparator;

/**
 * Created by MissSekei on 2018/1/15.
 */


public class PinyinComparator implements Comparator<CarType> {

    public int compare(CarType o1, CarType o2) {
        if (o1.getSortLetters().equals("@")
                || o2.getSortLetters().equals("#")) {
            return -1;
        } else if (o1.getSortLetters().equals("#")
                || o2.getSortLetters().equals("@")) {
            return 1;
        } else {
            return o1.getSortLetters().compareTo(o2.getSortLetters());
        }
    }
}
