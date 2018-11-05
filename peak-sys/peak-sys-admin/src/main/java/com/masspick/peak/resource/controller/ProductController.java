package com.masspick.peak.resource.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.anno.Log;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.controller.vo.ProductShowVo;
import com.masspick.peak.resource.entity.SysProduct;
import com.masspick.peak.resource.service.IProductService;
import com.masspick.peak.resource.utils.ProductCheckUtil;
import com.masspick.peak.resource.vo.ProductDataGridFindVo;
import com.masspick.peak.resource.vo.ProductDataGridResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 产品
 */
@RestController
@RequestMapping("/v1/resource")
public class ProductController {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    /**
     * productService
     */
    @Autowired
    private IProductService productService;

    /**
     * 产品分页查询
     *
     * @param productDataGridFindVo 分页查询对象
     * @param bindingResult         bindingResult
     * @return ApiResponse
     */
    @GetMapping("/products")
    ApiResponse findProductByPage(@Valid ProductDataGridFindVo productDataGridFindVo, BindingResult bindingResult) {
        LOGGER.info("come in findProductByPage, request params = " + productDataGridFindVo.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        PageHelper.startPage(productDataGridFindVo.getPageNum(), productDataGridFindVo.getPageSize());
        List<ProductDataGridResultVo> productDataGridResultVoList = productService.findByPage(productDataGridFindVo);
        LOGGER.info("end in findProductByPage, result = " + new PageInfo<>(productDataGridResultVoList).toString());
        apiResponse.success().setResult(new PageInfo<>(productDataGridResultVoList));
        return apiResponse;
    }

    /**
     * 产品添加
     *
     * @param productShowVo productShowVo
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("添加产品")
    @PostMapping("/product")
    ApiResponse addProduct(@Valid @RequestBody ProductShowVo productShowVo, BindingResult bindingResult) {
        LOGGER.info("come in addProduct, request params = " + productShowVo.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            StringBuffer message = new StringBuffer();
            productShowVo.getMessage(message, productShowVo.getProduct());
            if (!StringUtils.isEmpty(message.toString())) {
                return apiResponse.error("400").setReason(message.toString());
            }
        }
        if (!productService.checkUniqueNum(productShowVo)) {
            return apiResponse.error("401").setReason("产品编码已存在，请重新输入");
        }
        String message = ProductCheckUtil.checkProduct(productShowVo.getProduct());
        if (!message.equals("success")) {
            return apiResponse.error("402").setReason(message);
        }
        productShowVo = productService.addProduct(productShowVo);
        apiResponse.success().setResult(productShowVo);
        LOGGER.info("end in addProduct, result = " + productShowVo.toString());
        return apiResponse;
    }

    /**
     * 修改产品状态
     *
     * @param id         id
     * @param sysProduct sysProduct
     * @return ApiResponse
     */
    @Log("更新产品")
    @PatchMapping("/products/{id}")
    ApiResponse modifyProductStatus(@PathVariable("id") String id, @RequestBody SysProduct sysProduct) {
        LOGGER.info("come in modifyProductStatus , request id = " + id);
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (sysProduct == null || sysProduct.getStatus() == null) {
            return apiResponse.error("400").setReason("状态不能为空");
        }
        sysProduct.setId(id);
        sysProduct = productService.modifyProductStatus(sysProduct);
        LOGGER.info("end in modifyProductStatus, result = " + sysProduct.toString());
        apiResponse.success().setResult(sysProduct);
        return apiResponse;
    }

    /**
     * 查看单个产品
     *
     * @param id id
     * @return ApiResponse
     */
    @GetMapping("products/{id}")
    ApiResponse findOneProductDetail(@PathVariable("id") String id) {
        LOGGER.info("come in findOneProductDetail, request id = " + id);
        ApiResponse apiResponse = ApiResponse.getInstances();
        ProductShowVo productShowVo = productService.findOneProductDetail(id);
        apiResponse.success().setResult(productShowVo);
        LOGGER.info("end in findOneProductDetail, productAddVo= " + productShowVo.toString());
        return apiResponse;
    }

    /**
     * 产品修改
     *
     * @param id            id
     * @param productShowVo productShowVo
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("产品修改")
    @PutMapping("products/{id}")
    ApiResponse modifyProduct(@PathVariable("id") String id, @Valid @RequestBody ProductShowVo productShowVo,
                              BindingResult bindingResult) {
        LOGGER.info("come in modifyProduct, request id = " + id + ", productShowVo = " + productShowVo);
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            StringBuffer message = new StringBuffer();
            productShowVo.getMessage(message, productShowVo.getProduct());
            if (!StringUtils.isEmpty(message.toString())) {
                return apiResponse.error("400").setReason(message.toString());
            }
        }
        ProductShowVo existShowVo = productService.findOneProductDetail(id);
        if (existShowVo.getProduct() == null) {
            return apiResponse.error("401").setReason("产品不存在，无法修改");
        }
        if (!productService.checkUniqueNum(productShowVo)) {
            return apiResponse.error("402").setReason("产品编码已存在，请重新输入");
        }
        String message = ProductCheckUtil.checkProduct(productShowVo.getProduct());
        if (!message.equals("success")) {
            return apiResponse.error("403").setReason(message);
        }
        productShowVo.getProduct().setId(id);
        productShowVo = productService.modifyProduct(productShowVo);
        apiResponse.success().setResult(productShowVo);
        LOGGER.info("end in modifyProduct, productAddVo= " + productShowVo.toString());
        return apiResponse;
    }
}
