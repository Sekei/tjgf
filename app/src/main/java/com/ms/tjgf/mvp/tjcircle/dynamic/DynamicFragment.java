package com.ms.tjgf.mvp.tjcircle.dynamic;


import android.view.View;
import android.widget.ListView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.tjcircle.dynamic.adapter.DynamicAdapter;
import com.ms.tjgf.mvp.tjcircle.dynamic.bean.DynamicBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class DynamicFragment extends BaseFragment {

    private ListView mDynamicList;
    private DynamicAdapter mDynamicAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        List<DynamicBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DynamicBean arr = new DynamicBean();
            arr.setName("你猜");
            data.add(arr);
        }
        mDynamicList = view.findViewById(R.id.dynamic_list);
        mDynamicAdapter = new DynamicAdapter(getActivity(), R.layout.item_dynamic_list, data);
        mDynamicList.setAdapter(mDynamicAdapter);
    }

}
