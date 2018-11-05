package com.masspick.peak.service;


import com.masspick.peak.model.dto.etp.EtpBasicDTO;
import com.masspick.peak.service.hystrix.IEtpFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2018/6/20 0020.
 */
@FeignClient(value = "etp-provider", fallbackFactory = IEtpFeignHystrix.class)
public interface IEtpFeignApi {

    /**
     * @param etpName
     * @return EtpBasicDTO
     * @throws Exception Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/etp/{etpName}")
    EtpBasicDTO findBasicById(@PathVariable("etpName") String etpName) throws Exception;

}
