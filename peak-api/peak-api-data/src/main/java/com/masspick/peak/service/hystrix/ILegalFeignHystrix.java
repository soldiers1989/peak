package com.masspick.peak.service.hystrix;

import com.masspick.peak.model.dto.legal.RiskDTO;
import com.masspick.peak.service.ILegalFeignApi;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/6/20 0020.
 */
@Component
public class ILegalFeignHystrix implements FallbackFactory<ILegalFeignApi> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ILegalFeignHystrix.class);

    @Override
    public ILegalFeignApi create(Throwable throwable) {

        ILegalFeignHystrix.LOGGER.info("fallback reason was: {} ", throwable.getMessage());

        return new ILegalFeignApi() {
            @Override
            public RiskDTO risk(String etpId) throws Exception {
                LOGGER.error("查询失败！");
                throw new Exception("查询失败!", throwable);
            }
        };
    }
}
