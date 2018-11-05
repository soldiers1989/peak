package com.masspick.peak.resource.service;

import com.masspick.peak.resource.controller.vo.ProductShowVo;
import com.masspick.peak.resource.entity.SysProduct;
import com.masspick.peak.resource.vo.ProductDataGridFindVo;
import com.masspick.peak.resource.vo.ProductDataGridResultVo;

import java.util.List;
import java.util.Map;

/**
 *  产品service接口
 */
public interface IProductService {
    /**
     *
     * @param productDataGridFindVo 分页查询对象
     * @return  List<ProductDataGridResultVo>  分页查询结果对象
     */
    List<ProductDataGridResultVo> findByPage(ProductDataGridFindVo productDataGridFindVo);

    /**
     *
     * @param productShowVo productShowVo 页面对象
     * @return  ProductShowVo
     */
    ProductShowVo addProduct(ProductShowVo productShowVo);

    /**
     *
     * @param sysProduct sysProduct
     * @return SysProduct
     */
    SysProduct modifyProductStatus(SysProduct sysProduct);

    /**
     *
     * @param id id
     * @return ProductShowVo
     */
    ProductShowVo findOneProductDetail(String id);

    /**
     *
     * @param productShowVo productShowVo
     * @return ProductShowVo
     */
    ProductShowVo modifyProduct(ProductShowVo productShowVo);

    /**
     *
     * @param productShowVo productShowVo
     * @return Boolean
     */
    Boolean checkUniqueNum(ProductShowVo productShowVo);

    /**
     * @return List
     */
    List<Map> findField();

    /**
     * @return Map
     */
    String findFieldTemplate(String templateId);
}
