package com.lolinico.technical.open.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Rico on 2017/5/15.
 */
public class WidgetUtils {

    /**
     * 获取屏幕DisplayMetrics
     *
     * @param context
     * @return
     */
    public static DisplayMetrics getDm(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay()
                .getMetrics(dm);
        return dm;
    }

    /**
     * 设置高宽
     *
     * @param context
     * @param viewGroup
     * @param x
     * @param y
     */
    public static void setViewParams(Context context, View viewGroup, double x, double y) {
        DisplayMetrics dm = WidgetUtils.getDm(context);
        if (viewGroup.getParent() != null) {
            int pixels = dm.widthPixels > dm.heightPixels ? dm.widthPixels : dm.heightPixels;
            if (viewGroup.getParent() instanceof LinearLayout) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = (int) (pixels * x);
                }
                if (y > 0) {
                    params.height = (int) (pixels * y);
                }
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof RelativeLayout) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = (int) (pixels * x);
                }
                if (y > 0) {
                    params.height = (int) (pixels * y);
                }
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof FrameLayout) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = (int) (pixels * x);
                }
                if (y > 0) {
                    params.height = (int) (pixels * y);
                }
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof ViewGroup) {
                ViewGroup.LayoutParams params = viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = (int) (pixels * x);
                }
                if (y > 0) {
                    params.height = (int) (pixels * y);
                }
                viewGroup.setLayoutParams(params);
            }
        }
    }


    /**
     * 设置高宽 间距
     *
     * @param context
     * @param viewGroup
     * @param x
     * @param y
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public static void setViewMarginsParams(Context context, View viewGroup, double x, double y, double left, double top, double right, double bottom) {
        DisplayMetrics dm = WidgetUtils.getDm(context);
        if (viewGroup.getParent() != null) {
            int pixels = dm.widthPixels > dm.heightPixels ? dm.widthPixels : dm.heightPixels;
            if (viewGroup.getParent() instanceof LinearLayout) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = (int) (pixels * x);
                }
                if (y > 0) {
                    params.height = (int) (pixels * y);
                }
                params.setMargins(0, (int) (top * pixels), 0, (int) (bottom * pixels));
                params.setMarginStart((int) (left * pixels));
                params.setMarginEnd((int) (right * pixels));
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof RelativeLayout) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = (int) (pixels * x);
                }
                if (y > 0) {
                    params.height = (int) (pixels * y);
                }
                params.setMargins(0, (int) (top * pixels), 0, (int) (bottom * pixels));
                params.setMarginStart((int) (left * pixels));
                params.setMarginEnd((int) (right * pixels));
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof FrameLayout) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = (int) (pixels * x);
                }
                if (y > 0) {
                    params.height = (int) (pixels * y);
                }
                params.setMargins(0, (int) (top * pixels), 0, (int) (bottom * pixels));
                params.setMarginStart((int) (left * pixels));
                params.setMarginEnd((int) (right * pixels));
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof ViewGroup) {
                ViewGroup.LayoutParams params = viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = (int) (pixels * x);
                }
                if (y > 0) {
                    params.height = (int) (pixels * y);
                }
                viewGroup.setLayoutParams(params);
            }
        }
    }

    /***
     * 获取比例长宽
     *
     * @param context
     * @param x
     * @param y
     * @return
     */
    public static int[] getXY(Context context, double x, double y) {
        DisplayMetrics dm = WidgetUtils.getDm(context);
        int pixels = dm.widthPixels > dm.heightPixels ? dm.widthPixels : dm.heightPixels;
        int[] xy = new int[2];
        if (x > 0) {
            xy[0] = (int) (pixels * x);
        }
        if (y > 0) {
            xy[1] = (int) (pixels * y);
        }
        return xy;
    }

    /**
     *
     * @param context
     * @param viewGroup
     * @param x
     * @param y
     */
    public static void setViewFixedParams(Context context, View viewGroup, int x, int y) {
        if (viewGroup.getParent() != null) {
            if (viewGroup.getParent() instanceof LinearLayout) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = x;
                }
                if (y > 0) {
                    params.height = y;
                }
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof RelativeLayout) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = x;
                }
                if (y > 0) {
                    params.height = y;
                }
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof FrameLayout) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = x;
                }
                if (y > 0) {
                    params.height = y;
                }
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof ViewGroup) {
                ViewGroup.LayoutParams params = viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = x;
                }
                if (y > 0) {
                    params.height = y;
                }
                viewGroup.setLayoutParams(params);
            }
        }
    }

    /**
     * 设置高宽 间距
     *
     * @param context
     * @param viewGroup
     * @param x
     * @param y
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public static void setViewMarginsFixedParams(Context context, View viewGroup, int x, int y, int left, int top, int right, int bottom) {
        if (viewGroup.getParent() != null) {
            if (viewGroup.getParent() instanceof LinearLayout) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = x;
                }
                if (y > 0) {
                    params.height = y;
                }
                params.setMargins(left, top, right, bottom);
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof RelativeLayout) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = x;
                }
                if (y > 0) {
                    params.height = y;
                }
                params.setMargins(left, top, right, bottom);
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof FrameLayout) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = x;
                }
                if (y > 0) {
                    params.height = y;
                }
                params.setMargins(left, top, right, bottom);
                viewGroup.setLayoutParams(params);
            } else if (viewGroup.getParent() instanceof ViewGroup) {
                ViewGroup.LayoutParams params = viewGroup.getLayoutParams();
                if (x > 0) {
                    params.width = x;
                }
                if (y > 0) {
                    params.height = y;
                }
                viewGroup.setLayoutParams(params);
            }
        }
    }

}
