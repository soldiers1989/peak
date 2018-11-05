package com.masspick.peak.resource.vo;


import java.util.Date;

/**
 *  产品分页查询结果对象
 */
public class ProductDataGridResultVo {

    /**
     *  产品id
     */
    private String id;

    /**
     *  产品名称
     */
    private String name;

    /**
     *  产品编号
     */
    private String number;

    /**
     *  期限范围
     */
    private String term;

    /**
     *  产品金额范围
     */
    private String amount;

    /**
     *  产品费率范围
     */
    private String rate;

    /**
     *  状态
     */
    private Integer status;

    /**
     *  更新日期
     */
    private Date updateDate;

    /**
     * @return String
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
     * @return String
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
     * @return String
     */
    public String getTerm() {
        return term;
    }

    /**
     * @param term term
     */
    public void setTerm(String term) {
        this.term = term;
    }
    /**
     * @return String
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
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
     * @return Integer
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

    @Override
    public String toString() {
        return "ProductDataGridResultVo{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", number='" + number + '\''
                + ", term='" + term + '\''
                + ", amount='" + amount + '\''
                + ", rate='" + rate + '\''
                + ", status=" + status
                + ", updateDate=" + updateDate
                + '}';
    }
}
