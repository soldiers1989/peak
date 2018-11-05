package com.masspick.peak.guest.controller.v1;

import com.masspick.peak.guest.controller.vo.LoanApplyAddVo;
import com.masspick.peak.guest.service.ILoanApplyService;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * 贷款
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/app/pre")
public class LoanApplyController {

    /**
     * loanApplyService
     */
    @Autowired
    private ILoanApplyService loanApplyService;

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
     * @param userId 用户id
     * @return ApiResponse
     */
    @GetMapping(value = "/loans")
    public ApiResponse findLoanApplyList(String userId) {
        return loanApplyService.findLoanApplyList(userId);
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
     * @param userId 用户id
     * @return  ApiResponse
     */
    @GetMapping(value = "/repayPlan/{userId}")
    public ApiResponse findRepayPlanByUserId(@PathVariable("userId") String userId) {
        return loanApplyService.findRepayList(userId);
    }

    /**
     * 公司对应贷款信息
     * @param etpName etpName
     * @return  ApiResponse
     */
    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping(value = "/loans/{etpName}/order")
    public ApiResponse findLoanByEtpName(@PathVariable("etpName") String etpName) {
        return loanApplyService.findLoanOrderByEtpName(etpName);
    }

    /**
     *
     * @param pageNum
     * @param pageSize
     * @param request
     * @return ApiResponse
     */
    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping(value = "/loanApply/order")
    public ApiResponse findLoanByPage(@NotNull(message = "页码不能为空")
                                      @RequestParam(name = "pageNum") Integer pageNum,
                                      @NotNull(message = "页数不能为空")
                                      @RequestParam(name = "pageSize") Integer pageSize, HttpServletRequest request){
        //after page
        String number = request.getHeader("number");
        return loanApplyService.findLoanOrderByPage(pageNum,pageSize,number);
    }


    /**
     * 订单统计
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param request request
     * @return ApiResponse
     */
    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping(value = "/loan/count")
    public ApiResponse findLoanCount(HttpServletRequest request){
        String number = request.getHeader("number");
        return loanApplyService.findLoanCountByNumber(number);
    }

}
