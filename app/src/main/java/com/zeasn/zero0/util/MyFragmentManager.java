package com.zeasn.zero0.util;

import androidx.fragment.app.Fragment;

import com.zeasn.zero0.bean.Type;
import com.zeasn.zero0.fragment.MessageFragment;
import com.zeasn.zero0.fragment.MyFragment;
import com.zeasn.zero0.fragment.TabFragment;
import com.zeasn.zero0.fragment.TopicFragment;
import com.zeasn.zero0.fragment.ZeroFragment;

/**
 * @deprecated
 */
public class MyFragmentManager {
    public static Fragment bindFragment(int tabType) {
        Fragment fragment = null;
        switch (tabType) {
            case Type.TAB_FRAGMENT_TYPE_STORY:
                fragment = new ZeroFragment();
                break;
            case Type.TAB_FRAGMENT_TYPE_TOPIC:
                fragment = new TopicFragment();
                break;
            case Type.TAB_FRAGMENT_TYPE_MESSAGE:
                fragment = new MessageFragment();
                break;
            case Type.TAB_FRAGMENT_TYPE_MY:
                fragment = new MyFragment();
                break;
        }
        return fragment;
    }
}
