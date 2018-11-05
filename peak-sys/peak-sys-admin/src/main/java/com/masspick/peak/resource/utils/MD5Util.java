package com.masspick.peak.resource.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by admin on 2018/8/15 0015.
 */
public class MD5Util {

    protected MD5Util() {
    }

    /**
     * 密码加密
     *
     * @param password password
     * @return String
     */
    public static String md5Pwd(String password) {
        return new SimpleHash("MD5", password).toString();
    }
}
