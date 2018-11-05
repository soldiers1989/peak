package com.masspick.peak.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * PushConfig
 */
@Configuration
public class PushConfig {

    /**
     * pushUrl
     */
    @Value("${epProect.url}")
    private String pushUrl;

    /**
     * desKey
     */
    @Value("${epProect.key}")
    private String desKey;


    /**
     * Gets pushUrl
     *
     * @return value of pushUrl
     */
    public String getPushUrl() {
        return pushUrl;
    }

    /**
     * @param pushUrl pushUrl
     */
    public void setPushUrl(String pushUrl) {
        this.pushUrl = pushUrl;
    }

    /**
     * Gets desKey
     *
     * @return value of desKey
     */
    public String getDesKey() {
        return desKey;
    }

    /**
     * @param desKey desKey
     */
    public void setDesKey(String desKey) {
        this.desKey = desKey;
    }
}
