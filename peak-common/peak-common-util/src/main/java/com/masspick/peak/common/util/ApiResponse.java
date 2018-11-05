package com.masspick.peak.common.util;

/**
 * Created by admin on 2018/5/23 0023.
 */
public final class ApiResponse {

    /**
     * 返回业务状态码
     */
    private String code;


    /**
     * 返回消息
     */
    private String reason = "";

    /**
     * 用户需要发送的参数
     */
    private Object result = null;

    /**
     * 成功标记
     */
    private static final String SUCCESS = "200";

    /**
     * 屏蔽无参构造参数
     */
    private ApiResponse() {
    }

    /**
     * @return ApiResponse
     */
    public static ApiResponse getInstances() {
        return new ApiResponse();
    }


    /**
     * @return ApiResponse
     */
    public ApiResponse success() {
        setCode(SUCCESS);
        return this;
    }

    /**
     * @param result result
     * @return ApiResponse
     */
    public ApiResponse success(Object result) {
        setCode(SUCCESS);
        setResult(result);
        return this;
    }

    /**
     * @param code code
     * @return ApiResponse
     */
    public ApiResponse error(String code) {
        setCode(code);
        return this;
    }

    /**
     * @param code code
     * @param reason reason
     * @return ApiResponse
     */
    public ApiResponse error(String code, String reason) {
        setCode(code);
        setReason(reason);
        return this;
    }

    /**
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code code
     * @return ApiResponse
     */
    public ApiResponse setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * @return Object
     */
    public Object getResult() {
        return result;
    }

    /**
     * @param result result
     * @return ApiResponse
     */
    public ApiResponse setResult(Object result) {
        this.result = result;
        return this;
    }

    /**
     * @return String
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason reason
     * @return ApiResponse
     */
    public ApiResponse setReason(String reason) {
        this.reason = reason;
        return this;
    }
}
