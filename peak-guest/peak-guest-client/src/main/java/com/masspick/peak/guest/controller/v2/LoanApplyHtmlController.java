package com.masspick.peak.guest.controller.v2;

import com.masspick.peak.common.util.HeaderUtil;
import com.masspick.peak.guest.controller.vo.LoanApplyAddVo;
import com.masspick.peak.guest.model.UserWeiXin;
import com.masspick.peak.guest.service.ILoanApplyService;
import com.masspick.peak.guest.service.IUserService;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URLDecoder;


/**
 * 贷款
 */
@RestController
@RequestMapping("/v2/app/pre")
public class LoanApplyHtmlController {

    /**
     * loanApplyService
     */
    @Autowired
    private ILoanApplyService loanApplyService;

    /**
     *  httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * iUserService
     */
    @Autowired
    private IUserService iUserService;

    /**
     * 申请贷款
     * @param loanApplyAddVo 申请贷款信息
     * @return ApiResponse
     */
    @PostMapping(value = "/loan")
    public ApiResponse addLoanApply(@Valid @RequestBody LoanApplyAddVo loanApplyAddVo, BindingResult bindingResult) {
        return loanApplyService.addLoanApply(loanApplyAddVo, bindingResult);
    }

    /**
     * 查询申请记录
     * @return ApiResponse
     */
    @GetMapping(value = "/loans")
    public ApiResponse findLoanApplyList() {
        ApiResponse apiResponse = ApiResponse.getInstances();
        try {
            String moible = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
            UserWeiXin userWeiXin = iUserService.findUserByMobile(moible);
            if (userWeiXin == null) {
                return apiResponse.error("401").setReason("该用户不存在");
            }
            return loanApplyService.findLoanApplyList(userWeiXin.getId());
        } catch (Exception e) {
            return apiResponse.error("402").setReason("获取用户账号失败");
        }
    }

    /**
     * 申请记录明细
     * @param id 申请单id
     * @return ApiResponse
     */
    @GetMapping(value = "/loans/{id}")
    public ApiResponse findLoanDetail(@PathVariable("id") String id) {
        return loanApplyService.findLoanDetail(id);
    }

    /**
     *  查询还款明细
     * @return  ApiResponse
     */
    @GetMapping(value = "/repayPlan")
    public ApiResponse findRepayPlanByUserId() {
        ApiResponse apiResponse = ApiResponse.getInstances();
        try {
            String moible = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
            UserWeiXin userWeiXin = iUserService.findUserByMobile(moible);
            if (userWeiXin == null) {
                return apiResponse.error("401").setReason("该用户不存在");
            }
            return loanApplyService.findRepayList(userWeiXin.getId());
        } catch (Exception e) {
            return apiResponse.error("402").setReason("获取用户账号失败");
        }
    }
}
