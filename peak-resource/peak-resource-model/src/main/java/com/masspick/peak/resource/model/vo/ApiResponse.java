package com.masspick.peak.resource.model.vo;

import java.io.Serializable;

/**
 * 所有Http Response数据结构，只要是给客户端提供服务的，都要使用该对象返回
 * 缺少返回requstId 暂时没用上 对应实体类RequsetIDContext
 *
 * @author huqilang
 */
public final class ApiResponse implements Serializable {
    private static final long serialVersionUID = -1485867865440737606L;

    /**
     * success
     */
    private static final String SUCCESS = "200";
    /**
     * ERR_405
     */
    private static final String ERR_405 = "405"; //参数无效
    /**
     * ERR_404
     */
    private static final String ERR_404 = "404";
    /**
     * code
     */
    private String code;                       // 返回业务状态码
    /**
     * timestamp
     */
    private long timestamp;                    // 响应请求的时间戳
    /**
     * reason
     */
    private String reason;                       // 返回消息
    /**
     * result
     */
    private Object result;                       // 用户需要发送的参数
    /**
     * errmsg
     */
    private String errmsg;

    /**
     * @return String
     */
    public String getErrmsg() {
        return errmsg;
    }

    /**
     * @param errmsg
     * @return ApiResponse
     */
    public ApiResponse setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }


    /**
     * 构造函数
     */
    private ApiResponse() {
        this.timestamp = System.currentTimeMillis();
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
     * @param code
     * @return ApiResponse
     */
    public ApiResponse success(String code) {
        setCode(code);
        return this;
    }

    /**
     * @param code
     * @return ApiResponse
     */
    public ApiResponse error(String code) {
        setCode(code);
        return this;
    }

    /**
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     * @return ApiResponse
     */
    public ApiResponse setCode(String code) {
        this.code = code;
        return this;
    }


    /**
     * @return long
     */
    public long getTimestamp() {
        return timestamp;
    }


    /**
     * @return Object
     */
    public Object getResult() {
        return result;
    }

    /**
     * @param result
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
     * @param reason
     * @return ApiResponse
     */
    public ApiResponse setReason(String reason) {
        this.reason = reason;
        return this;
    }
}
