package com.ms.tjgf.mvp.curriculum.study;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.curriculum.study.adapter.IndicatorAdapter;
import com.ms.tjgf.widget.CustomListView;
import com.ms.tjgf.widget.SpinerPopWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 太极自修课
 * Created by MissSekei on 2018/1/12.
 */

public class StudyFragment extends BaseFragment implements OnDismissListener, OnItemClickListener, View.OnClickListener {
    private SpinerPopWindow<String> mSpinerPopWindow;
    private List<String> list;
    private TextView mStudyName;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_study;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mStudyName = view.findViewById(R.id.study_name);
        mStudyName.setOnClickListener(this);
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list.add("test:" + i);
        }
        mSpinerPopWindow = new SpinerPopWindow<>(getActivity(), list, this);
        mSpinerPopWindow.setOnDismissListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.study_name:
                mSpinerPopWindow.setWidth(mStudyName.getWidth());
                mSpinerPopWindow.showAsDropDown(mStudyName);
                //setTextImage(R.drawable.icon_up);
                break;
        }
    }

    /**
     * 监听popupwindow取消
     */
    @Override
    public void onDismiss() {
        //setTextImage(R.drawable.icon_down);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mSpinerPopWindow.dismiss();
        // tvValue.setText(list.get(position));
    }
}
