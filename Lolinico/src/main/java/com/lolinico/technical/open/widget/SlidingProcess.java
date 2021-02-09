package com.lolinico.technical.open.widget;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;

import com.lolinico.technical.open.adapter.MenuRootAdapter;
import com.lolinico.technical.open.utils.WidgetUtils;
import com.steelbar.R;

import java.util.List;

/**
 * Created by Rico on 2017/12/29.
 */

public abstract class SlidingProcess {
    Context mContext;
    SlidingMenu slidingMenu;
    CustomMenuView mCustomMenuView;
    final long DELAY = 30;

    public SlidingProcess() {
        slidingMenu = setSlidingWigdet();
        mContext = slidingMenu.getContext();
        init();
    }

    public abstract SlidingMenu setSlidingWigdet();

    public abstract MenuRootAdapter setMenuAdapter();

    public abstract double setMenuWidthPreX();

    public abstract void notifyMenuData(RecyclerView recyclerView, List<MenuRootAdapter.DataTree> dataTreeList);


    private void init() {
        /**设置可以左右滑动的菜单**/
        slidingMenu.setMode(SlidingMenu.LEFT);
        /**设置滑动阴影的宽度**/
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        /**设置滑动菜单阴影的图像资源**/
        slidingMenu.setShadowDrawable(null);
        /**设置渐入渐出效果的值**/
        slidingMenu.setFadeDegree(0.35f);
        /**设置触摸屏幕的模式,这里设置为全屏**/
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        /**设置下方视图的在滚动时的缩放比例**/
        slidingMenu.setBehindScrollScale(0.0f);
        /**设置滑动菜单视图的宽度**/
        mCustomMenuView = new CustomMenuView(mContext, new SlidingProcessView.OnCustomKeyListener() {
            @Override
            public void doAction(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
                    slidingMenu.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            slidingMenu.showContent();
                        }
                    }, DELAY);

                }
            }
        }) {
            @Override
            public MenuRootAdapter getMenuParentAdapter() {
                return setMenuAdapter();
            }
        };
        notifyMenuData(mCustomMenuView.mRecyelerView, mCustomMenuView.getDataTrees());
        slidingMenu.setMenu(mCustomMenuView);
        WidgetUtils.setViewParams(mContext, mCustomMenuView, setMenuWidthPreX(), 0);
        slidingMenu.setBehindOffsetRes(WidgetUtils.getDm(mContext).widthPixels - WidgetUtils.getXY(mContext, setMenuWidthPreX(), 0)[0]);
    }

    public SlidingMenu getSlidingMenu() {
        return slidingMenu;
    }

    public CustomMenuView getCustomMenuView() {
        return mCustomMenuView;
    }

    public interface OnCustomKeyListener {
        void doAction(View v, int keyCode, KeyEvent event);
    }

    public interface onSlidingStateListener {
        void onSlidingStateFocusListener(boolean isClose);
    }
}
