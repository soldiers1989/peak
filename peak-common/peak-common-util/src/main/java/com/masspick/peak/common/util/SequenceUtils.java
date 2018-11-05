package com.masspick.peak.common.util;

import java.util.UUID;

/**
 * Created by Administrator on 2017/6/3.
 */
public final class SequenceUtils {

    /**
     * 工具类应隐藏public构造器
     */
    private SequenceUtils() {

    }

    /**
     * @return UUID
     */
    public static synchronized String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
