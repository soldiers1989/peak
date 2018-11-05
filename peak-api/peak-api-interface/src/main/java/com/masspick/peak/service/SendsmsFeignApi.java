package com.masspick.peak.service;


import com.masspick.peak.model.dto.ApiResponse;
import com.masspick.peak.model.dto.BaseDto;
import com.masspick.peak.service.hystrix.SendsmsFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

/**
 * SendsmsFeignApi
 */
@FeignClient(value = "peak-interface", fallbackFactory = SendsmsFeignHystrix.class)
public interface SendsmsFeignApi {


    /**
     * @param dto
     * @return ApiResponse
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.POST}, value = "/api/interface/sendMessage")
    ApiResponse sendSMS(BaseDto dto) throws Exception;

    /**
     * @param mobile 手机号码
     * @param tempId 腾讯云秘钥
     * @param params 模板参数
     * @return ApiResponse
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.POST}, value = "/api/interface/sendMessageWithParams")
    ApiResponse sendSMS(@RequestParam("mobile") String mobile, @RequestBody ArrayList<String> params, @RequestParam("tempId") Integer tempId)
            throws Exception;


    /**
     * @param map
     * @return ApiResponse
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.POST}, value = "/api/interface/dd/send")
    ApiResponse sendSMSToDd(@RequestBody Map<String, Object> map) throws Exception;
}
