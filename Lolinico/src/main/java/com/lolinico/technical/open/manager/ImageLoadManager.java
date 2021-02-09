package com.lolinico.technical.open.manager;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.steelbar.R;

/**
 * Created by Administrator on 2017/12/26.
 */

public class ImageLoadManager {

    private static ImageLoadManager instance;
    private RequestOptions mOptions;

    private ImageLoadManager() {
        mOptions = new RequestOptions()
                .centerCrop()
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.NONE);
    }

    public synchronized static ImageLoadManager getInstance() {
        if (instance == null)
            instance = new ImageLoadManager();
        return instance;
    }

    /**
     * 使用默认的配置加载图片
     * @param url
     * @param context
     * @param imageView
     */
    public void displayImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(mOptions)
                .into(imageView);
    }

    /**
     * 初始化配置，提供“图片未加载出来时”和“图片加载错误时”的设置
     * @param url 图片的网络链接
     * @param context
     * @param imageView 加载图片的控件
     * @param defaultDrawableId //未加载完成默认的图片的id
     * @param errorDrawableId //加载错误显示的图片的id
     */
    public void displayImage(Context context, String url, ImageView imageView, int defaultDrawableId, int errorDrawableId) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(defaultDrawableId) //未加载完成默认的图片
                .error(errorDrawableId) //加载错误显示的图片
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }


}
