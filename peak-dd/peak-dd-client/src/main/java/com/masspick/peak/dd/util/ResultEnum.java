package com.masspick.peak.dd.util;

/**
 * Created by admin on 2018/5/23 0023.
 */
public enum ResultEnum {

    /**
     * 用户不存在
     **/
    USER_NOT_EXIST("ERR-401", "用户不存在"),

    /**
     * 密码错误
     **/
    PASSWORD_IS_WRONG("ERR-402", "密码错误"),

    /**
     * 账号被禁用
     **/
    USER_IS_DISABLED("ERR-415", "账号被禁用"),


    /**
     * 未授权
     */
    UN_AUTH_TOKEN("ERR-403", "未授权"),

    /**
     * token刷新失败
     **/
    REFRESH_TOKEN_FAILED("ERR-410", "token刷新失败"),

    /**
     * token刷新失败
     **/
    REFRESH_TOKEN_SUCCEED("200", "token刷新失败"),

    /**
     * 登陆成功
     **/
    LOGIN_IN_SUCCEED("200", "登陆成功"),

    /**
     * 未找到该任务
     */
    UNKNOWN_TASK("ERR-404", "任务不存在"),

    /**
     * 未找到该任务
     */
    TASK_END("ERR-405", "任务已经终止"),

    /**
     * 未找到该任务
     */
    TASK_ABNORMAL("ERR-405", "任务异常"),

    /**
     * 未找到该任务
     */
    TASK_FINISH("ERR-405", "任务已完成"),

    /**
     * 模板不存在
     */
    UNKNOWN_TEMPLATE("ERR-404", "模板不存在"),

    /**
     * 系统内部错误
     */
    SYSTEM_ERROR("ERR-500", "系统内部错误"),

    /**
     * 未找到该请求
     */
    NOT_ERROR("ERR-404", "未找到该请求");

    /**
     * code
     */
    private String code;

    /**
     * reason
     */
    private String reason;


    ResultEnum() {

    }

    ResultEnum(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    /**
     * @param code
     * @return String
     */
    public static String getName(String code) {
        for (ResultEnum e : ResultEnum.values()) {
            if (e.getCode() == code) {
                return e.getReason();
            }
        }
        return null;
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
}
