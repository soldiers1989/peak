package com.masspick.peak.common.util;

import java.io.Serializable;

/**
 * CacheEntity
 */
public class CacheEntity implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3971709196436977492L;

    /**
     * //默认过期时间 20秒
     */
    private static final int DEFUALTVALIDITYTIME = 20;

    /**
     * 秒
     */
    private static final int SECOND = 1000;

    /**
     * cacheKey
     */
    private String cacheKey;
    /**
     * cacheContext
     */
    private Object cacheContext;

    /**
     * Gets cacheKey
     *
     * @return value of cacheKey
     */
    public String getCacheKey() {
        return cacheKey;
    }

    /**
     * @param cacheKey cacheKey
     */
    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    /**
     * Gets cacheContext
     *
     * @return value of cacheContext
     */
    public Object getCacheContext() {
        return cacheContext;
    }

    /**
     * @param cacheContext cacheContext
     */
    public void setCacheContext(Object cacheContext) {
        this.cacheContext = cacheContext;
    }

    /**
     * Gets validityTime
     *
     * @return value of validityTime
     */
    public int getValidityTime() {
        return validityTime;
    }

    /**
     * @param validityTime
     */
    public void setValidityTime(int validityTime) {
        this.validityTime = validityTime;
    }

    /**
     * Gets timeoutStamp
     *
     * @return value of timeoutStamp
     */
    public long getTimeoutStamp() {
        return timeoutStamp;
    }

    /**
     * @param timeoutStamp
     */
    public void setTimeoutStamp(long timeoutStamp) {
        this.timeoutStamp = timeoutStamp;
    }

    /**
     * //有效期时长，单位：秒
     */
    private int validityTime;
    /**
     * //过期时间戳
     */
    private long timeoutStamp;

    private CacheEntity() {
        this.timeoutStamp = System.currentTimeMillis() + DEFUALTVALIDITYTIME * SECOND;
        this.validityTime = DEFUALTVALIDITYTIME;
    }

    /**
     * @param cacheKey
     * @param cacheContext
     */
    public CacheEntity(String cacheKey, Object cacheContext) {
        this();
        this.cacheKey = cacheKey;
        this.cacheContext = cacheContext;
    }

    /**
     * @param cacheKey
     * @param cacheContext
     * @param timeoutStamp
     */
    public CacheEntity(String cacheKey, Object cacheContext, long timeoutStamp) {
        this(cacheKey, cacheContext);
        this.timeoutStamp = timeoutStamp;
    }

    /**
     * @param cacheKey
     * @param cacheContext
     * @param validityTime
     */
    public CacheEntity(String cacheKey, Object cacheContext, int validityTime) {
        this(cacheKey, cacheContext);
        this.validityTime = validityTime;
        this.timeoutStamp = System.currentTimeMillis() + validityTime * SECOND;
    }


}
