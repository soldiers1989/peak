package com.masspick.peak.service;

import com.masspick.peak.model.dto.ApiResponse;
import com.masspick.peak.model.dto.BorrowProjectBean;
import com.masspick.peak.service.hystrix.PushProjectHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


/**
 * PushProjectApi
 */
@FeignClient(value = "peak-interface", fallbackFactory = PushProjectHystrix.class)
public interface PushProjectApi {


    /**
     * @param borrowProjectBean
     * @return ApiResponse
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.POST}, value = "/api/interface/pushProject")
    ApiResponse pushProject(@RequestBody BorrowProjectBean borrowProjectBean) throws Exception;

    /**
     * @param borrowProjectId
     * @param borrowId
     * @return ApiResponse
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.POST}, value = "/api/interface/borrowRepayDetail")
    ApiResponse borrowRepayDetail(@RequestParam("borrowProjectId") String borrowProjectId,
                                  @RequestParam("borrowId") String borrowId) throws Exception;

    /**
     * @param map
     * @return ApiResponse
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.POST}, value = "/api/interface/task/complete")
    ApiResponse completeTask(@RequestBody Map<String, String> map) throws Exception;

    /**
     * @param flowId
     * @return ApiResponse
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/api/interface/{flowId}/borrowRepayDetail")
    ApiResponse borrowRepayDetailByflowId(@PathVariable("flowId") String flowId) throws Exception;
}
