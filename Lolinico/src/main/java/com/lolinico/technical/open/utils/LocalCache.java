package com.lolinico.technical.open.utils;

import java.util.HashMap;

/**
 * Created by Rico on 2017/8/3.
 */
public class LocalCache {
    public static HashMap<String, Object> saveMap;
    public static LocalCache mLocalCache;

    /**
     * 单例
     *
     * @return
     */
    public static LocalCache getInstance() {
        if (mLocalCache == null) {
            saveMap = new HashMap<>();
            mLocalCache = new LocalCache();
        }
        return mLocalCache;
    }

    /**
     * save object to pool
     *
     * @param key
     * @param object
     */
    public void putPoolValue(String key, Object object) {
        if (saveMap != null) {
            saveMap.put(key, object);
        }
    }

    /**
     * get object from pool
     *
     * @param key
     * @return
     */
    public Object getPoolValue(String key) {
        if (saveMap != null) {
            return saveMap.get(key);
        }
        return null;
    }

}
