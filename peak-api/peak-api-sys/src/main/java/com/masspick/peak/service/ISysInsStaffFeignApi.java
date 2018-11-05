package com.masspick.peak.service;

import com.masspick.peak.service.dto.SysInsStaffDTO;
import com.masspick.peak.service.hystrix.IProductFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2018/9/20 0020.
 */
@FeignClient(value = "peak-sys-admin", fallbackFactory = IProductFeignHystrix.class)
public interface ISysInsStaffFeignApi {

    /**
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/staff/{number}", method = RequestMethod.GET)
    SysInsStaffDTO finByNumber(@PathVariable("number") String number) throws Exception;
}
