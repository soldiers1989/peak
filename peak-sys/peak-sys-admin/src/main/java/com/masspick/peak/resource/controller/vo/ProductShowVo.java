package com.masspick.peak.resource.controller.vo;


import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.entity.SysProduct;
import com.masspick.peak.resource.entity.SysProductBond;
import com.masspick.peak.resource.entity.SysProductInterest;
import com.masspick.peak.resource.entity.SysProductService;

import javax.validation.Valid;
import java.util.List;

/**
 * 产品添加对象
 */
public class ProductShowVo {

    /**
     * 产品信息
     */
    @Valid
    private SysProduct product;


    /**
     * 利率配置信息
     */
    @Valid
    private List<SysProductInterest> interestConfig;

    /**
     * 服务费配置信息
     */
    @Valid
    private List<SysProductService> serviceConfig;

    /**
     * 保证及配置
     */
    @Valid
    private List<SysProductBond> bondConfig;

    /**
     * @param message message
     * @param product product
     */
    public void getMessage(StringBuffer message, SysProduct product) {
        if (StringUtils.isEmpty(product.getName())) {
            message.append("产品名称不能为空");
            return;
        }

        if (StringUtils.isEmpty(product.getNumber())) {
            message.append("产品编码不能为空");
            return;
        }

        if (product.getMinTerm() == null) {
            message.append("最小贷款期限不能为空");
            return;
        }

        if (product.getMaxTerm() == null) {
            message.append("最大贷款期限不能为空");
            return;
        }

        if (product.getMinAmount() == null) {
            message.append("最小贷款金额不能为空");
            return;
        }

        if (product.getMaxAmount() == null) {
            message.append("最大贷款金额不能为空");
            return;
        }

        if (product.getMinRate() == null) {
            message.append("最小综合费率不能为空");
            return;
        }

        if (product.getMaxRate() == null) {
            message.append("最大综合费率不能为空");
            return;
        }

        if (product.getStatus() == null) {
            message.append("状态不能为空");
            return;
        }

        if (StringUtils.isEmpty(product.getApplyCondition())) {
            message.append("申请条件不能为空");
            return;
        }

        if (StringUtils.isEmpty(product.getProductIntroduction())) {
            message.append("产品介绍不能为空");
            return;
        }

    }

    /**
     * @return SysProduct
     */
    public SysProduct getProduct() {
        return product;
    }

    /**
     * @param product product
     */
    public void setProduct(SysProduct product) {
        this.product = product;
    }

    /**
     * @return List<SysProductInterest>
     */
    public List<SysProductInterest> getInterestConfig() {
        return interestConfig;
    }

    /**
     * @param interestConfig interestConfig
     */
    public void setInterestConfig(List<SysProductInterest> interestConfig) {
        this.interestConfig = interestConfig;
    }

    /**
     * @return List<SysProductService>
     */
    public List<SysProductService> getServiceConfig() {
        return serviceConfig;
    }

    /**
     * @param serviceConfig serviceConfig
     */
    public void setServiceConfig(List<SysProductService> serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    /**
     * Gets bondConfig
     *
     * @return value of bondConfig
     */
    public List<SysProductBond> getBondConfig() {
        return bondConfig;
    }

    /**
     * @param bondConfig bondConfig
     */
    public void setBondConfig(List<SysProductBond> bondConfig) {
        this.bondConfig = bondConfig;
    }

    @Override
    public String toString() {
        return "ProductAddVo{"
                + "product=" + product
                + ", interestConfig=" + interestConfig
                + ", serviceConfig=" + serviceConfig
                + '}';
    }
}
