package com.masspick.peak.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * CosPathConfig
 */
@Configuration
public class CosPathConfig {

    /**
     * cosUrl
     */
    @Value("${cos.url}")
    private String cosUrl;

    /**
     * cosDir
     */
    @Value("${cos.dir}")
    private String cosDir;

    /**
     * cosBucketName
     */
    @Value("${cos.bucket.name}")
    private String cosBucketName;

    /**
     * Gets cosBucketName
     *
     * @return value of cosBucketName
     */
    public String getCosBucketName() {
        return cosBucketName;
    }

    /**
     * @param cosBucketName
     */
    public void setCosBucketName(String cosBucketName) {
        this.cosBucketName = cosBucketName;
    }

    /**
     * Gets cosUrl
     *
     * @return value of cosUrl
     */
    public String getCosUrl() {
        return cosUrl;
    }

    /**
     * @param cosUrl
     */
    public void setCosUrl(String cosUrl) {
        this.cosUrl = cosUrl;
    }

    /**
     * Gets cosDir
     *
     * @return value of cosDir
     */
    public String getCosDir() {
        return cosDir;
    }

}