package com.zeasn.zero0.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tencent.bugly.crashreport.CrashReport;
import com.zeasn.zero0.R;
import com.zeasn.zero0.base.BaseActivity;
import com.zeasn.zero0.util.RLog;

import butterknife.BindView;
import butterknife.OnClick;

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.tvTest)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        startActivity(new Intent(this , MainActivity.class));
    }

    @OnClick(R.id.tvTest)
    private void OnClick(View view){
        switch (view.getId()){
            case R.id.tvTest:
                CrashReport.testJavaCrash();
                RLog.e("you touch tvTest!");
                break;
        }
    }
}