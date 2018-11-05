package com.masspick.peak.guest.common.constant;


/**
 * CommonConstant
 */
public class CommonConstant {

    //删除标记 0 未删除 1删除
    /**
     * NOT_DELETED_DELFLAG
     */
    public static final String NOT_DELETED_DELFLAG = "0";

    /**
     * ALREADY_DELETED_DELFLAG
     */
    public static final String ALREADY_DELETED_DELFLAG = "1";

    //资质认证单个认证状态
    /**
     * UN_CER_STATUS
     */
    public static final String UN_CER_STATUS = "0";

    /**
     * PASSED_CER_STATUS
     */
    public static final String PASSED_CER_STATUS = "1";

    /**
     * FAILED_CER_STATUS
     */
    public static final String FAILED_CER_STATUS = "2";

    //企业资质认证最终状态
    /**
     * FAILURE_ETP_CER
     */
    public static final String FAILURE_ETP_CER = "0";

    /**
     * SUCCESS_ETP_CER
     */
    public static final String SUCCESS_ETP_CER = "1";


    //申请贷款状态 0-进行中 1-终止 2-完成
    /**
     * HANDING_LOAN_STATUS 进行中
     */
    public static final String HANDING_LOAN_STATUS = "0";

    /**
     * STOP_LOAN_STATUS 终止
     */
    public static final String STOP_LOAN_STATUS = "1";

    /**
     * FINISH_LOAN_STATUS 完成
     */
    public static final String FINISH_LOAN_STATUS = "2";


    //流程查询状态
    /**
     * REPAY_METHOD
     */
    public static final String REPAY_METHOD = "按月付息，到期还本";

    /**
     * FINISH_PROCESS
     */
    public static final String FINISH_PROCESS = "finish";

    /**
     * STOP_PROCESS
     */
    public static final String STOP_PROCESS = "stop";

    /**
     * RUNNING_PROCESS
     */
    public static final String RUNNING_PROCESS = "running";

    //流程自定义状态 0 进行中 1终止 2完成
    /**
     * HANDING_FLOW_STATUS
     */
    public static final String HANDING_FLOW_STATUS = "0";

    /**
     * STOP_FLOW_STATUS
     */
    public static final String STOP_FLOW_STATUS = "1";

    /**
     * FINISH_FLOW_STATUS
     */
    public static final String FINISH_FLOW_STATUS = "2";

    /**
     * STOP_MESSAGE
     */
    public static final String STOP_REASON = "审批不通过！";

    /**
     *  产品禁用状态
     */
    public static final Integer DISABLE_STATUS = 0;

    /**
     * 产品启用状态
     */
    public static final Integer ABLE_STATUS = 1;

}
