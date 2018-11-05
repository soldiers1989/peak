package com.masspick.peak.common.model;

/**
 * Created by Administrator on 2016/11/15.
 */
public enum ErrorCode {

    /**
     * 成功标志
     */
    SUCCESS("200", "success"),

    /**
     * 未知错误
     */
    ERROR_500("ERR-500", "系统错误"),

    /**
     * 未找到
     */
    ERROR_404("ERR-404", "未找到指定资源"),


    /**
     * 未知错误
     */
    UNKNOW_ERROR("ERR-001", "未知错误");

    /**
     * code
     */
    private String code;

    /**
     * reason
     */
    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Gets code
     *
     * @return value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets msg
     *
     * @return value of msg
     */
    public String getMsg() {
        return msg;
    }
}
