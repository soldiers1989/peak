package com.masspick.peak.jwt.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by admin on 2018/5/24 0024.
 */
public class ShiroUtil {

    /**
     * 算法长度
     */
    public static final int ALG_LENGTH = 1024;

    /**
     * 密码加密
     *
     * @param password
     * @param salt
     * @return String
     */
    public static String md51024Pwd(String password, Object salt) {
        return new SimpleHash("MD5", password, salt, ALG_LENGTH).toString();
    }

    /**
     * 密码加密
     *
     * @param password
     * @return String
     */
    public static String md5Pwd(String password) {
        return new SimpleHash("MD5", password).toString();
    }

}
