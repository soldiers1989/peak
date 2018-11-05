package com.masspick.peak.model.dto;

import java.io.ByteArrayInputStream;
import java.io.File;

/**
 * Created by admin on 2018/7/10 0010.
 */
public class COSDTO {

    /**
     * key
     */
    private String key;

    /**
     * bucketName
     */
    private String bucketName;

    /**
     * filePath
     */
    private String filePath;

    /**
     * file
     */
    private File file;

    /**
     * inputStream
     */
    private ByteArrayInputStream inputStream;

    /**
     * objectMetadata
     */
    private Object objectMetadata;

    /**
     * Gets filePath
     *
     * @return value of filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Gets file
     *
     * @return value of file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Gets key
     *
     * @return value of key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Gets bucketName
     *
     * @return value of bucketName
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * @param bucketName
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * Gets inputStream
     *
     * @return value of inputStream
     */
    public ByteArrayInputStream getInputStream() {
        return inputStream;
    }

    /**
     * @param inputStream
     */
    public void setInputStream(ByteArrayInputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Gets objectMetadata
     *
     * @return value of objectMetadata
     */
    public Object getObjectMetadata() {
        return objectMetadata;
    }

    /**
     * @param objectMetadata
     */
    public void setObjectMetadata(Object objectMetadata) {
        this.objectMetadata = objectMetadata;
    }
}
