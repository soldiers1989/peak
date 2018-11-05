package com.masspick.peak.model.dto.tax;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 税务相应参数
 * @param <T>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxResponseDTO<T> implements Serializable {

    private static final long serialVersionUID = 4223554481088098412L;

    /**
     * resCode
     */
    private String resCode;

    /**
     * resDesc
     */
    private String resDesc;

    /**
     * data
     */
    private T data;


    /**
     * queryOrderNumber
     */
    private String queryOrderNumber;

    /**
     * requestIp
     */
    private String requestIp;

    /**
     * Gets resCode
     *
     * @return value of resCode
     */
    public String getResCode() {
        return resCode;
    }

    /**
     * @param resCode
     */
    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    /**
     * Gets resDesc
     *
     * @return value of resDesc
     */
    public String getResDesc() {
        return resDesc;
    }

    /**
     * @param resDesc
     */
    public void setResDesc(String resDesc) {
        this.resDesc = resDesc;
    }

    /**
     * Gets data
     *
     * @return value of data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets queryOrderNumber
     *
     * @return value of queryOrderNumber
     */
    public String getQueryOrderNumber() {
        return queryOrderNumber;
    }

    /**
     * @param queryOrderNumber
     */
    public void setQueryOrderNumber(String queryOrderNumber) {
        this.queryOrderNumber = queryOrderNumber;
    }

    /**
     * Gets requestIp
     *
     * @return value of requestIp
     */
    public String getRequestIp() {
        return requestIp;
    }

    /**
     * @param requestIp
     */
    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }
}


