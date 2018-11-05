package com.masspick.peak.guest.util;


/**
 * MessageConstant
 */
public class MessageConstant {

    // 类型 1 系统消息  2 借款消息  3 还款消息
    /**
     * SYSTEM_TYPE
     */
    public static final String SYSTEM_TYPE = "1";

    /**
     * LOAN_TYPE
     */
    public static final String LOAN_TYPE = "2";

    /**
     * REPAY_TYPE
     */
    public static final String REPAY_TYPE = "3";


    //删除标记 0 未删除 1删除
    /**
     * NOT_DELETED_DELFLAG
     */
    public static final String NOT_DELETED_DELFLAG = "0";

    /**
     * ALREADY_DELETED_DELFLAG
     */
    public static final String ALREADY_DELETED_DELFLAG = "1";


    //状态 0 未读  1 已读
    /**
     * UN_READ_STATUS
     */
    public static final String UN_READ_STATUS = "0";

    /**
     * ALREADY_READ_STATUS
     */
    public static final String ALREADY_READ_STATUS = "1";

    /**
     * @return String
     */
    public static String getStopLoanMessage() {
        return "抱歉，您申请的贷款审批不通过！";
    }

    /**
     * @return String
     */
    public static String getFinishLoanMessage() {
        return "您申请的贷款已经处理完成！";
    }
}
