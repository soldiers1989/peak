package com.masspick.peak.service;

import com.masspick.peak.model.dto.COSDTO;
import com.masspick.peak.service.hystrix.CosFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by admin on 2018/7/10 0010.
 */
@FeignClient(value = "peak-interface", fallback = CosFeignHystrix.class)
public interface CosFeignApi {

    /**
     * @param dto
     * @return Boolean
     */
    @RequestMapping(method = RequestMethod.POST, value = "/api/interface/uploadImage")
    Boolean uploadImageToCos(@RequestBody COSDTO dto);

}
