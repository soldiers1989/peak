package com.masspick.peak.guest.model;

/**
 *  产品
 */
public class Product {
    /**
     *  产品id
     */
    private String productId;

    /**
     *  产品名称
     */
    private String productName;

    /**
     *  状态
     */
    private String status;

    /**
     * Gets productId
     *
     * @return value of productId
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
     * Gets productName
     *
     * @return value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
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
}
