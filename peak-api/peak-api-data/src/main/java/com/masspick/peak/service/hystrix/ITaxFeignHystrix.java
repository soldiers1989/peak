package com.masspick.peak.service.hystrix;

import com.masspick.peak.model.dto.tax.TaxRequestDTO;
import com.masspick.peak.model.dto.tax.TaxResponseDTO;
import com.masspick.peak.service.ITaxFeignApi;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * ITaxFeignHystrix
 */
@Component
public class ITaxFeignHystrix implements FallbackFactory<ITaxFeignApi> {


    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ITaxFeignHystrix.class);

    @Override
    public ITaxFeignApi create(Throwable throwable) {

        ITaxFeignHystrix.LOGGER.info("fallback reason was: {} ", throwable.getMessage());
        return new ITaxFeignApi() {
            @Override
            public TaxResponseDTO getEtpTaxData(TaxRequestDTO requestDTO) throws Exception {
                LOGGER.error("查询错误!");
                throw new Exception("查询错误", throwable);
            }
        };
    }
}
