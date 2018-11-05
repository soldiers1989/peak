package com.masspick.peak.service;


import com.masspick.peak.model.dto.tax.TaxRequestDTO;
import com.masspick.peak.model.dto.tax.TaxResponseDTO;
import com.masspick.peak.service.hystrix.ITaxFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * ITaxFeignApi
 */
@FeignClient(value = "peak-data-tax", fallbackFactory = ITaxFeignHystrix.class)
public interface ITaxFeignApi {

    /**
     * @param requestDTO
     * @return TaxResponseDTO
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.POST}, value = "/api/data/getTax")
    TaxResponseDTO getEtpTaxData(@RequestBody TaxRequestDTO requestDTO) throws Exception;
}
