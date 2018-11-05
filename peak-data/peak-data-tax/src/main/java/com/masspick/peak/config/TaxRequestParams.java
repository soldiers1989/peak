package com.masspick.peak.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 税务请求参数固定参数
 */

@Component
@ConfigurationProperties(prefix = "tax")
@PropertySource("classpath:taxrequest.properties")
public class TaxRequestParams {


    /**
     * channel
     */
    private String channel;

    /**
     * userName
     */
    private String userName;

    /**
     * sign
     */
    private String sign;

    /**
     * accessAddress
     */
    private String accessAddress;

    /**
     * Gets channel
     *
     * @return value of channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Gets userName
     *
     * @return value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets sign
     *
     * @return value of sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * Gets accessAddress
     *
     * @return value of accessAddress
     */
    public String getAccessAddress() {
        return accessAddress;
    }

    /**
     * @param accessAddress
     */
    public void setAccessAddress(String accessAddress) {
        this.accessAddress = accessAddress;
    }
}
