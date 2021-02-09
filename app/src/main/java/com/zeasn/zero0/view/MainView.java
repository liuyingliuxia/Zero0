package com.zeasn.zero0.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.lolinico.technical.open.parent.RootView;
import com.lolinico.technical.open.parent.RxPresenter;
import com.zeasn.zero0.R;
import com.zeasn.zero0.presenter.MainPresenter;

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

    public MainView(Context context) {
        super(context);
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

    }

    @Override
    public void requestDataAction() {

    }

    @OnClick({R.id.rbStory, R.id.rbMessage, R.id.rbTopic, R.id.rbMy,R.id.ivAdd})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbStory:
            case R.id.rbMessage:
            case R.id.rbTopic:
            case R.id.rbMy:
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                v.setSelected(true);
                break;
            case R.id.ivAdd:
                //todo 发布内容
                break;
        }
    }
}
