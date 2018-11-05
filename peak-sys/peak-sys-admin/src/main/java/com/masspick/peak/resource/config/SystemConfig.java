package com.masspick.peak.resource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2018/9/19 0019.
 */
@Configuration
public class SystemConfig {

    /**
     * fileDir
     */
    @Value("${file.dir}")
    private String fileDir;

    /**
     * fileDir
     */
    @Value("${file.zipDir}")
    private String zipDir;

    /**
     * fileDir
     */
    @Value("${guest.url}")
    private String guestUrl;

    /**
     * Gets fileDir
     *
     * @return value of fileDir
     */
    public String getFileDir() {
        return fileDir;
    }

    /**
     * @param fileDir fileDir
     */
    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    /**
     * Gets zipDir
     *
     * @return value of zipDir
     */
    public String getZipDir() {
        return zipDir;
    }

    /**
     * @param zipDir zipDir
     */
    public void setZipDir(String zipDir) {
        this.zipDir = zipDir;
    }

    /**
     * Gets guestUrl
     *
     * @return value of guestUrl
     */
    public String getGuestUrl() {
        return guestUrl;
    }

    /**
     * @param guestUrl guestUrl
     */
    public void setGuestUrl(String guestUrl) {
        this.guestUrl = guestUrl;
    }
}
