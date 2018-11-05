package com.masspick.peak.dd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2018/5/31 0031.
 */
@Configuration
public class SystemConfig {

    /**
     * casServerUrlPrefix
     */
    @Value("${shiro.cas}")
    private String casServerUrlPrefix;

    /**
     * shiroServerUrlPrefix
     */
    @Value("${shiro.server}")
    private String shiroServerUrlPrefix;

    /**
     * zuulUrl
     */
    @Value("${zuul.url}")
    private String zuulUrl;

    /**
     * appId
     */
    @Value("${resource.appId}")
    private String appId;
    /**
     * Gets casServerUrlPrefix
     *
     * @return value of casServerUrlPrefix
     */
    public String getCasServerUrlPrefix() {
        return casServerUrlPrefix;
    }

    /**
     * @param casServerUrlPrefix
     */
    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
    }

    /**
     * Gets shiroServerUrlPrefix
     *
     * @return value of shiroServerUrlPrefix
     */
    public String getShiroServerUrlPrefix() {
        return shiroServerUrlPrefix;
    }

    /**
     * @param shiroServerUrlPrefix
     */
    public void setShiroServerUrlPrefix(String shiroServerUrlPrefix) {
        this.shiroServerUrlPrefix = shiroServerUrlPrefix;
    }

    /**
     * Gets zuulUrl
     *
     * @return value of zuulUrl
     */
    public String getZuulUrl() {
        return zuulUrl;
    }

    /**
     * @param zuulUrl
     */
    public void setZuulUrl(String zuulUrl) {
        this.zuulUrl = zuulUrl;
    }

    /**
     * Gets appId
     *
     * @return value of appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }
}
