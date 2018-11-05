package com.masspick.peak.common;

/**
 * 流程枚举类
 */
public enum FlowEnum {


    /**
     * COMPANY_FLOW
     */
    COMPANY_FLOW("企业信用卡", "companyCard"),

    /**
     * TAXCREDIT_FLOW
     */
    TAXCREDIT_FLOW("征信贷", "taxCredit");


    /**
     * type
     */
    private String type;

    /**
     * value
     */
    private String value;


    FlowEnum(String type, String value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Gets type
     *
     * @return value of type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets value
     *
     * @return value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
