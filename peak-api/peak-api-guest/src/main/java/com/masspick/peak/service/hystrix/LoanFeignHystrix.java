package com.masspick.peak.service.hystrix;

import com.masspick.peak.service.LoanFeignApi;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *  熔断器
 */
@Component
public class LoanFeignHystrix implements FallbackFactory<LoanFeignApi> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoanFeignHystrix.class);

    /**
     *
     * @param throwable throwable
     * @return LoanFeignApi
     */
    @Override
    public LoanFeignApi create(Throwable throwable) {
        LoanFeignHystrix.LOGGER.info("fallback reason was: {} ", throwable.getMessage());

        return new LoanFeignApi() {
            @Override
            public void notifyLoanHandResult(String flowId, Map<String, String> data) throws Exception {
                LOGGER.error("通知贷款处理结果失败!");
                throw new Exception("通知贷款处理结果失败", throwable);
            }
        };
    }
}
