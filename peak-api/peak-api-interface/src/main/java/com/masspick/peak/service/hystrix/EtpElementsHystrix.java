package com.masspick.peak.service.hystrix;

import com.masspick.peak.service.EtpElementsFeignApi;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *  EtpElementsHystrix
 */
@Component
public class EtpElementsHystrix implements FallbackFactory<EtpElementsFeignApi> {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EtpElementsHystrix.class);

    /**
     * @param throwable 异常
     * @return EtpElementsFeignApi
     */
    @Override
    public EtpElementsFeignApi create(Throwable throwable) {
        return new EtpElementsFeignApi() {
            @Override
            public Map etpElementsCheck(String regNo, String companyName, String frname) throws Exception {
                LOGGER.error("企业三要素校验失败！");
                throw new Exception("企业三要素校验失败!", throwable);
            }
        };
    }
}
