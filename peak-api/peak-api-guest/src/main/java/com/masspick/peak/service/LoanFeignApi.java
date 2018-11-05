package com.masspick.peak.service;

import com.masspick.peak.service.hystrix.LoanFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


/**
 *  贷款订单更新
 */
@FeignClient(value = "peak-guest-client", fallbackFactory = LoanFeignHystrix.class)
public interface LoanFeignApi {
    /**
     *  通知贷款处理结果
     * @param flowId 流程id
     * @param data 数据
     * @throws Exception  Exception
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/api/guest/process/{flowId}")
    void notifyLoanHandResult(@PathVariable("flowId") String flowId, @RequestBody Map<String, String> data) throws Exception;
}
