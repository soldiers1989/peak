package com.masspick.peak.guest.controller.vo;


import com.masspick.peak.guest.bo.LoanApplyShowVo;
import com.masspick.peak.guest.model.LoanContractInfo;

import java.util.List;

/**
 *  贷款明细
 */
public class LoanDetailShowVo {

    /**
     * loanApply 申请单信息
     */
    private LoanApplyShowVo loanApply;

    /**
     *  法人征信上传地址
     */
    private List<String> controllerCreditUrls;

    /**
     *  企业征信上传地址
     */
    private List<String> corporateCreditUrls;

    /**
     * loanContractInfo
     */
    private LoanContractInfo loanContractInfo;

    /**
     * Gets loanApply
     *
     * @return value of loanApply
     */
    public LoanApplyShowVo getLoanApply() {
        return loanApply;
    }

    /**
     * @param loanApply loanApply
     */
    public void setLoanApply(LoanApplyShowVo loanApply) {
        this.loanApply = loanApply;
    }

    /**
     * Gets controllerCreditUrls
     *
     * @return value of controllerCreditUrls
     */
    public List<String> getControllerCreditUrls() {
        return controllerCreditUrls;
    }

    /**
     * @param controllerCreditUrls controllerCreditUrls
     */
    public void setControllerCreditUrls(List<String> controllerCreditUrls) {
        this.controllerCreditUrls = controllerCreditUrls;
    }

    /**
     * Gets corporateCreditUrls
     *
     * @return value of corporateCreditUrls
     */
    public List<String> getCorporateCreditUrls() {
        return corporateCreditUrls;
    }

    /**
     * @param corporateCreditUrls corporateCreditUrls
     */
    public void setCorporateCreditUrls(List<String> corporateCreditUrls) {
        this.corporateCreditUrls = corporateCreditUrls;
    }

    /**
     * Gets loanContractInfo
     *
     * @return value of loanContractInfo
     */
    public LoanContractInfo getLoanContractInfo() {
        return loanContractInfo;
    }

    /**
     * @param loanContractInfo loanContractInfo
     */
    public void setLoanContractInfo(LoanContractInfo loanContractInfo) {
        this.loanContractInfo = loanContractInfo;
    }
}
