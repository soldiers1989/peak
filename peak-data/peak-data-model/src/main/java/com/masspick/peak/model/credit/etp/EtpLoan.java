package com.masspick.peak.model.credit.etp;

import java.util.Date;

/**
 * etp_loan
 * 贷款
 */
public class EtpLoan {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 机构
     */
    private String institution;

    /**
     * 币种
     */
    private String curType;

    /**
     * 借据金额
     */
    private Double fee;

    /**
     * 借据余额
     */
    private Double overFee;

    /**
     * 放款日期
     */
    private Date startDate;

    /**
     * 到期日期
     */
    private Date expiredDate;

    /**
     * 结清日期
     */
    private Date settledDate;

    /**
     * 业务种类
     */
    private String bussType;

    /**
     * 贷款形式
     */
    private String loanMethod;

    /**
     * 结清方式
     */
    private String settledMethod;

    /**
     * 担保
     */
    private String guarantee;

    /**
     * 展期
     */
    private String extension;

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    private Integer classify;

    /**
     * 1: 当前债务；2：已还清债务
     */
    private Integer state;

    /**
     * id
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 征信报告id
     * @return report_id 征信报告id
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * 征信报告id
     * @param reportId 征信报告id
     */
    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    /**
     * 机构
     * @return institution 机构
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * 机构
     * @param institution 机构
     */
    public void setInstitution(String institution) {
        this.institution = institution == null ? null : institution.trim();
    }

    /**
     * 币种
     * @return cur_type 币种
     */
    public String getCurType() {
        return curType;
    }

    /**
     * 币种
     * @param curType 币种
     */
    public void setCurType(String curType) {
        this.curType = curType == null ? null : curType.trim();
    }

    /**
     * 借据金额
     * @return fee 借据金额
     */
    public Double getFee() {
        return fee;
    }

    /**
     * 借据金额
     * @param fee 借据金额
     */
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * 借据余额
     * @return over_fee 借据余额
     */
    public Double getOverFee() {
        return overFee;
    }

    /**
     * 借据余额
     * @param overFee 借据余额
     */
    public void setOverFee(Double overFee) {
        this.overFee = overFee;
    }

    /**
     * 放款日期
     * @return start_date 放款日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 放款日期
     * @param startDate 放款日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 到期日期
     * @return expired_date 到期日期
     */
    public Date getExpiredDate() {
        return expiredDate;
    }

    /**
     * 到期日期
     * @param expiredDate 到期日期
     */
    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    /**
     * 结清日期
     * @return settled_date 结清日期
     */
    public Date getSettledDate() {
        return settledDate;
    }

    /**
     * 结清日期
     * @param settledDate 结清日期
     */
    public void setSettledDate(Date settledDate) {
        this.settledDate = settledDate;
    }

    /**
     * 业务种类
     * @return buss_type 业务种类
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * 业务种类
     * @param bussType 业务种类
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
    }

    /**
     * 贷款形式
     * @return loan_method 贷款形式
     */
    public String getLoanMethod() {
        return loanMethod;
    }

    /**
     * 贷款形式
     * @param loanMethod 贷款形式
     */
    public void setLoanMethod(String loanMethod) {
        this.loanMethod = loanMethod == null ? null : loanMethod.trim();
    }

    /**
     * Gets settledMethod
     *
     * @return value of settledMethod
     */
    public String getSettledMethod() {
        return settledMethod;
    }

    /**
     * @param settledMethod
     */
    public void setSettledMethod(String settledMethod) {
        this.settledMethod = settledMethod;
    }

    /**
     * 担保
     * @return guarantee 担保
     */
    public String getGuarantee() {
        return guarantee;
    }

    /**
     * 担保
     * @param guarantee 担保
     */
    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee == null ? null : guarantee.trim();
    }

    /**
     * 展期
     * @return extension 展期
     */
    public String getExtension() {
        return extension;
    }

    /**
     * 展期
     * @param extension 展期
     */
    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     * @return classify 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    public Integer getClassify() {
        return classify;
    }

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     * @param classify 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    /**
     * 1: 当前债务；2：已还清债务
     * @return state 1: 当前债务；2：已还清债务
     */
    public Integer getState() {
        return state;
    }

    /**
     * 1: 当前债务；2：已还清债务
     * @param state 1: 当前债务；2：已还清债务
     */
    public void setState(Integer state) {
        this.state = state;
    }
}
