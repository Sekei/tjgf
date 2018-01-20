package com.ms.tjgf.mvp.tjcircle.match;


import android.view.View;
import android.widget.ListView;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.tjcircle.match.adapter.MatchAdapter;
import com.ms.tjgf.mvp.tjcircle.match.bean.MatchBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class MatchFragment extends BaseFragment {
    private ListView mMatchList;
    private MatchAdapter mMatchAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_match;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mMatchList = view.findViewById(R.id.match_list);
        List<MatchBean> arr = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            arr.add(new MatchBean("1"));
        }
        mMatchAdapter = new MatchAdapter(getActivity(), R.layout.item_match_list, arr);
        mMatchList.setAdapter(mMatchAdapter);
    }

}
