package com.masspick.peak.resource.controller.vo;


/**
 * ApiResponse
 */
public final class ApiResponse {

    /**
     * 业务状态码
     */
    private String code;
    /**
     * 错误提示消息
     */
    private String reason = "";

    /**
     * 用户需要发送的参数
     */
    private Object result = "";

    /**
     * 成功状态码
     */
    private static final String SUCCESS = "200";

    private ApiResponse() {
    }

    /**
     * 生成方法构造器
     *
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
     * @param code   code
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
     * @return ApiResponse
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
     * @return ApiResponse
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

