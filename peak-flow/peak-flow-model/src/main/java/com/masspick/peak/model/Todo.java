package com.masspick.peak.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Todo
 */
public class Todo implements Serializable {

    /**
     * processInsId
     */
    private String processInsId;

    /**
     * taskId
     */
    private String taskId;

    /**
     * actInsId
     */
    private String actInsId;

    /**
     * actName
     */
    private String actName;

    /**
     * entName
     */
    private String entName;

    /**
     * amount
     */
    private BigDecimal amount;

    /**
     * productId
     */
    private String productId;

    /**
     * productName
     */
    private String productName;

    /**
     * progress
     */
    private String progress;

    /**
     * creatTime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date creatTime;

    /**
     * endTime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * operatorId
     */
    private String operatorId;

    /**
     * operatorName
     */
    private String operatorName;

    /**
     * assignee
     */
    private String assignee;

    /**
     * no
     */
    private String no;

    /**
     * scope
     */
    private String scope;

    /**
     *  projectNumber
     */
    private String projectNumber;

    /**
     * Gets projectNumber
     *
     * @return value of projectNumber
     */
    public String getProjectNumber() {
        return projectNumber;
    }

    /**
     * @param projectNumber projectNumber
     */
    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    /**
     * Gets processInsId
     *
     * @return value of processInsId
     */
    public String getProcessInsId() {
        return processInsId;
    }

    /**
     * @param processInsId
     */
    public void setProcessInsId(String processInsId) {
        this.processInsId = processInsId;
    }

    /**
     * Gets taskId
     *
     * @return value of taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * @param taskId
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * Gets actInsId
     *
     * @return value of actInsId
     */
    public String getActInsId() {
        return actInsId;
    }

    /**
     * @param actInsId
     */
    public void setActInsId(String actInsId) {
        this.actInsId = actInsId;
    }

    /**
     * Gets actName
     *
     * @return value of actName
     */
    public String getActName() {
        return actName;
    }

    /**
     * @param actName
     */
    public void setActName(String actName) {
        this.actName = actName;
    }

    /**
     * Gets entName
     *
     * @return value of entName
     */
    public String getEntName() {
        return entName;
    }

    /**
     * @param entName
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * Gets amount
     *
     * @return value of amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets productId
     *
     * @return value of productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Gets productName
     *
     * @return value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets progress
     *
     * @return value of progress
     */
    public String getProgress() {
        return progress;
    }

    /**
     * @param progress
     */
    public void setProgress(String progress) {
        this.progress = progress;
    }

    /**
     * Gets creatTime
     *
     * @return value of creatTime
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * @param creatTime
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * Gets endTime
     *
     * @return value of endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets operatorId
     *
     * @return value of operatorId
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * @param operatorId
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * Gets operatorName
     *
     * @return value of operatorName
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * @param operatorName
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * Gets assignee
     *
     * @return value of assignee
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * @param assignee
     */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    /**
     * Gets no
     *
     * @return value of no
     */
    public String getNo() {
        return no;
    }

    /**
     * @param no
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * Gets scope
     *
     * @return value of scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }
}
