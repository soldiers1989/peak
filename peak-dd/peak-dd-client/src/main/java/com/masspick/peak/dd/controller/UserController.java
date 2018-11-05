package com.masspick.peak.dd.controller;

import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.common.util.HeaderUtil;
import com.masspick.peak.service.IUserFeignApi;
import com.masspick.peak.service.dto.SysUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2018/5/23 0023.
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    /**
     * iUserFeignApi
     */
    @Resource
    private IUserFeignApi iUserFeignApi;

    /**
     * @param request
     * @return ApiResponse
     * @throws Exception Exception
     */
    @GetMapping
    public ApiResponse user(HttpServletRequest request) throws Exception {
        String account = request.getHeader(HeaderUtil.AUTH_USER);
        SysUserDTO sysUserDTO = iUserFeignApi.findByName(account);
        ApiResponse apiResponse = ApiResponse.getInstances();
        return apiResponse.success().setResult(sysUserDTO);
    }
}
