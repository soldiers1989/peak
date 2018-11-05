package com.masspick.peak.guest.controller;

import com.masspick.peak.guest.bo.EtpCerBo;
import com.masspick.peak.guest.bo.InfoAuthBo;
import com.masspick.peak.guest.bo.LoanApplyBo;
import com.masspick.peak.guest.bo.NameCardInfoBo;
import com.masspick.peak.guest.bo.UserWeiXinFindBo;
import com.masspick.peak.guest.service.IManageService;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * ManageController
 */
@RestController
@RequestMapping("/v1/app/back")
public class ManageController extends BaseController {

    /**
     * manageService
     */
    @Autowired
    private IManageService manageService;

    /**
     *  首页汇总信息
     * @return ApiResponse
     */
    @GetMapping(value = "/homepage")
    public ApiResponse findUserPage() {
        return manageService.findHomePageStatistics();
    }

    /**
     *  获取用户推广渠道列表
     * @return ApiResponse
     */
    @GetMapping(value = "/ins")
    public ApiResponse findInsList() {
        return manageService.findInsList();
    }

    /**
     * 分页查询用户
     * @param findVo 查询对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @GetMapping(value = "/usersGrid")
    public ApiResponse findUserPage(@Valid UserWeiXinFindBo findVo, BindingResult bindingResult) {
        return manageService.findUserPage(findVo, bindingResult);
    }

    /**
     *  根据用户id查找用户
     * @param id id
     * @return ApiResponse
     */
    @GetMapping(value = "/users/{id}")
    public ApiResponse findUserById(@PathVariable("id") String id){
        return manageService.findUserById(id);
    }

    /**
     * 分页查询信用额度评估信息
     * @param nameCardInfoBo 查询对象
     * @return ApiResponse
     */
    @GetMapping(value = "/cardInfoGrid")
    public ApiResponse findPrePage(NameCardInfoBo nameCardInfoBo) {
        return manageService.findPrePage(nameCardInfoBo);
    }


    /**
     * 信用额度评估详细信息
     * @param id 信用额度id
     * @return ApiResponse
     */
    @GetMapping(value = "/cardInfos/{id}")
    public ApiResponse findPreDetail(@PathVariable("id") String id) {
        return manageService.findPreDetail(id);
    }

    /**
     * 分页查询资质认证
     * @param etpCerBo 查询对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @GetMapping(value = "/etpCersGrid")
    public ApiResponse findEtpCerPage(@Valid EtpCerBo etpCerBo, BindingResult bindingResult) {
        return manageService.findEtpCerPage(etpCerBo, bindingResult);
    }

    /**
     * 企业资质认证明细查询
     * @param id 认证id
     * @return  ApiResponse
     */
    @GetMapping(value = "/etpCers/{id}")
    public ApiResponse findEtpCerDetail(@PathVariable("id") String id) {
        return manageService.findEtpCerDetail(id);
    }

    /**
     * 分页查询信息采集授权
     * @param infoAuthBo 查询对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @GetMapping(value = "/infoAuthsGrid")
    public ApiResponse findInfoAuthPage(@Valid InfoAuthBo infoAuthBo, BindingResult bindingResult) {
        return manageService.findInfoAuthPage(infoAuthBo, bindingResult);
    }


    /**
     *  订单分页查询
     * @param loanApplyBo 查询对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @GetMapping(value = "/loansGrid")
    public ApiResponse loanPageQuery(@Valid LoanApplyBo loanApplyBo, BindingResult bindingResult) {
        return manageService.loanPageQuery(loanApplyBo, bindingResult);
    }

    /***
     *  查询订单明细
     * @param id id
     * @return ApiResponse
     */
    @GetMapping(value = "/loans/{id}")
    public ApiResponse findLoanDetail(@PathVariable("id") String id) {
        return manageService.findLoanDetail(id);
    }
}
