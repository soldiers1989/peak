package com.masspick.peak.guest.service;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.guest.controller.vo.EtpCerAddVo;
import com.masspick.peak.guest.controller.vo.EtpCerDetailVo;
import com.masspick.peak.guest.controller.vo.LiveDetectVo;
import com.masspick.peak.guest.model.BusLicenseCer;
import com.masspick.peak.guest.model.ControllerCer;
import com.masspick.peak.guest.model.IdMobileCer;
import com.masspick.peak.guest.vo.ApiResponse;
import com.masspick.peak.guest.vo.manage.EtpCerInvitePageVo;
import com.masspick.peak.guest.vo.manage.EtpCerInviteVo;
import org.springframework.validation.BindingResult;

import java.util.List;


/**
 * IEtpCerService
 */
public interface IEtpCerService {

    /**
     * @return ApiResponse
     */
    ApiResponse validateData();

    /**
     *  活体检测
     * @param liveDetectVo 活体检测对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    ApiResponse liveDetect(LiveDetectVo liveDetectVo, BindingResult bindingResult);

    /**
     * 保存活体信息
     * @param liveDetectVo 活体检测信息
     * @return ApiResponse
     */
    String addBodyCer(LiveDetectVo liveDetectVo);


    /**
     *  企业资质认证
     * @param etpCerAddVo 资质认证信息
     * @return ApiResponse
     */
    ApiResponse enterpriseCer(EtpCerAddVo etpCerAddVo, BindingResult bindingResult);

    /**
     *  添加营业执照信息
     * @param busLicenseCer 营业执照信息
     * @return BusLicenseCer
     */
    BusLicenseCer addBusLicense(BusLicenseCer busLicenseCer);

    /**
     *  保存身份证和电话信息
     * @param idMobileCer 身份证电话信息
     * @return IdMobileCer
     */
    IdMobileCer addIdMobileCer(IdMobileCer idMobileCer);

    /**
     * 保存控制人信息
     * @param controllerCer 控制人信息
     * @return ApiResponse
     */
    ControllerCer addControllerCer(ControllerCer controllerCer);


    /**
     *  单条企业资质认证查询
     * @param id id
     * @return  ApiResponse
     */
    ApiResponse findOneEtpCer(String id);

    /**
     * 多条企业资质认证查询
     * @param userId 用户id
     * @param status 状态
     * @return  ApiResponse
     */
    ApiResponse findEtpCerList(String userId, String status);

    /**
     * 查找认证明细
     * @param id 企业资质认证id
     * @return EtpCerDetailVo
     */
    EtpCerDetailVo findEtpCerDetail(String id);

    /**
     * 分页显示巅峰人员拉取的公司
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param number number
     * @return PageInfo
     */
    ApiResponse findEtpByPage(Integer pageNum, Integer pageSize, String number);
}
