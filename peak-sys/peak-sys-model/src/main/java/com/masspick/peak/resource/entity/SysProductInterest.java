package com.masspick.peak.resource.entity;


import com.masspick.peak.common.util.SequenceUtils;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 产品利率配置
 */
public class SysProductInterest {

    /**
     * 主键id
     */
    private String id;

    /**
     * 产品id
     */
    private String productId;

    /**
     * el表达式
     */
    private String spel;

    /**
     * 费率or费用
     */
    @NotEmpty(message = "费率不能为空")
    private String rate;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     *  序列
     */
    private Integer seq;

    /**
     * 新增初始化
     */
    public void preInsert() {
        this.id = SequenceUtils.getUUID();
        this.createDate = new Date();
        this.updateDate = this.createDate;
    }

    /**
     * @return String
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
     * @return String
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return String
     */
    public String getSpel() {
        return spel;
    }

    /**
     * @param spel spel
     */
    public void setSpel(String spel) {
        this.spel = spel;
    }

    /**
     * @return String
     */
    public String getRate() {
        return rate;
    }

    /**
     * @param rate rate
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * @return Date
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
     * @return Date
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
     * Gets seq
     *
     * @return value of seq
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * @param seq seq
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "SysProductInterest{"
                + "id='" + id + '\''
                + ", productId='" + productId + '\''
                + ", spel='" + spel + '\''
                + ", rate='" + rate + '\''
                + ", createDate=" + createDate
                + ", updateDate=" + updateDate
                + ", seq=" + seq
                + '}';
    }
}
