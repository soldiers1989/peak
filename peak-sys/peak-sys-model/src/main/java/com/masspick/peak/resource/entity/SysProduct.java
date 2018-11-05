package com.masspick.peak.resource.entity;

import com.masspick.peak.common.util.SequenceUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 产品
 */
public class SysProduct {

    /**
     * 主键id
     */
    private String id;

    /**
     * 产品名称
     */
    @NotEmpty(message = "产品名称不能为空")
    private String name;

    /**
     * 产品编号
     */
    @NotEmpty(message = "产品编码不能为空")
    private String number;

    /**
     * 最小贷款期限
     */
    @NotNull(message = "最小贷款期限不能为空")
    private Integer minTerm;

    /**
     * 最大贷款期限
     */
    @NotNull(message = "最大贷款期限不能为空")
    private Integer maxTerm;

    /**
     * 最小贷款金额
     */
    @NotNull(message = "最小贷款金额不能为空")
    private Double minAmount;

    /**
     * 最大贷款金额
     */
    @NotNull(message = "最大贷款金额不能为空")
    private Double maxAmount;

    /**
     * 最小贷款利率
     */
    @NotNull(message = "最小综合费率不能为空")
    private Double minRate;

    /**
     * 最大贷款利率
     */
    @NotNull(message = "最大综合费率不能为空")
    private Double maxRate;

    /**
     * 状态（0-禁用 1-启用）
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 描述
     */
    private String remark;

    /**
     * 申请条件
     */
    @NotEmpty(message = "申请条件不能为空")
    private String applyCondition;

    /**
     * 产品介绍
     */
    @NotEmpty(message = "产品介绍不能为空")
    private String productIntroduction;

    /**
     *  合同范本
     */
    @NotEmpty(message = "合同范本不能为空")
    private String contractModel;

    /**
     * 新增初始化
     */
    public void preInsert() {
        this.id = SequenceUtils.getUUID();
        this.createDate = new Date();
        this.updateDate = this.createDate;
    }


    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets number
     *
     * @return value of number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Gets minTerm
     *
     * @return value of minTerm
     */
    public Integer getMinTerm() {
        return minTerm;
    }

    /**
     * @param minTerm minTerm
     */
    public void setMinTerm(Integer minTerm) {
        this.minTerm = minTerm;
    }

    /**
     * Gets maxTerm
     *
     * @return value of maxTerm
     */
    public Integer getMaxTerm() {
        return maxTerm;
    }

    /**
     * @param maxTerm maxTerm
     */
    public void setMaxTerm(Integer maxTerm) {
        this.maxTerm = maxTerm;
    }

    /**
     * Gets minAmount
     *
     * @return value of minAmount
     */
    public Double getMinAmount() {
        return minAmount;
    }

    /**
     * @param minAmount minAmount
     */
    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * Gets maxAmount
     *
     * @return value of maxAmount
     */
    public Double getMaxAmount() {
        return maxAmount;
    }

    /**
     * @param maxAmount maxAmount
     */
    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * Gets minRate
     *
     * @return value of minRate
     */
    public Double getMinRate() {
        return minRate;
    }

    /**
     * @param minRate minRate
     */
    public void setMinRate(Double minRate) {
        this.minRate = minRate;
    }

    /**
     * Gets maxRate
     *
     * @return value of maxRate
     */
    public Double getMaxRate() {
        return maxRate;
    }

    /**
     * @param maxRate maxRate
     */
    public void setMaxRate(Double maxRate) {
        this.maxRate = maxRate;
    }

    /**
     * Gets status
     *
     * @return value of status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status status
     */
    public void setStatus(Integer status) {
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

    /**
     * Gets remark
     *
     * @return value of remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Gets applyCondition
     *
     * @return value of applyCondition
     */
    public String getApplyCondition() {
        return applyCondition;
    }

    /**
     * @param applyCondition applyCondition
     */
    public void setApplyCondition(String applyCondition) {
        this.applyCondition = applyCondition;
    }

    /**
     * Gets productIntroduction
     *
     * @return value of productIntroduction
     */
    public String getProductIntroduction() {
        return productIntroduction;
    }

    /**
     * @param productIntroduction productIntroduction
     */
    public void setProductIntroduction(String productIntroduction) {
        this.productIntroduction = productIntroduction;
    }

    /**
     * Gets contractModel
     *
     * @return value of contractModel
     */
    public String getContractModel() {
        return contractModel;
    }

    /**
     * @param contractModel contractModel
     */
    public void setContractModel(String contractModel) {
        this.contractModel = contractModel;
    }

    @Override
    public String toString() {
        return "SysProduct{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", number='" + number + '\''
                + ", minTerm=" + minTerm
                + ", maxTerm=" + maxTerm
                + ", minAmount=" + minAmount
                + ", maxAmount=" + maxAmount
                + ", minRate=" + minRate
                + ", maxRate=" + maxRate
                + ", status=" + status
                + ", createDate=" + createDate
                + ", updateDate=" + updateDate
                + ", remark='" + remark + '\''
                + '}';
    }
}
