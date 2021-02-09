package com.lolinico.technical.open.parent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.widget.LinearLayout;

import com.githang.statusbar.StatusBarCompat;
import com.lolinico.technical.open.entity.Event;
import com.steelbar.R;

import butterknife.ButterKnife;



/**
 * Created by Rico on 2017/8/4.
 */
public abstract class RootView<T extends RxPresenter> extends LinearLayout {
    public Context mContext;
    protected T mPresenter;
    boolean isOpenStatusBar =true;//是否开启沉浸式状态栏

    public RootView(Context context) {
        super(context);
        mContext = context;
        mPresenter = bindPresenter();
        //设置沉浸式状态栏
        isOpenStatusBar=true;
        if (isOpenStatusBar)
            StatusBarCompat.setStatusBarColor((Activity) context,getResources().getColor(R.color.white), true);//todo 跟随app主题颜色自动变化
        setPresenterTag();
        inflateById();
        initBinder();
        initView();
        requestDataAction();
    }

    void setPresenterTag() {
        (((Activity) mContext).getWindow().getDecorView()).setTag(R.id.TAG_PRESENTER, mPresenter);
        (((Activity) mContext).getWindow().getDecorView()).setTag(R.id.TAG_ROOTVIEW, this);
    }

    protected void onEventDoAction(Event event) {
    }

    /**
     * prsenter绑定view 必重写
     **/
    public abstract T bindPresenter();

    public void initBinder() {
        ButterKnife.bind(this);
    }

    public abstract int setContentId();

    public abstract void initView();

    public abstract void requestDataAction();

    protected void onCreate() {
    }

    protected void onResume() {
    }

    protected void onPause() {
    }

    protected void onDestroy() {
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    protected void onConfigurationChanged(Configuration newConfig) {
    }

    protected boolean isRegisterEventBus() {
        return false;
    }

    /***
     * inflate layout
     */
    public void inflateById() {
        ((Activity) mContext).getLayoutInflater().inflate(setContentId(), this);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mPresenter != null)
            mPresenter.onDestroy();
    }

}
