package com.zeasn.zero0.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.githang.statusbar.StatusBarCompat;
import com.zeasn.zero0.R;

/**
 * Author:Miracle.Lin
 * Date:2021/1/31
 * Email:miracle.lin@zeasn.com
 * Descripe:
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置沉浸式状态栏
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.white), true);
    }
}
