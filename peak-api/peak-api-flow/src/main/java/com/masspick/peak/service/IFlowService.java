package com.masspick.peak.service;

import com.masspick.peak.model.Property;
import com.masspick.peak.service.hystrix.IFlowServiceFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * IFlowService
 */
@FeignClient(value = "flow-provider", fallbackFactory = IFlowServiceFeignHystrix.class)
public interface IFlowService {

    /**
     * @param map
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/api/flow/api/startProcess")
    String startProcess(@RequestBody Map<String, String> map) throws Exception;

    /**
     * @param taskId
     * @param map
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/api/flow/api/{taskId}/task")
    String completeTask(@PathVariable("taskId") String taskId, @RequestBody Map<String, String> map) throws Exception;

    /**
     * @param processInstanceId
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/flow/api/{processInstanceId}/step")
    Map<String, String> taskbyProInsId(@PathVariable("processInstanceId") String processInstanceId) throws Exception;

    /**
     * @param processInstanceId
     * @param property
     * @return Map
     * @throws Exception Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/api/flow/api/{processInstanceId}/map")
    Map<String, String> findFlowMapByTaskId(@PathVariable("processInstanceId") String processInstanceId,
                                            @RequestBody Property property) throws Exception;

    /**
     * @param no
     * @param actId
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/api/flow/api/{no}/{actId}")
    String findTaskIdByParam(@PathVariable("no") String no, @PathVariable("actId") String actId) throws Exception;

    /**
     * 通过key获取表单
     * @param key 表单key
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/flow/api/form/{key}")
    String findFormByKey(@PathVariable("key") String key) throws Exception;
}
