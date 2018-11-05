package com.masspick.peak.guest.controller.vo;


/**
 *  流程返回对象
 * @param <T>
 */
public class BqTaskVo<T> {

    private static final long serialVersionUID = 1L;

    /**
     * status
     */
    private String status;

    /**
     * vos
     */
    private T vos;

    /**
     * appointTime
     */
    private String appointTime;

    /**
     * loanAmount
     */
    private String loanAmount;

    /**
     * loanTerm
     */
    private String loanTerm;

    /**
     * Gets status
     *
     * @return value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets vos
     *
     * @return value of vos
     */
    public T getVos() {
        return vos;
    }

    /**
     * @param vos vos
     */
    public void setVos(T vos) {
        this.vos = vos;
    }

    /**
     * Gets appointTime
     *
     * @return value of appointTime
     */
    public String getAppointTime() {
        return appointTime;
    }

    /**
     * @param appointTime appointTime
     */
    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }

    /**
     * Gets loanAmount
     *
     * @return value of loanAmount
     */
    public String getLoanAmount() {
        return loanAmount;
    }

    /**
     * @param loanAmount loanAmount
     */
    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Gets loanTerm
     *
     * @return value of loanTerm
     */
    public String getLoanTerm() {
        return loanTerm;
    }

    /**
     * @param loanTerm loanTerm
     */
    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }
}
