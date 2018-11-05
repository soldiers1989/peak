package com.masspick.peak.common.model;

import java.io.Serializable;

/**
 * 所有Http Response数据结构，只要是给客户端提供服务的，都要使用该对象返回
 * 缺少返回requstId 暂时没用上 对应实体类RequsetIDContext
 *
 * @author huqilang
 */
public final class ApiResponse implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1485867865440737606L;

    /**
     * SUCCESS
     */
    private static final String SUCCESS = "200";

    /**
     * 参数无效
     */
    private static final String ERR_405 = "405";

    /**
     * 返回业务状态码
     */
    private static final String ERR_404 = "404";

    /**
     * 返回业务状态码
     */
    private String code;

    /**
     * 响应请求的时间戳
     */
    private long timestamp;

    /**
     * 返回消息
     */
    private String reason;

    /**
     * 用户需要发送的参数
     */
    private Object result;

    /**
     * 错误消息
     */
    private String errmsg;

    /**
     * @return String
     */
    public String getErrmsg() {
        return errmsg;
    }

    /**
     * @param errmsg errmsg
     * @return ApiResponse
     */
    public ApiResponse setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }


    /**
     * 屏蔽无参构造参数
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
     * @param code code
     * @return ApiResponse
     */
    public ApiResponse success(String code) {
        setCode(code);
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
     * @param reason String
     * @return ApiResponse
     */
    public ApiResponse setReason(String reason) {
        this.reason = reason;
        return this;
    }
}
