package com.masspick.peak.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *  企查查key值配置
 */
@Configuration
public class EtpConfig {
    /**
     * key
     */
    @Value("${yjapi.key}")
    private String key;

    /**
     *  url
     */
    @Value("${yjapi.url}")
    private String url;

    /**
     * Gets key
     *
     * @return value of key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Gets url
     *
     * @return value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
