package com.masspick.peak.dd.controller.vo;

import java.io.Serializable;

/**
 * @description：操作结果集
 */
public class Result implements Serializable {

    /**
     * SUCCESS.
     */
    public static final int SUCCESS = 1;

    /**
     * FAILURE.
     */
    public static final int FAILURE = -1;

    /**
     * 日志.
     */
    private static final long serialVersionUID = 5576237395711742681L;

    /**
     * boolean success.
     */
    private boolean success = false;

    /**
     * String msg.
     */
    private String msg = "";

    /**
     * Object obj.
     */
    private Object obj = null;

    /**
     * isSuccess 方法的简述.
     *
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * setSuccess 方法的简述.
     *
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * getMsg 方法的简述.
     *
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * setMsg 方法的简述.
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * getObj 方法的简述.
     *
     * @return obj
     */
    public Object getObj() {
        return obj;
    }

    /**
     * setObj 方法的简述.
     *
     * @param obj
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }

}
