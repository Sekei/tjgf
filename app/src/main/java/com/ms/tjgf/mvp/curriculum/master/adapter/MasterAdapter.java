package com.ms.tjgf.mvp.curriculum.master.adapter;

import android.content.Context;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseAdapterHelper;
import com.ms.tjgf.base.QuickAdapter;
import com.ms.tjgf.bean.MasterData;

import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class MasterAdapter extends QuickAdapter<MasterData> {

    public MasterAdapter(Context context, int layoutResId, List<MasterData> mData) {
        super(context, layoutResId, mData);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, final MasterData item) {
        helper.setImageUrl(R.id.master_image, item.getImage());
        helper.setText(R.id.master_name, item.getCourse_name());
        helper.setText(R.id.master_timer, item.getLong_time());
        helper.setText(R.id.master_loaction, item.getCourse_address());
    }

}
