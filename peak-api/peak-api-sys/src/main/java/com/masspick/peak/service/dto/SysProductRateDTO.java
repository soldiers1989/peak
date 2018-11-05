package com.masspick.peak.service.dto;

/**
 * Created by admin on 2018/9/17 0017.
 */
public class SysProductRateDTO {

    /**
     * id
     */
    private String id;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 金额
     */
    private Double money;

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
     * Gets month
     *
     * @return value of month
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * @param month month
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * Gets money
     *
     * @return value of money
     */
    public Double getMoney() {
        return money;
    }

    /**
     * @param money money
     */
    public void setMoney(Double money) {
        this.money = money;
    }
}
