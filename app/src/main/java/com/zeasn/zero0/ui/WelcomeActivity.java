package com.zeasn.zero0.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lolinico.technical.open.parent.BaseActivity;
import com.lolinico.technical.open.parent.RootView;
import com.tencent.bugly.crashreport.CrashReport;
import com.zeasn.zero0.R;
import com.zeasn.zero0.util.RLog;
import com.zeasn.zero0.view.WelcomeView;

import butterknife.BindView;
import butterknife.OnClick;

public class WelcomeActivity extends BaseActivity {

    @Override
    public RootView bindRootChild() {
        return new WelcomeView(this);
    }
}