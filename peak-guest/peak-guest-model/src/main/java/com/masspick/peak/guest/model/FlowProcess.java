package com.masspick.peak.guest.model;

import java.util.Date;

/**
 * FlowProcess
 */
public class FlowProcess {

    /**
     * 流程id
     */
    private String flowId;

    /**
     * 贷款id
     */
    private String loanId;

    /**
     * 用户id
     */
    private String userId;


    /**
     * 公司名称
     */
    private String etpName;

    /**
     * 状态 0:发起 1：进行中 2：终止 3：完成
     */
    private String status;


    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date updateDate;

    @Override
    public String toString() {
        return "FlowProcess{"
                + "flowId='" + flowId + '\''
                + ", loanId='" + loanId + '\''
                + ", userId='" + userId + '\''
                + ", etpName='" + etpName + '\''
                + ", status='" + status + '\''
                + ", createDate=" + createDate
                + ", updateDate=" + updateDate
                + '}';
    }

    /**
     * Gets flowId
     *
     * @return value of flowId
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     * @param flowId flowId
     */
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    /**
     * Gets loanId
     *
     * @return value of loanId
     */
    public String getLoanId() {
        return loanId;
    }

    /**
     * @param loanId loanId
     */
    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    /**
     * Gets userId
     *
     * @return value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets etpName
     *
     * @return value of etpName
     */
    public String getEtpName() {
        return etpName;
    }

    /**
     * @param etpName etpName
     */
    public void setEtpName(String etpName) {
        this.etpName = etpName;
    }

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
     * Gets createDate
     *
     * @return value of createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets updateDate
     *
     * @return value of updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
