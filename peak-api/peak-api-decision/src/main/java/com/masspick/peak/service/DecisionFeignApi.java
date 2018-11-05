package com.masspick.peak.service;

import com.masspick.peak.model.dto.WhiteListEtpDto;
import com.masspick.peak.model.dto.WhiteListEtpFindBo;
import com.masspick.peak.service.hystrix.DecisionFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * DecisionFeignApi
 */
@FeignClient(value = "peak-decision-client", fallback = DecisionFeignHystrix.class)
public interface DecisionFeignApi {

    /**
     * @param whiteListEtpFindBo
     * @return WhiteListEtpDto
     */
    @RequestMapping(value = "/etp", method = RequestMethod.POST)
    WhiteListEtpDto findWhiteList(@RequestBody WhiteListEtpFindBo whiteListEtpFindBo);
}
