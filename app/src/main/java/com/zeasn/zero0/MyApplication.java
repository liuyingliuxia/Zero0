package com.zeasn.zero0;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDex;

import com.tencent.bugly.crashreport.CrashReport;
import com.zeasn.zero0.util.AppUtil;
import com.zeasn.zero0.util.RLog;

/**
 * Author:Miracle.Lin
 * Date:2021/1/31
 * Email:miracle.lin@zeasn.com
 * Descripe:
 */
public class MyApplication extends Application implements Thread.UncaughtExceptionHandler  {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        Thread.setDefaultUncaughtExceptionHandler(this);

        // 获取当前包名
        String packageName = context.getPackageName();
        // 获取当前进程名
        String processName = AppUtil.getProcessName(android.os.Process.myPid());
        RLog.e("packageName==" + packageName + "processName==" + processName);
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        // 初始化Bugly
        CrashReport.initCrashReport(context, getResources().getString(R.string.bugly_appid), false, strategy);
    }

    public static Context getContext() {
        if (context == null) {
            synchronized (MyApplication.class) {
                if (context == null) {
                    new MyApplication();
                }
            }
        }
        return context;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        AppUtil.writeErrorLog(e);
    }
}
