package com.masspick.peak.resource.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2018/7/10 0010.
 */
@Configuration
public class COSConfig {

    /**
     * accessKey
     */
    @Value("${cos.accessKey}")
    private String accessKey;

    /**
     * secretKey
     */
    @Value("${cos.secretKey}")
    private String secretKey;

    /**
     * region
     */
    @Value("${cos.region}")
    private String region;

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
     * downloadUrl
     */
    @Value("${cos.downloadUrl}")
    private String cosDownloadUrl;

    /**
     * @return COSClient
     */
    @Bean
    public COSClient client() {
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        return new COSClient(cred, clientConfig);
    }


    /**
     * Gets cosDownloadUrl
     *
     * @return value of cosDownloadUrl
     */
    public String getCosDownloadUrl() {
        return cosDownloadUrl;
    }

    /**
     * @param cosDownloadUrl cosDownloadUrl
     */
    public void setCosDownloadUrl(String cosDownloadUrl) {
        this.cosDownloadUrl = cosDownloadUrl;
    }

    /**
     * Gets accessKey
     *
     * @return value of accessKey
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * @param accessKey
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * Gets secretKey
     *
     * @return value of secretKey
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * @param secretKey
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Gets region
     *
     * @return value of region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
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
     * @param cosUrl cosUrl
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

    /**
     * @param cosDir cosDir
     */
    public void setCosDir(String cosDir) {
        this.cosDir = cosDir;
    }

    /**
     * Gets cosBucketName
     *
     * @return value of cosBucketName
     */
    public String getCosBucketName() {
        return cosBucketName;
    }

    /**
     * @param cosBucketName cosBucketName
     */
    public void setCosBucketName(String cosBucketName) {
        this.cosBucketName = cosBucketName;
    }
}