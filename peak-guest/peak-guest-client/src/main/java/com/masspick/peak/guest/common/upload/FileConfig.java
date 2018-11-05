package com.masspick.peak.guest.common.upload;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * FileConfig
 */
@Component
@ConfigurationProperties(prefix = "upload", ignoreUnknownFields = false)
public class FileConfig {

    /**
     * nameCard
     */
    private static final String NAMECARD = "nameCard";

    /**
     * BUSCARD
     */
    private static final String BUSCARD = "bus";

    /**
     * IDCARD
     */
    private static final String IDCARD = "id";

    /**
     * tempFilePath
     */
    private String tempFilePath;

    /**
     * @return String
     */
    public String getTempFilePath() {
        return tempFilePath;
    }

    /**
     * @param tempFilePath
     */
    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
    }

    /**
     * @return String
     */
    public static String getBusCard() {
        return BUSCARD;
    }

    /**
     * @return String
     */
    public static String getIdCard() {
        return IDCARD;
    }

    /**
     * @return String
     */
    public static String getNameCard() {
        return NAMECARD;
    }
}
