package com.masspick.peak.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
     * @return COSClient
     */
    @Bean
    public COSClient client() {
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        return new COSClient(cred, clientConfig);
    }

    /**
     * @return ObjectMapper
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
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
}
