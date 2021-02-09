package com.zeasn.zero0.util;

import com.zeasn.zero0.bean.Type;
import com.zeasn.zero0.fragment.TabFragment;

/**
 * Created by Rico on 2018/4/11.
 */

public class FragmentManager {
    public static TabFragment bindFragment(int tabType) {
        TabFragment fragment = null;
        switch (tabType) {
            case Type.TAB_FRAGMENT_TYPE_STORY:
            case Type.TAB_FRAGMENT_TYPE_TOPIC:
            case Type.TAB_FRAGMENT_TYPE_MESSAGE:
            case Type.TAB_FRAGMENT_TYPE_MY:
                fragment = TabFragment.newInstance(tabType);
                break;
        }
        return fragment;
    }
}
