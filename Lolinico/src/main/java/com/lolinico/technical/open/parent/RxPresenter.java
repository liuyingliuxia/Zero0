package com.lolinico.technical.open.parent;


import android.app.Activity;
import android.content.Context;

/**
 * Created by Rico on 2017/8/4.
 */
public abstract class RxPresenter {
    public Context mContext;
    protected RootView mRootView;

    public RxPresenter(RootView rootView) {
        initPresenter(rootView);
    }

    public void initPresenter(RootView rootView) {
        mRootView = rootView;
        mContext = rootView.mContext;
        ((Activity) mContext).setContentView(rootView);
    }

    protected void onDestroy() {
    }
}
