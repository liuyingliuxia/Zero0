package com.lolinico.technical.open.request;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.lolinico.technical.open.utils.RLog;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Rico on 2016/8/15.
 */
public class HttpParamer {
    private final String M = "?";
    private Context mContext;
    public String urlKey;
    public String mMethod;
    public int mRequestMode;
    public String Http_IP = "";
    public long out_Time = 10L;
    public long read_Time = 10L;
    private Map<String, String> mParams;

    private ResponeListener responeListener;
    public static final int HTTP_REQUEST_TYPE_GET = 0;
    public static final int HTTP_REQUEST_TYPE_POST = 1;


    /**
     * @param listener
     */
    public HttpParamer(Context context, boolean isPost, ResponeListener listener) {
        init();
        mContext = context;
        responeListener = listener;
        mParams = new HashMap<>();
        if (isPost) {
            mRequestMode = HTTP_REQUEST_TYPE_POST;
        }
    }

    private void init() {
        Http_IP = PullUtils.getInstance().getHttpParams(mContext, "ApiUrl", "");
        out_Time = Long.parseLong(PullUtils.getInstance().getHttpParams(mContext, "ApiUrlOutTime", ""));
        read_Time = Long.parseLong(PullUtils.getInstance().getHttpParams(mContext, "ApiReadTime", ""));
        RLog.v("Http_IP-" + Http_IP + "\nout_Time-" + out_Time + "\nread_Time-" + read_Time);
    }

    public void setUrlKey(String urlKey) {
        Http_IP = PullUtils.getInstance().getHttpParams(mContext, "ApiUrl", urlKey);
        RLog.v("Http_IP-" + Http_IP);
    }

    public void addParam(String key, String value) {
        mParams.put(key, value);
    }

    public String getParams() {
        if (mParams.size() <= 0)
            return "";
        String paramString = "";
        for (ConcurrentHashMap.Entry<String, String> entry : mParams.entrySet()) {
            paramString += "&" + entry.getKey() + "=" + entry.getValue();
        }
        return paramString.substring(1);
    }


    public String getUrl() {
        if (mRequestMode == HTTP_REQUEST_TYPE_POST)
            return Http_IP + mMethod;
        else
            return Http_IP + mMethod + M + getParams();
    }

    protected void onHttpReturn(Context context, String result) {
        msgHandler.sendMessage(msgHandler.obtainMessage(MSG_SEND_RESULT, result));
    }

    private final int MSG_SEND_RESULT = 0;
    private Handler msgHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SEND_RESULT:
                    String result = (String) msg.obj;
                    responeListener.onResponeResult(result);
                    break;
            }
        }
    };

    protected void onNetworkError() {
        msgHandler.sendMessage(msgHandler.obtainMessage(MSG_SEND_RESULT, "Please check your Internet connection."));
    }

    /**
     * do action
     */
    public void doAction() {
        ExecutorpoolServiceApi.getInstance().execServerApi(mContext, this);
    }


}
