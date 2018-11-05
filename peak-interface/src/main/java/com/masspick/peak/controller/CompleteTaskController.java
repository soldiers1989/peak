package com.masspick.peak.controller;

import com.masspick.peak.model.dto.ApiResponse;
import com.masspick.peak.service.PushProjectApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * PeakFlowController
 */
@RestController
@RequestMapping("v1/interface")
public class CompleteTaskController {

    /**
     * PushProjectApi
     */
    @Autowired
    private PushProjectApi pushProjectApi;


    /**
     * test
     * @return String
     */
    @GetMapping("/test")
    public String test(){
        return "hello world";
    }


    /**
     * 开启流程
     *
     * @return Result
     * @throws Exception Exception
     */
    @PostMapping("/task/complete")
    public ApiResponse completeTask(@RequestBody Map<String, String> map) throws Exception {
        return pushProjectApi.completeTask(map);
    }
}
