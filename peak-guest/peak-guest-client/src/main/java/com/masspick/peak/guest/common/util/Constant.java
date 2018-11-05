package com.masspick.peak.guest.common.util;

/**
 * Created by Administrator on 2018\7\13 0013.
 */
public class Constant {

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

    //授权合同编号使用状态
    /**
     * UNUSE_AUTH_NO
     */
    public static final String UNUSE_AUTH_NO = "0";

    /**
     * USED_AUTH_NO
     */
    public static final String USED_AUTH_NO = "1";

    //信息采集授权状态
    /**
     * UN_REVIEW_STATUS
     */
    public static final String UN_REVIEW_STATUS = "0";

    /**
     * PASSED_REVIE_STATUS
     */
    public static final String PASSED_REVIE_STATUS = "1";

    /**
     * FAILED_REVIEW_STATUS
     */
    public static final String FAILED_REVIEW_STATUS = "2";

    //申请贷款状态
    /**
     * STOP_LOAN_STATUS
     */
    public static final String STOP_LOAN_STATUS = "0";

    /**
     * CREATE_LOAN_STATUS
     */
    public static final String CREATE_LOAN_STATUS = "1";

    /**
     * APPOINT_LOAN_STATUS
     */
    public static final String APPOINT_LOAN_STATUS = "2";

    /**
     * SIGNING_LOAN_STATUS
     */
    public static final String SIGNING_LOAN_STATUS = "3";

    /**
     * RELEASED_LOAN_STATUS
     */
    public static final String RELEASED_LOAN_STATUS = "4";

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

    //流程自定义状态 0 发起 1进行中 2终止 3完成
    /**
     * CREATE_FLOW_STATUS
     */
    public static final String CREATE_FLOW_STATUS = "0";

    /**
     * RUNNING_FLOW_STATUS
     */
    public static final String RUNNING_FLOW_STATUS = "1";

    /**
     * STOP_FLOW_STATUS
     */
    public static final String STOP_FLOW_STATUS = "2";

    /**
     * FINISH_FLOW_STATUS
     */
    public static final String FINISH_FLOW_STATUS = "3";
}
