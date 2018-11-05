package com.masspick.peak.common;

/**
 * FlowDto
 */
public class FlowDto {

    /**
     * procefKey
     */
    public static final String PROCEFKEY = "companyCard";

    /**
     * flowNodes
     * 不通过flownodes接口去得到流程节点名称 太麻烦 规定大于配置  代码写的更简便
     * userTask
     */
    public static final String[] FLOWNODES = {"征信拆解", "预约确认", "尽职调查", "审批登记", "合规审批", "自动发标"};

    /**
     * TAXFLOWNODES
     */
    public static final String[] TAXFLOWNODES = {"征信拆解", "风控审批", "预约确认", "尽职调查", "综合审批", "风控总监审批",
            "合规审批", "副经理审批", "总经理审批", "资产推送"};

    /**
     * MAX_FLOW
     * 下版本加上风险决策 max变为7
     */
    public static final int MAX_FLOW = FLOWNODES.length; //流程步骤 默认是6

    /**
     * TAX_MAX_FLOW
     */
    public static final int TAX_MAX_FLOW = TAXFLOWNODES.length; //流程步骤 默认是6

    /**
     * FINANC
     */
    public static final String FINANC = "financingPlatform";

    /**
     * ACT_TYPE_USER_TASK
     */
    public static final String ACT_TYPE_USER_TASK = "userTask";
}
