package com.masspick.peak.service.hystrix;

import com.masspick.peak.service.IProductFeignApi;
import com.masspick.peak.service.IUserFeignApi;
import com.masspick.peak.service.dto.ProductDTO;
import com.masspick.peak.service.dto.SysProductDTO;
import com.masspick.peak.service.dto.SysProductRateDTO;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/9/11 0011.
 */
@Component
public class IProductFeignHystrix implements FallbackFactory<IProductFeignApi> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IUserFeignApi.class);

    @Override
    public IProductFeignApi create(Throwable throwable) {
        return new IProductFeignApi() {
            @Override
            public List<SysProductDTO> findByIdList(List<String> ids) throws Exception {
                LOGGER.error("根据Id列表查询产品失败！");
                throw new Exception("根据Id列表查询产品失败", throwable);
            }

            @Override
            public List<SysProductDTO> findAll() throws Exception {
                LOGGER.error("查询所有的产品失败！");
                throw new Exception("查询所有的产品失败", throwable);
            }

            @Override
            public SysProductDTO findById(String id) throws Exception {
                LOGGER.error("查询单个产品失败！");
                throw new Exception("查询单个产品失败", throwable);
            }

            @Override
            public Map<String, Object> getRate(SysProductRateDTO sysProductRateDTO) throws Exception {
                LOGGER.error("匹配产品利率失败！");
                throw new Exception("匹配产品利率失败", throwable);
            }

            @Override
            public ProductDTO findId(String id) throws Exception {
                LOGGER.error("查询产品失败！");
                throw new Exception("查询产品失败", throwable);
            }
            @Override
            public List<Map> findField() throws Exception {
                LOGGER.error("查询产品字段失败！");
                throw new Exception("查询产品字段失败", throwable);
            }

            @Override
            public String findFieldTemplate(String templateId) throws Exception {
                LOGGER.error("查询产品模板失败！");
                throw new Exception("查询产品模板失败", throwable);
            }
        };
    }
}
