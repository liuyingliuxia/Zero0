package com.zeasn.zero0.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.lolinico.technical.open.parent.RootView;
import com.lolinico.technical.open.parent.RxPresenter;
import com.zeasn.zero0.MyApplication;
import com.zeasn.zero0.R;
import com.zeasn.zero0.adapter.MainViewPagerAdapter;
import com.zeasn.zero0.bean.Type;
import com.zeasn.zero0.presenter.MainPresenter;
import com.zeasn.zero0.ui.MainActivity;
import com.zeasn.zero0.util.RLog;
import com.zeasn.zero0.widget.NoScrollViewPager;


import butterknife.BindView;
import butterknife.OnClick;

public class MainView extends RootView {
    @BindView(R.id.rbStory)
    RadioButton rbStory;
    @BindView(R.id.rbMessage)
    RadioButton rbMessage;
    @BindView(R.id.rbTopic)
    RadioButton rbTopic;
    @BindView(R.id.rbMy)
    RadioButton rbMy;

    @BindView(R.id.ivAdd)
    ImageView ivAdd;

    @BindView(R.id.vp2Main)
    NoScrollViewPager vp2Main;

    MainViewPagerAdapter mainViewPagerAdapter;

    public MainView(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public RxPresenter bindPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public int setContentId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        if (rbStory != null)
            rbStory.setChecked(true);
        mainViewPagerAdapter = new MainViewPagerAdapter(MainActivity.supportFragmentManager,
                FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT);
        //设置预加载数 全部的fragment
        vp2Main = new NoScrollViewPager(mContext);
        vp2Main.setOffscreenPageLimit(4);
        vp2Main.setAdapter(mainViewPagerAdapter);
        vp2Main.setCurrentItem(Type.TAB_FRAGMENT_TYPE_TOPIC);
    }

    @Override
    public void requestDataAction() {

    }

    @OnClick({R.id.rbStory, R.id.rbMessage, R.id.rbTopic, R.id.rbMy, R.id.ivAdd})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbStory:
                vp2Main.setCurrentItem(Type.TAB_FRAGMENT_TYPE_STORY);
                RLog.v("OnClick==== story");
                break;
            case R.id.rbMessage:
                vp2Main.setCurrentItem(Type.TAB_FRAGMENT_TYPE_MESSAGE);
                RLog.v("OnClick==== message");
                break;
            case R.id.rbTopic:
                vp2Main.setCurrentItem(Type.TAB_FRAGMENT_TYPE_TOPIC);
                RLog.v("OnClick==== topic");
                break;
            case R.id.rbMy:
                vp2Main.setCurrentItem(Type.TAB_FRAGMENT_TYPE_MY);
                RLog.v("OnClick==== my");
                break;
//                v.setFocusable(true);
//                v.setFocusableInTouchMode(true);
//                v.setSelected(true);
//                break;
            case R.id.ivAdd:
                //todo 发布内容
                break;
        }
    }
}
