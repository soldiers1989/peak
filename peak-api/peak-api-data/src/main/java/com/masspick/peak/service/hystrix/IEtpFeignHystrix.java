package com.masspick.peak.service.hystrix;

import com.masspick.peak.model.dto.etp.EtpBasicDTO;
import com.masspick.peak.service.IEtpFeignApi;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/6/20 0020.
 */
@Component
public class IEtpFeignHystrix implements FallbackFactory<IEtpFeignApi> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IEtpFeignHystrix.class);


    @Override
    public IEtpFeignApi create(Throwable throwable) {

        IEtpFeignHystrix.LOGGER.info("fallback reason was: {} ", throwable.getMessage());

        return new IEtpFeignApi() {

            @Override
            public EtpBasicDTO findBasicById(String etpName) throws Exception {
                LOGGER.error("1:", throwable);
                LOGGER.error("2:", throwable.getCause());
                LOGGER.error("3:", throwable.getMessage());
                LOGGER.error("4:", throwable.getCause().getMessage());
                throw new Exception("查询错误!", throwable);
            }
        };
    }
}
