package com.masspick.peak.resource.rpc;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.resource.controller.vo.ProductShowVo;
import com.masspick.peak.resource.entity.SysProduct;
import com.masspick.peak.resource.entity.SysProductInterest;
import com.masspick.peak.resource.entity.SysProductService;
import com.masspick.peak.resource.mapper.SysProductMapper;
import com.masspick.peak.resource.service.IProductService;
import com.masspick.peak.service.IProductFeignApi;
import com.masspick.peak.service.dto.ProductDTO;
import com.masspick.peak.service.dto.SysProductDTO;
import com.masspick.peak.service.dto.SysProductInterestDTO;
import com.masspick.peak.service.dto.SysProductRateDTO;
import com.masspick.peak.service.dto.SysProductServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/9/11 0011.
 */
@RestController
public class IProductFeignRpc implements IProductFeignApi {

    /**
     * sysProductMapper
     */
    @Resource
    private SysProductMapper sysProductMapper;

    /**
     * iProductService
     */
    @Autowired
    private IProductService iProductService;

    @Override
    public List<SysProductDTO> findByIdList(@RequestBody List<String> ids) throws Exception {
        List<SysProduct> sysProducts = sysProductMapper.findByIds(ids);
        List<SysProductDTO> sysProductDTOS = new ArrayList<>();
        for (SysProduct sysProduct : sysProducts) {
            sysProductDTOS.add(JacksonUtils.copyProperties(sysProduct, SysProductDTO.class));
        }
        return sysProductDTOS;
    }

    @Override
    public List<SysProductDTO> findAll() throws Exception {
        List<SysProduct> sysProducts = sysProductMapper.find();
        List<SysProductDTO> sysProductDTOS = new ArrayList<>();
        for (SysProduct sysProduct : sysProducts) {
            sysProductDTOS.add(JacksonUtils.copyProperties(sysProduct, SysProductDTO.class));
        }
        return sysProductDTOS;
    }

    @Override
    public SysProductDTO findById(@PathVariable("id") String id) throws Exception {
        return JacksonUtils.copyProperties(sysProductMapper.findSingleById(id), SysProductDTO.class);
    }

    @Override
    public Map<String, Object> getRate(@RequestBody SysProductRateDTO sysProductRateDTO) throws Exception {
        ProductShowVo productShowVo = iProductService.findOneProductDetail(sysProductRateDTO.getId());
        ExpressionParser parser = new SpelExpressionParser();

        Map<String, Object> map = new HashMap<>();
        //利率配置信息
        List<SysProductInterest> sysProductInterests = productShowVo.getInterestConfig();
        for (SysProductInterest sysProductInterest : sysProductInterests) {
            String spel = sysProductInterest.getSpel().replace("Month", Integer.toString(sysProductRateDTO.getMonth()))
                    .replace("Money", Double.toString(sysProductRateDTO.getMoney()));
            Expression exp = parser.parseExpression(spel);
            if (exp.getValue(Boolean.class)) {
                map.put("interestRate", sysProductInterest.getRate());
                break;
            }
        }

        //利率配置信息
        List<SysProductService> sysProductServices = productShowVo.getServiceConfig();
        for (SysProductService sysProductService : sysProductServices) {
            String spel = sysProductService.getSpel().replace("Month", Integer.toString(sysProductRateDTO.getMonth()))
                    .replace("Money", Double.toString(sysProductRateDTO.getMoney()));
            Expression exp = parser.parseExpression(spel);
            if (exp.getValue(Boolean.class)) {
                map.put("serviceRate", sysProductService.getRate());
                break;
            }
        }
        return map;
    }

    @Override
    public ProductDTO findId(@PathVariable("id") String id) throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductInterestDTOS(new ArrayList<>());
        productDTO.setProductServiceDTOS(new ArrayList<>());
        ProductShowVo productShowVo = iProductService.findOneProductDetail(id);
        SysProductDTO sysProductDTO = JacksonUtils.copyProperties(productShowVo.getProduct(), SysProductDTO.class);
        productDTO.setSysProductDTO(sysProductDTO);
        for (SysProductInterest interest : productShowVo.getInterestConfig()) {
            productDTO.getProductInterestDTOS().add(new SysProductInterestDTO(interest.getSpel(), interest.getRate()));
        }

        for (SysProductService service : productShowVo.getServiceConfig()) {
            productDTO.getProductServiceDTOS().add(new SysProductServiceDTO(service.getSpel(), service.getRate()));
        }
        return productDTO;
    }

    @Override
    public List<Map> findField() throws Exception {
        return iProductService.findField();
    }

    @Override
    public String findFieldTemplate(@PathVariable("templateId") String templateId) throws Exception {
        return iProductService.findFieldTemplate(templateId);
    }


}
