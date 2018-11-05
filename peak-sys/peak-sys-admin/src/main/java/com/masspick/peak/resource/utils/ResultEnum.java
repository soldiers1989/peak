package com.masspick.peak.resource.utils;

/**
 * Created by admin on 2018/7/31 0031.
 */
public enum ResultEnum {

    /**
     * 参数已存在
     **/
    PARAM_EXIST("ERR-403", "参数已存在!!!"),

    /**
     * 根据id查询未找到相应的值
     */
    ID_IS_NOT_EXIST("ERR-404", "根据id查询未找到数据"),

    /**
     * 参数问题
     */
    PARAMS_ERROR("ERR-400", "参数错误");

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
     * @param code code
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
     * @param code code
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
     * @param reason reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

}
