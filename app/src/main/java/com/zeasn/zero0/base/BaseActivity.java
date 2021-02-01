package com.zeasn.zero0.base;

import android.app.usage.UsageEvents;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import com.githang.statusbar.StatusBarCompat;
import com.zeasn.zero0.R;
import com.zeasn.zero0.bean.Event;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Author:Miracle.Lin
 * Date:2021/1/31
 * Email:miracle.lin@zeasn.com
 * Descripe:
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置沉浸式状态栏
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.white), true);
        setContentView(getContentId());
        initView();
    }

    public abstract void initView();

    public abstract int getContentId();

    public abstract void requestDataAction();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Event event) {
        if(event  !=null)
            onEventDoAction(event);
    }

    protected void onEventDoAction(Event event){

    }


}
