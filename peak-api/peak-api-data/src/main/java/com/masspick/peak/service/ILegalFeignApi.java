package com.masspick.peak.service;


import com.masspick.peak.model.dto.legal.RiskDTO;
import com.masspick.peak.service.hystrix.ILegalFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by admin on 2018/6/20 0020.
 */
@FeignClient(value = "legal-provider", fallbackFactory = ILegalFeignHystrix.class)
public interface ILegalFeignApi {


    /**
     * @param etpId
     * @return RiskDTO
     * @throws Exception Exception
     */
    @GetMapping(value = "/{etpId}/riskInformation")
    RiskDTO risk(@PathVariable("etpId") String etpId) throws Exception;

}
