package com.lolinico.technical.open.request;

import android.content.Context;

import com.lolinico.technical.open.utils.NetWorkUtils;
import com.lolinico.technical.open.utils.RLog;
import com.lolinico.technical.open.utils.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Created by Administrator on 2016/8/12.
 */
public class ExecutorpoolServiceApi {
    private final int CODE = 200;
    //    private ExecutorService executorService = Executors.newFixedThreadPool(30);// 线程池
    private static ExecutorpoolServiceApi executorpoolController;
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(15);

    private ThreadPoolExecutor executorService = new ThreadPoolExecutor(15, 15, 1, TimeUnit.MINUTES, queue, new ThreadPoolExecutor.CallerRunsPolicy());

    /****
     * 获取单例
     */
    public static ExecutorpoolServiceApi getInstance() {
        if (executorpoolController == null) {
            executorpoolController = new ExecutorpoolServiceApi();
        }
        return executorpoolController;
    }

    /**
     * 调用该函数执行服务器上相应的API，onResult中返回从服务器上获取到的String
     * ，HttpRequestTask本身已经做好了一个线程池来执行execServerApi
     */

    public void execServerApi(Context context, final HttpParamer api) {
        if (NetWorkUtils.isNetworkOpen(context)) {
            Runnable runnable = newRunnable(context, api);
            executorService.submit(runnable);
        } else {
            api.onNetworkError();
        }
    }

    /****
     * HTTP请求
     *
     * @param context
     * @param api
     * @return
     */
    private Runnable newRunnable(final Context context, final HttpParamer api) {
        Runnable run = new Runnable() {
            private String result = ""; // 返回结果数据

            @Override
            public void run() {
                /* 发送HTTP请求 */
                try {
                    if (api.mRequestMode == HttpParamer.HTTP_REQUEST_TYPE_POST) {
                        result = sendPostRequest(api);
                    } else {
                        result = sendGetRequest(api);
                    }
                    api.onHttpReturn(context, result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        return run;
    }

    public String sendPostRequest(HttpParamer api) {
        String value = "";
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(api.getUrl())
                    .openConnection();
            conn.setConnectTimeout((int) api.out_Time);
            conn.setReadTimeout((int) api.read_Time);
            conn.setDoOutput(true);// 允许输出
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.addRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            conn.addRequestProperty("Charset", "utf-8");
            conn.connect();
            PrintWriter output = new PrintWriter(conn.getOutputStream());
            String data = StringUtils.toUtf8String(api.getParams());
            RLog.v("Url==>" + api.getUrl() + "\n-Param==>" + data + "\n-Code==>" + conn.getResponseCode());
            output.print(data);
            output.flush();
            output.close();
            if (conn.getResponseCode() == CODE) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuffer buffer = new StringBuffer(1024);
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                value = buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public String sendGetRequest(HttpParamer api) {
        String value = "";
        try {
            String url = api.getUrl();
            HttpURLConnection conn = (HttpURLConnection) new URL(url)
                    .openConnection();
            conn.setConnectTimeout((int) api.out_Time);
            conn.setReadTimeout((int) api.read_Time);
            conn.setRequestMethod("GET");
            conn.addRequestProperty("Content-Type", "text/xml");
            conn.addRequestProperty("Charset", "utf-8");
            conn.connect();

            RLog.v("Url===>" + url + "\n-Code==>" + conn.getResponseCode());
            if (conn.getResponseCode() == CODE) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuffer buffer = new StringBuffer(1024);
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                value = buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
