package com.ms.tjgf.mvp.tjcircle.dynamic;


import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.tjcircle.dynamic.adapter.DynamicAdapter;
import com.ms.tjgf.network.RfResultHandler;
import com.ms.tjgf.network.bean.DynamicBean;
import com.ms.tjgf.network.bean.RetrofitHttp;
import com.ms.tjgf.widget.PublishPopWin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class DynamicFragment extends BaseFragment implements View.OnClickListener {
    private DynamicBean mDynamicData;
    private ListView mDynamicList;
    private DynamicAdapter mDynamicAdapter;
    private ImageView mBtnPublish;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mDynamicList = view.findViewById(R.id.dynamic_list);
        mBtnPublish = view.findViewById(R.id.btn_publish);
        mBtnPublish.setOnClickListener(this);
//        PublishPopWin takePhotoPopWin = new PublishPopWin(getActivity());
//        takePhotoPopWin.showAtLocation(view, Gravity.CENTER, 0, 0);
//        mDynamicAdapter = new RankingAdapter(getActivity(), R.layout.item_dynamic_list, mDynamicData.getData());
//        mDynamicList.setAdapter(mDynamicAdapter);
//        RetrofitHttp.getInstance().getDynamic()
//                .compose(RfResultHandler.handleRespResult())
//                .compose(RfResultHandler.transformer)
//                .subscribe(provinces -> {
//                    System.out.println("代码json：" + provinces.getData().toString());
//                    //mDynamicData = new Gson().fromJson(provinces.getData().toString(), DynamicBean.class);
////                    mDynamicAdapter = new RankingAdapter(getActivity(), R.layout.item_dynamic_list, mDynamicData.getData());
////                    mDynamicList.setAdapter(mDynamicAdapter);
//                }, throwable -> {
//                    throwable.printStackTrace();
//                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_publish:

                break;
        }
    }
}
