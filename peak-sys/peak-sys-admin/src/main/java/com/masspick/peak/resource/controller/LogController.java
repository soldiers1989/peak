package com.masspick.peak.resource.controller;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysLog;
import com.masspick.peak.resource.service.ISysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/8/10 0010.
 */
@RestController
@RequestMapping("/v1/resource")
public class LogController {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    /**
     * iSysLogService
     */
    @Autowired
    private ISysLogService iSysLogService;

    /**
     * dataGrid
     *
     * @param pageNum   pageNum
     * @param pageSize  pageSize
     * @param startDate startDate
     * @param endDate   endDate
     * @param title     title
     * @return ApiResponse
     */
    @GetMapping("/logs")
    public ApiResponse dataGrid(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10")
            Integer pageSize, String startDate, String endDate, String title) {
        LOGGER.info("----> log dataGrid params pageNum={}, pageSize={}<----", pageNum, pageSize);
        ApiResponse apiResponse = ApiResponse.getInstances();
        String message = null;
        PageInfo<SysLog> pageInfo = iSysLogService.dataGrid(pageNum, pageSize, startDate, endDate, message, title);
        if (StringUtils.isEmpty(message)) {
            return apiResponse.success().setResult(pageInfo);
        } else {
            return apiResponse.setCode("ERR-403").setReason(message);
        }
    }
}
