package com.masspick.peak.resource.controller;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysIndustry;
import com.masspick.peak.resource.service.ISysIndustryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Created by admin on 2018/8/1 0001.
 */
@RestController
@RequestMapping("/v1/resource")
@Validated
public class IndustryController {

    /**
     * iSysIndustryService
     */
    @Autowired
    private ISysIndustryService iSysIndustryService;

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IndustryController.class);

    /**
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @param name     name
     * @param code     code
     * @return ApiResponse
     */
    @GetMapping("/industry")
    public ApiResponse dataGrid(
            @NotNull(message = "页码不能为空")
            @RequestParam(name = "pageNum", required = true) Integer pageNum,
            @NotNull(message = "页数不能为空")
            @RequestParam(name = "pageSize", required = true) Integer pageSize,
            String name, String code) {

        LOGGER.info("---->industry dataGrid params name={} code={} pageNum={} pageSize={} <----",
                name, code, pageNum, pageSize);

        ApiResponse apiResponse = ApiResponse.getInstances();
        //构建返回对象
        PageInfo<SysIndustry> pageInfo = iSysIndustryService.dataGrid(pageNum, pageSize, name, code);
        return apiResponse.success(pageInfo);
    }
}
