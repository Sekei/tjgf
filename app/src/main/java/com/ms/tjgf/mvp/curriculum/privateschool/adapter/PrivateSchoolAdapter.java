package com.ms.tjgf.mvp.curriculum.privateschool.adapter;

import android.content.Context;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.bean.PrivateSchoolBean;
import com.ms.tjgf.bean.PrivateSchoolData;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class PrivateSchoolAdapter extends QuickAdapter<PrivateSchoolData> {

    private String mType = "0";

    public PrivateSchoolAdapter(Context context, int layoutResId, List<PrivateSchoolData> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final PrivateSchoolData item) {
        if (mType.equals("0")) {//表示招式
            helper.setVisible(R.id.ll_tricks, false);
            helper.setVisible(R.id.ll_zhaoshi, true);
            helper.setImageUrl(R.id.pe_image, item.getImage());
            helper.setText(R.id.school_name, item.getCourse_name());
            helper.setText(R.id.school_timer, item.getLong_time());
            helper.setText(R.id.pe_price, "￥" + item.getPrice());
            helper.setText(R.id.school_loaction, item.getCourse_address());
        } else {
            helper.setVisible(R.id.ll_tricks, true);
            helper.setVisible(R.id.ll_zhaoshi, false);
            helper.setImageUrl(R.id.tricks_image, item.getImage());
            helper.setText(R.id.tricks_name, item.getCourse_name());
            helper.setText(R.id.tricks_timer, item.getStart_time());
            helper.setText(R.id.tricks_price, "￥" + item.getPrice());
            helper.setText(R.id.tricks_loaction, item.getCourse_address());
        }
    }

    //当前状态判断
    public void setStart(String type) {
        this.mType = type;
    }
}
