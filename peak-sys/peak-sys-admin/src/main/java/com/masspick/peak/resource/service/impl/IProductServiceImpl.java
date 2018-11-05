package com.masspick.peak.resource.service.impl;

import com.masspick.peak.resource.controller.vo.ProductShowVo;
import com.masspick.peak.resource.entity.SysProduct;
import com.masspick.peak.resource.entity.SysProductBond;
import com.masspick.peak.resource.entity.SysProductInterest;
import com.masspick.peak.resource.entity.SysProductService;
import com.masspick.peak.resource.mapper.*;
import com.masspick.peak.resource.service.IProductService;
import com.masspick.peak.resource.vo.ProductDataGridFindVo;
import com.masspick.peak.resource.vo.ProductDataGridResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  产品sercie实现类
 */
@Service
public class IProductServiceImpl implements IProductService {
    /**
     *  sysProductMapper
     */
    @Autowired
    private SysProductMapper sysProductMapper;
    /**
     *  sysProductInterestMapper
     */
    @Autowired
    private SysProductInterestMapper sysProductInterestMapper;
    /**
     *  sysProductServiceMapper
     */
    @Autowired
    private SysProductServiceMapper sysProductServiceMapper;
    /**
     *  sysProductBondMapper
     */
    @Autowired
    private SysProductBondMapper sysProductBondMapper;
    /**
     *  sysProductMapper
     */
    @Autowired
    private SysFieldMapper sysFieldMapper;

    /**
     *
     * @param productDataGridFindVo 分页查询对象
     * @return List<ProductDataGridResultVo>
     */
    @Override
    public List<ProductDataGridResultVo> findByPage(ProductDataGridFindVo productDataGridFindVo) {
        return sysProductMapper.findByPage(productDataGridFindVo);
    }

    /**
     *
     * @param productShowVo productShowVo 页面对象
     * @return ProductShowVo
     */
    @Override
    public ProductShowVo addProduct(ProductShowVo productShowVo) {
        //添加产品
        SysProduct  sysProduct = productShowVo.getProduct();
        sysProduct.preInsert();
        sysProductMapper.insert(sysProduct);
        productShowVo.setProduct(sysProduct);

        //添加贷款利率配置
        List<SysProductInterest> interestList = productShowVo.getInterestConfig();
        Integer interestSeq = 1;
        for (SysProductInterest sysProductInterest : interestList) {
            sysProductInterest.preInsert();
            sysProductInterest.setSeq(interestSeq++);
            sysProductInterest.setProductId(sysProduct.getId());
        }
        sysProductInterestMapper.insertList(interestList);
        productShowVo.setInterestConfig(interestList);

        //添加服务费配置信息
        List<SysProductService> sysProductServiceList = productShowVo.getServiceConfig();
        Integer serviceSeq = 1;
        for (SysProductService sysProductService : sysProductServiceList) {
            sysProductService.preInsert();
            sysProductService.setSeq(serviceSeq++);
            sysProductService.setProductId(sysProduct.getId());
        }
        sysProductServiceMapper.insertList(sysProductServiceList);
        productShowVo.setServiceConfig(sysProductServiceList);

        //添加保证金信息
        List<SysProductBond> bondList = productShowVo.getBondConfig();
        Integer bondSeq = 1;
        for (SysProductBond sysProductBond : bondList) {
            sysProductBond.preInsert();
            sysProductBond.setSeq(bondSeq++);
            sysProductBond.setProductId(sysProduct.getId());
        }
        sysProductBondMapper.insertList(bondList);
        productShowVo.setBondConfig(bondList);
        return productShowVo;
    }

    /**
     *
     * @param sysProduct sysProduct
     * @return SysProduct
     */
    @Override
    public SysProduct modifyProductStatus(SysProduct sysProduct) {
        sysProduct.setUpdateDate(new Date());
        sysProductMapper.update(sysProduct);
        return sysProductMapper.findSingleById(sysProduct.getId());
    }

    /**
     *
     * @param id id
     * @return
     */
    @Override
    public ProductShowVo findOneProductDetail(String id) {
        ProductShowVo productShowVo = new ProductShowVo();
        SysProduct sysProduct = sysProductMapper.findSingleById(id);
        List<SysProductInterest> sysProductInterests = new ArrayList<>();
        List<SysProductService> sysProductServices = new ArrayList<>();
        List<SysProductBond> sysProductBonds = new ArrayList<>();
        productShowVo.setProduct(sysProduct);
        if (sysProduct != null) {
            sysProductInterests = sysProductInterestMapper.findByProductId(sysProduct.getId());
            sysProductServices = sysProductServiceMapper.findByProductId(sysProduct.getId());
            sysProductBonds = sysProductBondMapper.findByProductId(sysProduct.getId());
            productShowVo.setInterestConfig(sysProductInterests);
            productShowVo.setServiceConfig(sysProductServices);
            productShowVo.setBondConfig(sysProductBonds);
        }
        return productShowVo;
    }

    /**
     *
     * @param productShowVo productShowVo
     * @return ProductShowVo
     */
    @Override
    public ProductShowVo modifyProduct(ProductShowVo productShowVo) {
        SysProduct sysProduct = productShowVo.getProduct();
        sysProduct.setUpdateDate(new Date());
        sysProductMapper.update(sysProduct);
        productShowVo.setProduct(sysProduct);

        //修改贷款利率配置信息
        sysProductInterestMapper.deleteByProductId(sysProduct.getId());
        List<SysProductInterest> interestList = productShowVo.getInterestConfig();
        Integer interestSeq = 1;
        for (SysProductInterest sysProductInterest : interestList) {
            sysProductInterest.preInsert();
            sysProductInterest.setSeq(interestSeq++);
            sysProductInterest.setProductId(sysProduct.getId());
        }
        sysProductInterestMapper.insertList(interestList);
        productShowVo.setInterestConfig(interestList);

        //修改服务费配置信息
        sysProductServiceMapper.deleteByProductId(sysProduct.getId());
        List<SysProductService> sysProductServiceList = productShowVo.getServiceConfig();
        Integer serviceSeq = 1;
        for (SysProductService sysProductService : sysProductServiceList) {
            sysProductService.preInsert();
            sysProductService.setSeq(serviceSeq++);
            sysProductService.setProductId(sysProduct.getId());
        }
        sysProductServiceMapper.insertList(sysProductServiceList);
        productShowVo.setServiceConfig(sysProductServiceList);

        //修改保证金信息
        sysProductBondMapper.deleteByProductId(sysProduct.getId());
        Integer bondSeq = 1;
        List<SysProductBond> bondList = productShowVo.getBondConfig();
        for (SysProductBond sysProductBond : bondList) {
            sysProductBond.preInsert();
            sysProductBond.setSeq(bondSeq++);
            sysProductBond.setProductId(sysProduct.getId());
        }
        sysProductBondMapper.insertList(bondList);
        productShowVo.setBondConfig(bondList);
        return productShowVo;
    }

    /**
     *
     * @param productShowVo productShowVo
     * @return Boolean
     */
    @Override
    public Boolean checkUniqueNum(ProductShowVo productShowVo) {
        SysProduct sysProduct = sysProductMapper.findSingleByNum(productShowVo.getProduct().getNumber());
        if (sysProduct != null && productShowVo.getProduct().getId() == null) {
            return false;
        }
        if (sysProduct != null && !sysProduct.getId().equals(productShowVo.getProduct().getId())) {
            return false;
        }
        return true;
    }

    @Override
    public List<Map> findField() {
        return sysFieldMapper.findAll();
    }

    @Override
    public String findFieldTemplate(String templateId) {
        return sysFieldMapper.findFieldTemplate(templateId);
    }
}
