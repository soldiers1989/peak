package com.masspick.peak.service;

import com.masspick.peak.service.hystrix.IProductFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2018/9/11 0011.
 * 获取随机数
 */
@FeignClient(value = "peak-sys-admin", fallbackFactory = IProductFeignHystrix.class)
public interface IRandomFeignApi {


    /**
     *
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/resource/random", method = RequestMethod.GET)
    String getRandom() throws Exception;

}
