package com.masspick.peak.guest.service;


import com.masspick.peak.guest.controller.vo.LoanApplyAddVo;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.validation.BindingResult;

/**
 * ILoanApplyService
 */
public interface ILoanApplyService {
    /**
     *  申请贷款
     * @param loanApplyAddVo 申请对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    ApiResponse addLoanApply(LoanApplyAddVo loanApplyAddVo, BindingResult bindingResult);

    /**
     * 查询申请记录
     * @param userId 用户id
     * @return ApiResponse
     */
    ApiResponse findLoanApplyList(String userId);

    /**
     * 查询申请记录明细
     * @param id 申请单id
     * @return ApiResponse
     */
    ApiResponse findLoanDetail(String id);

    /**
     * 查找还款计划
     * @param userId 用户id
     * @return ApiResponse
     */
    ApiResponse findRepayList(String userId);

    /**
     * 公司对应贷款信息
     * @param etpName etpName
     * @return ApiResponse
     */
    ApiResponse findLoanOrderByEtpName (String etpName);

    /**
     * 巅峰对应企业订单
     * @param pageNum
     * @param pageSize
     * @param number
     * @return
     */
    ApiResponse findLoanOrderByPage(Integer pageNum, Integer pageSize, String number);

    /**
     * 编号统计订单数
     * @param number
     * @return
     */
    ApiResponse findLoanCountByNumber(String number);
}
