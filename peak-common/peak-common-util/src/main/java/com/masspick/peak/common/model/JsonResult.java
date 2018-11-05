package com.masspick.peak.common.model;

/**
 * Created by Administrator on 2016/11/15.
 */
public final class JsonResult {
    /**
     * 返回码
     */
    private String code;

    /**
     * 接口返回描述。
     * 一般用于接口异常时的，错误描述
     */
    private String reason = "";


    /**
     * 返回结果
     * 根据不同的接口，返回类型不同
     */
    private Object data;


    private JsonResult() {

    }

    /**
     * @param code
     * @param reason
     * @return JsonResult
     */
    public static JsonResult renderError(String code, String reason) {
        JsonResult result = new JsonResult();
        result.setCode(code);
        result.setReason(reason);
        return result;
    }

    /**
     * @param code
     * @param reason
     * @param data
     * @return JsonResult
     */
    public static JsonResult renderError(String code, String reason, Object data) {
        JsonResult result = new JsonResult();
        result.setCode(code);
        result.setReason(reason);
        result.setData(data);
        return result;
    }

    /**
     * @param errorCode
     * @return JsonResult
     */
    public static JsonResult renderError(ErrorCode errorCode) {
        JsonResult result = new JsonResult();
        result.setCode(errorCode.getCode());
        result.setReason(errorCode.getMsg());
        return result;
    }

    /**
     * @param data
     * @return JsonResult
     */
    public static JsonResult renderSuccess(Object data) {
        JsonResult result = new JsonResult();
        result.setCode("200");
        result.setData(data);
        return result;
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
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets reason
     *
     * @return value of reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Gets data
     *
     * @return value of data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }
}
