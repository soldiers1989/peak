package com.masspick.peak.guest.service;


import com.masspick.peak.guest.controller.vo.BaseVo;
import com.masspick.peak.guest.model.InfoAuth;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.validation.BindingResult;

/**
 * IInfoAuthService
 */
public interface IInfoAuthService {
    /**
     * 发送邮件
     * @param baseVo baseVo
     * @return ApiResponse
     */
    ApiResponse sendEmail(BaseVo baseVo);

    /**
     *  添加信息采集授权
     * @param infoAuth 信息采集授权
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    ApiResponse addInfoAuth(InfoAuth infoAuth, BindingResult bindingResult);

    /**
     *  通过企业资质认证id查询信息采集授权
     * @param etpCerId 企业资质认证id
     * @return ApiResponse
     */
    ApiResponse findInfoAuthByEtpCerId(String etpCerId);
}
