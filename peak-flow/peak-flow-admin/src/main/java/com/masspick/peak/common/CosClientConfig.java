package com.masspick.peak.common;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CosClientConfig
 */
@Configuration
public class CosClientConfig {

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
     * @return COSClient
     */
    @Bean
    public COSClient client() {
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        return new COSClient(cred, clientConfig);
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
     * @param accessKey accessKey
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
     * @param secretKey secretKey
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
     * @param region region
     */
    public void setRegion(String region) {
        this.region = region;
    }
}
