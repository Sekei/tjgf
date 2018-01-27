package com.ms.tjgf.mvp.curriculum.privateschool;


import android.support.annotation.IdRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.base.IBaseListPresenter;
import com.ms.tjgf.bean.DynamicData;
import com.ms.tjgf.bean.PrivateSchoolData;
import com.ms.tjgf.mvp.curriculum.privateschool.adapter.PrivateSchoolAdapter;
import com.ms.tjgf.bean.PrivateSchoolBean;
import com.ms.tjgf.mvp.curriculum.privateschool.persenter.IPEListPresenter;
import com.ms.tjgf.mvp.curriculum.privateschool.persenter.PEListPresenter;
import com.ms.tjgf.mvp.curriculum.privateschool.view.IPEListView;
import com.ms.tjgf.mvp.curriculumdetails.SignUpActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class PrivateSchoolFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemClickListener, IPEListView {
    private ListView mListView;
    private PrivateSchoolAdapter mPrivateSchoolAdapter;
    private List<PrivateSchoolData> newsList = new ArrayList<>();
    private IPEListPresenter iPEListPresenter;
    private RadioGroup mRadioGroup;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_privateschool;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mListView = view.findViewById(R.id.privateschool_list);
        iPEListPresenter = new PEListPresenter(this);
        //默认首次请求招式
        iPEListPresenter.requestNewsList(true, "0");
        mPrivateSchoolAdapter = new PrivateSchoolAdapter(getActivity(), R.layout.item_privateschool_list, newsList);
        mListView.setAdapter(mPrivateSchoolAdapter);
        mListView.setOnItemClickListener(this);
        mRadioGroup = view.findViewById(R.id.radio_group);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.radio_btn_zs:
                iPEListPresenter.requestNewsList(true, "0");
                break;
            case R.id.radio_btn_tl:
                iPEListPresenter.requestNewsList(true, "1");
                break;
        }
    }

    @Override
    public void dismissRefreshView() {
        //swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateNewsList(List<PrivateSchoolData> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        mPrivateSchoolAdapter.notifyDataSetInvalidated(this.newsList);
        dismissRefreshView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        iPEListPresenter.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        startActivity(SignUpActivity.class);
    }
}
