package com.masspick.peak.service;

import com.masspick.peak.service.dto.ProductDTO;
import com.masspick.peak.service.dto.SysProductDTO;
import com.masspick.peak.service.dto.SysProductRateDTO;
import com.masspick.peak.service.hystrix.IProductFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/9/11 0011.
 * 产品暴露的微服务
 */
@FeignClient(value = "peak-sys-admin", fallbackFactory = IProductFeignHystrix.class)
public interface IProductFeignApi {

    /**
     * 根据id查询所有的产品
     *
     * @param ids
     * @return List
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/resource/productList", method = RequestMethod.POST)
    List<SysProductDTO> findByIdList(@RequestBody List<String> ids) throws Exception;


    /**
     * 查询所有的产品
     *
     * @return List
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/resource/allProduct", method = RequestMethod.GET)
    List<SysProductDTO> findAll() throws Exception;


    /**
     * 查询单个产品
     *
     * @return List
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/resource/product/{id}", method = RequestMethod.GET)
    SysProductDTO findById(@PathVariable("id") String id) throws Exception;

    /**
     * @param sysProductRateDTO sysProductRateDTO
     * @return sysProductRateDTO
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/resource/product/rate", method = RequestMethod.POST)
    Map<String, Object> getRate(@RequestBody SysProductRateDTO sysProductRateDTO) throws Exception;

    /**
     * 查询单个产品包括费率
     *
     * @return ProductDTO
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/resource/productVo/{id}", method = RequestMethod.GET)
    ProductDTO findId(@PathVariable("id") String id) throws Exception;

    /**
     * 查询产品字段
     *
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/field", method = RequestMethod.GET)
    List<Map> findField() throws Exception;

    /**
     * 查询产品模板
     *
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/fieldTemplate/{templateId}", method = RequestMethod.GET)
    String findFieldTemplate(@PathVariable("templateId") String templateId) throws Exception;

}
