package com.masspick.peak.common.model;

import java.io.Serializable;


/**
 * @param <T>
 */
public class Result<T> implements Serializable {

    /**
     * code
     */
    private String code;

    /**
     * msg
     */
    private String msg;

    /**
     * data
     */
    private T data;

    /**
     * @param code
     * @param msg
     * @param data
     */
    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return String
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return <T>
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
}
