package com.masspick.peak.service.hystrix;

import com.masspick.peak.service.IRandomFeignApi;
import com.masspick.peak.service.IUserFeignApi;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/9/11 0011.
 */
@Component
public class IRandomFeignHystrix implements FallbackFactory<IRandomFeignApi> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IUserFeignApi.class);

    @Override
    public IRandomFeignApi create(Throwable throwable) {
        return new IRandomFeignApi() {
            @Override
            public String getRandom() throws Exception {
                LOGGER.error("获取随机数失败！");
                throw new Exception("获取随机数失败", throwable);
            }
        };
    }
}
