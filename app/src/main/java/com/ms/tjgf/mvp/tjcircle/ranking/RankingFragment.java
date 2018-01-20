package com.ms.tjgf.mvp.tjcircle.ranking;


import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.tjcircle.match.adapter.MatchAdapter;
import com.ms.tjgf.mvp.tjcircle.ranking.adapter.RankingAdapter;
import com.ms.tjgf.mvp.tjcircle.ranking.bean.RankingBean;
import com.ms.tjgf.widget.CustomListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class RankingFragment extends BaseFragment implements View.OnClickListener {
    private TextView mBtnGroup;
    private int mPosition = 0;//默认名师榜
    private ListView mRankingList;
    private RankingAdapter mRankingAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ranking;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mBtnGroup = view.findViewById(R.id.btn_group);
        mBtnGroup.setOnClickListener(this);
        mRankingList = view.findViewById(R.id.ranking_list);
        List<RankingBean> arr = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            arr.add(new RankingBean("1"));
        }
        mRankingAdapter = new RankingAdapter(getActivity(), R.layout.item_ranking_list, arr);
        mRankingList.setAdapter(mRankingAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_group:
                if (mPosition == 0) {
                    mBtnGroup.setText("名师榜");
                } else {
                    mBtnGroup.setText("斗士榜");
                }
                break;
        }
    }
}
