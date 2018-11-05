package com.masspick.peak.dd.controller;

import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.dd.service.EtpService;
import com.masspick.peak.dd.util.ResultEnum;
import com.masspick.peak.model.dto.etp.EtpBasicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EtpController
 */
@RestController
@RequestMapping("/etp")
public class EtpController {

    /**
     * etpService
     */
    @Autowired
    private EtpService etpService;

    /**
     * @param etpName
     * @return ApiResponse
     */
    @GetMapping("/{etpName}")
    public ApiResponse task(@PathVariable("etpName") String etpName) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        ResultEnum resultEnum;
        EtpBasicDTO dto = etpService.findEtpByEtpName(etpName);
        if (null == dto) {
            resultEnum = ResultEnum.TASK_ABNORMAL;
            return apiResponse.error(resultEnum.getCode(), resultEnum.getReason());
        } else {
            return apiResponse.success(dto);
        }
    }

}
