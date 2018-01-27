package com.ms.tjgf.mvp.curriculum.outdoor.adapter;

import android.content.Context;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.bean.OutDoorData;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class OutdoorAdapter extends QuickAdapter<OutDoorData> {

    public OutdoorAdapter(Context context, int layoutResId, List<OutDoorData> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final OutDoorData item) {
        helper.setImageUrl(R.id.outdoor_image, item.getImage());
        helper.setText(R.id.outdoor_name, item.getCourse_name());
        helper.setText(R.id.outdoor_timer, item.getLong_time());
        helper.setText(R.id.outdoor_price, "￥" + item.getPrice());
        helper.setText(R.id.outdoor_loaction, item.getCourse_address());
    }

}
