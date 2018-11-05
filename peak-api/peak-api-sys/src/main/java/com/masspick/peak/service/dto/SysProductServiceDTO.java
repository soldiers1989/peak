package com.masspick.peak.service.dto;

import com.masspick.peak.common.mvel.Expression;

/**
 * Created by admin on 2018/9/18 0018.
 */
public class SysProductServiceDTO implements Expression {

    /**
     * expression
     */
    private String expression;

    /**
     * rate
     */
    private String rate;

    /**
     * 无参构造
     */
    public SysProductServiceDTO() {
    }

    /**
     *
     * @param expression
     * @param rate
     */
    public SysProductServiceDTO(String expression, String rate) {
        this.expression = expression;
        this.rate = rate;
    }

    /**
     * Gets expression
     *
     * @return value of expression
     */
    @Override
    public String getExpression() {
        return expression;
    }

    /**
     * @param expression expression
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * Gets rate
     *
     * @return value of rate
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
}
