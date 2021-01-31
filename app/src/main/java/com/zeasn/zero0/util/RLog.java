package com.zeasn.zero0.util;

import android.util.Log;


public class RLog {
    public static String TAG = "zero0===";
    public static boolean isTag = true;

    public static void v(String text) {
        if (isTag)
            Log.v(TAG, text);
    }

    public static void e(String text) {
        if (isTag)
            Log.e(TAG, text);
    }


}
