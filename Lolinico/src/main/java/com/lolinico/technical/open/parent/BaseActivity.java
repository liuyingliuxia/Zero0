package com.lolinico.technical.open.parent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.lolinico.technical.open.entity.Event;
import com.lolinico.technical.open.utils.EventBusUtil;
import com.lolinico.technical.open.utils.RLog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Rico on 2017/8/4.
 */
public abstract class BaseActivity<R extends RootView> extends AppCompatActivity {
    protected R mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRootView = bindRootChild();
        mRootView.onCreate();
        if (isRegisterEventBus())
            EventBusUtil.register(this);
    }

    protected boolean isRegisterEventBus() {
        if (mRootView != null)
            return mRootView.isRegisterEventBus();
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Event event) {
        if (event != null) {
            onEventDoAction(event);
        }
    }

    /**
     * 通过Event code分发事件
     *
     * @param event
     */
    protected void onEventDoAction(Event event) {
        if (mRootView != null)
            mRootView.onEventDoAction(event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mRootView != null)
            mRootView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mRootView != null)
            mRootView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRootView != null)
            mRootView.onDestroy();
        if (isRegisterEventBus())
            EventBusUtil.unregister(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (mRootView != null)
            mRootView.onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mRootView != null)
            mRootView.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mRootView != null)
            mRootView.onKeyDown(keyCode, event);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
     /*   if (mRootView != null)
            mRootView.dispatchKeyEvent(event);*/
        return super.dispatchKeyEvent(event);
    }

    public abstract R bindRootChild();

}
