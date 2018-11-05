package com.masspick.peak.service;

import com.masspick.peak.model.dto.DdTaskDTO;
import com.masspick.peak.service.hystrix.DdTaskFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by admin on 2018/6/20 0020.
 */
@FeignClient(value = "peak-dd-client", fallbackFactory = DdTaskFeignHystrix.class)
public interface DdTaskFeignApi {

    /**
     * @param ddTaskDTO
     * @return Integer
     * @throws Exception Exception
     */
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    Integer createDueTask(@RequestBody DdTaskDTO ddTaskDTO) throws Exception;

    /**
     * @param processId
     * @return Map<String, Object>
     * @throws Exception Exception
     */
    @RequestMapping(value = "/data/{processId}", method = RequestMethod.GET)
    Map<String, Object> ddData(@PathVariable("processId") String processId) throws Exception;
}
