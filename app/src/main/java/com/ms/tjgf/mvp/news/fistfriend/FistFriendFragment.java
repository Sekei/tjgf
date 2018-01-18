package com.ms.tjgf.mvp.news.fistfriend;


import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ms.tjgf.R;
import com.ms.tjgf.base.BaseFragment;
import com.ms.tjgf.mvp.friendinfo.FriendInfoActivity;
import com.ms.tjgf.mvp.news.fistfriend.adapter.SortAdapter;
import com.ms.tjgf.mvp.news.fistfriend.bean.CarType;
import com.ms.tjgf.mvp.news.fistfriend.sort.PinyinComparator;
import com.ms.tjgf.mvp.news.fistfriend.utils.CharacterParser;
import com.ms.tjgf.mvp.news.fistfriendadd.FistfriendAddActivity;
import com.ms.tjgf.mvp.news.widget.ClearEditText;
import com.ms.tjgf.mvp.news.widget.SideBar;
import com.ms.tjgf.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class FistFriendFragment extends BaseFragment implements View.OnClickListener, TextWatcher, SideBar.OnTouchingLetterChangedListener, AdapterView.OnItemClickListener {
    private ImageView mFistFriendAdd;
    private SideBar sideBar;
    private TextView dialog;
    private ListView sortListView;
    private SortAdapter adapter;
    private ClearEditText mClearEditText;
    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    private List<CarType> SourceDateList;

    /**
     * 根据拼音来排列ListView里面的数据类
     */
    private PinyinComparator pinyinComparator;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fistfriend;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        sortListView = view.findViewById(R.id.fistfriend_list);
        //实例化汉字转拼音类
        characterParser = CharacterParser.getInstance();
        // ################################################
        // TODO:这里写插入数据的方法。下面一行代码是从配置文件中读取事先写入的数据。
        // ################################################
        SourceDateList = filledData(getResources().getStringArray(R.array.date));
        //插入数据后再初始化界面
        initViews();
    }

    private void initViews() {
        pinyinComparator = new PinyinComparator();
        sideBar = view.findViewById(R.id.sidrbar);
        dialog = view.findViewById(R.id.dialog_tv);
        sideBar.setTextView(dialog);
        sideBar.setOnTouchingLetterChangedListener(this);       //设置右侧触摸监听
        sortListView.setOnItemClickListener(this);
        SourceDateList = filledData(SourceDateList);
        // 根据a-z进行排序源数据
        Collections.sort(SourceDateList, pinyinComparator);
        adapter = new SortAdapter(getActivity(), SourceDateList);
        sortListView.setAdapter(adapter);
        mClearEditText = view.findViewById(R.id.filter_edit);
        //根据输入框输入值的改变来过滤搜索
        mClearEditText.addTextChangedListener(this);
        //添加拳友
        mFistFriendAdd = view.findViewById(R.id.fistfriend_add_btn);
        mFistFriendAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fistfriend_add_btn:
                startActivity(FistfriendAddActivity.class);
                break;
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
        filterData(s.toString());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void onTouchingLetterChanged(String s) {
        //该字母首次出现的位置
        int position = adapter.getPositionForSection(s.charAt(0));
        if (position != -1) {
            sortListView.setSelection(position);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        startActivity(FriendInfoActivity.class);
    }


    /**
     * 为ListView填充数据
     *
     * @param date
     * @return
     */
    private List<CarType> filledData(String[] date) {
        List<CarType> mSortList = new ArrayList<CarType>();

        for (int i = 0; i < date.length; i++) {
            CarType sortModel = new CarType();
            sortModel.setCar_title(date[i]);
            //汉字转换成拼音
            String pinyin = characterParser.getSelling(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();
            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }

            mSortList.add(sortModel);
        }
        return mSortList;

    }

    /**
     * 为ListView填充数据
     *
     * @param
     * @return
     */
    private List<CarType> filledData(List<CarType> data) {
        for (int i = 0; i < data.size(); i++) {
            CarType sortModel = data.get(i);
            //汉字转换成拼音
            String pinyin = characterParser.getSelling(data.get(i).getCar_title());
            String sortString = pinyin.substring(0, 1).toUpperCase();

            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }
        }
        return data;
    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<CarType> filterDateList = new ArrayList<CarType>();
        if (TextUtils.isEmpty(filterStr)) {
            for (CarType carType : SourceDateList) {
                if (carType.getCar_title_html() != null) {
                    carType.setCar_title_html(null);
                }
            }
            filterDateList = SourceDateList;
        } else {
            filterDateList.clear();
            for (CarType sortModel : SourceDateList) {
                String name = sortModel.getCar_title();
                match(filterDateList, sortModel, filterStr);
            }
        }

//        if (filterDateList==null || filterDateList.size()==0) {
//            showin = LoadingViewUtil.showinlack(this, R.drawable.icon_theme_search, "没有搜索结果", showin);
//        }else{
//            LoadingViewUtil.showout(this, showin);
//        }

        // 根据a-z进行排序
        Collections.sort(filterDateList, pinyinComparator);
        adapter.updateListView(filterDateList);
    }

    /**
     * 匹配字符串
     *
     * @param sortModel
     * @param filterStr
     */
    private int matchText(CarType sortModel, String filterStr) {
        int sellingcount = 0;
        String name = sortModel.getCar_title();
        String[] sellingArray = characterParser.getSellingArray(name);
        for (String selling : sellingArray) {
            if ("".equals(filterStr)) {
                return sellingcount;
            }
            if (filterStr.startsWith(selling)) {
                sellingcount++;
                filterStr = filterStr.substring(selling.length(), filterStr.length());
            } else if (selling.startsWith(filterStr)) {
                sellingcount++;
                return sellingcount;
            } else {
                return 0;
            }
        }
        return sellingcount;
    }

    private void match(List<CarType> filterDateList, CarType sortModel, String filterStr) {
        boolean isMatch = false;
        String car_title = sortModel.getCar_title();
        int sellingCount = matchText(sortModel, filterStr);
        if (sellingCount != 0) {
            isMatch = true;
            sortModel.setCar_title_html("<font color='#f08519'><b>" + car_title.substring(0, sellingCount) + "</b></font>" + car_title.substring(sellingCount));
        }

        int index = car_title.toLowerCase().indexOf(filterStr.toLowerCase().toString());
        int length = filterStr.length();
        if (index != -1) {
            isMatch = true;
            sortModel.setCar_title_html(car_title.substring(0, index) + "<font color='#f08519'><b>" + filterStr + "</b></font>" + car_title.substring(index + length));
        }

        if (isMatch) {
            filterDateList.add(sortModel);
        }
    }
}
