package com.masspick.peak.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * FileConfigFlow
 */
@Component
@ConfigurationProperties(prefix = "upload")
public class FileConfigFlow {

    /**
     * workFolderName
     */
    @Value("${upload.work-folder-name}")
    private String workFolderName;

    /**
     * @return String
     */
    public String getWorkFolderName() {
        return workFolderName;
    }

    /**
     * @param workFolderName
     */
    public void setWorkFolderName(String workFolderName) {
        this.workFolderName = workFolderName;
    }
}
