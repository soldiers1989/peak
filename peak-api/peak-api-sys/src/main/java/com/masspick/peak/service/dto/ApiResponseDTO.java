package com.masspick.peak.service.dto;

/**
 *  权限接口相应DTO
 */
public final class ApiResponseDTO {
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

    private ApiResponseDTO() {
    }

    /**
     * 生成方法构造器
     *
     * @return ApiResponseDTO
     */
    public static ApiResponseDTO getInstances() {
        return new ApiResponseDTO();
    }

    /**
     * @return ApiResponseDTO
     */
    public ApiResponseDTO success() {
        setCode(SUCCESS);
        return this;
    }

    /**
     * @param result result
     * @return ApiResponseDTO
     */
    public ApiResponseDTO success(Object result) {
        setCode(SUCCESS);
        setResult(result);
        return this;
    }

    /**
     * @param code code
     * @return ApiResponseDTO
     */
    public ApiResponseDTO error(String code) {
        setCode(code);
        return this;
    }

    /**
     * @param code   code
     * @param reason reason
     * @return ApiResponseDTO
     */
    public ApiResponseDTO error(String code, String reason) {
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
     * @return ApiResponseDTO
     */
    public ApiResponseDTO setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * @return ApiResponseDTO
     */
    public Object getResult() {
        return result;
    }

    /**
     * @param result result
     * @return ApiResponseDTO
     */
    public ApiResponseDTO setResult(Object result) {
        this.result = result;
        return this;
    }

    /**
     * @return ApiResponseDTO
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason reason
     * @return ApiResponseDTO
     */
    public ApiResponseDTO setReason(String reason) {
        this.reason = reason;
        return this;
    }
}
