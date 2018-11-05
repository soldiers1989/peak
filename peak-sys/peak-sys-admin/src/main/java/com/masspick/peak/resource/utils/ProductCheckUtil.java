package com.masspick.peak.resource.utils;

import com.masspick.peak.resource.entity.SysProduct;

/**
 * 产品数据校验工具类
 */
public final class ProductCheckUtil {

    private ProductCheckUtil() {
    }

    /**
     * @param sysProduct sysProduct
     * @return String
     */
    public static String checkProduct(SysProduct sysProduct) {
        String message = "success";
        if (sysProduct.getMaxTerm() < sysProduct.getMinTerm()) {
            message = "最大贷款期限不能小于最小贷款期限";
        }

        if (sysProduct.getMaxAmount() < sysProduct.getMinAmount()) {
            message = "最大贷款金额不能小于最小贷款金额";
        }

        if (sysProduct.getMaxRate() < sysProduct.getMinRate()) {
            message = "最大综合费率不能小于最小综合费率";
        }
        return message;
    }

}
