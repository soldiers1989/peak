package com.masspick.peak.service;

import com.masspick.peak.service.hystrix.SendsmsFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 *  企业三要素校验
 */
@FeignClient(value = "peak-interface", fallbackFactory = SendsmsFeignHystrix.class)
public interface EtpElementsFeignApi {
    /**
     *  企业三要素校验
     * @param regNo 统一信用代码
     * @param companyName 公司名称
     * @param frname 法人姓名
     * @return Map
     * @throws Exception 异常
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/api/interface/etpElementsCheck")
    Map etpElementsCheck(@RequestParam("regNo") String regNo,
                         @RequestParam("companyName") String companyName, @RequestParam("frname") String frname) throws Exception;
}
