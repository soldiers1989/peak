package com.masspick.peak.guest.service;


import com.masspick.peak.guest.bo.EtpCerBo;
import com.masspick.peak.guest.bo.InfoAuthBo;
import com.masspick.peak.guest.bo.LoanApplyBo;
import com.masspick.peak.guest.bo.NameCardInfoBo;
import com.masspick.peak.guest.bo.UserWeiXinFindBo;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.validation.BindingResult;


/**
 * IManageService
 */
public interface IManageService {

    /**
     *  分页查询用户
     * @param findVo 查询对象
     * @param bindingResult 校验结果
     * @return  ApiResponse
     */
    ApiResponse findUserPage(UserWeiXinFindBo findVo, BindingResult bindingResult);

    /**
     *  获取推广渠道列表
     * @return ApiResponse
     */
    ApiResponse findInsList();

    /**
     * 分页查询预授信
     * @param nameCardInfoBo 预授信查询对象
     * @return ApiResponse
     */
    ApiResponse findPrePage(NameCardInfoBo nameCardInfoBo);

    /**
     * 查询预授信明细
     * @param id 预授信id
     * @return ApiResponse
     */
    ApiResponse findPreDetail(String id);

    /**
     *  分页查询企业资质认证
     * @param etpCerBo 查询对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    ApiResponse findEtpCerPage(EtpCerBo etpCerBo, BindingResult bindingResult);

    /**
     *  企业资质认证明细查询
     * @param id 认证id
     * @return  ApiResponse
     */
    ApiResponse findEtpCerDetail(String id);

    /**
     *  分页查询信息采集授权
     * @param infoAuthBo 查询对象
     * @param bindingResult 校验结果
     * @return  ApiResponse
     */
    ApiResponse findInfoAuthPage(InfoAuthBo infoAuthBo, BindingResult bindingResult);

    /**
     *  分页查询订单
     * @param loanApplyBo 查询对象
     * @param bindingResult 校验结果
     * @return  ApiResponse
     */
    ApiResponse loanPageQuery(LoanApplyBo loanApplyBo, BindingResult bindingResult);

    /**
     * 查询订单明细
     * @param id id
     * @return ApiResponse
     */
    ApiResponse findLoanDetail(String id);

    /**
     *  首页查询汇总信息
     * @return ApiResponse
     */
    ApiResponse findHomePageStatistics();

    /**
     * 通过id查找用户
     * @param id id
     * @return ApiResponse
     */
    ApiResponse findUserById(String id);
}
