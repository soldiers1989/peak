package com.masspick.peak.task;


import com.masspick.peak.service.LoanFeignApi;
import com.masspick.peak.utils.SpringContextHolder;
import org.flowable.engine.HistoryService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 流程结束时 调用
 */
public class EndProcess implements ExecutionListener {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EndProcess.class);
    /**
     * historyService
     */
    @Autowired
    private HistoryService historyService;


    @Override
    public void notify(DelegateExecution delegateExecution) {

        if (historyService == null) {
            historyService = (HistoryService) SpringContextHolder.getBean(HistoryService.class);
        }

        LoanFeignApi loanFeignApi = (LoanFeignApi) SpringContextHolder.getBean(LoanFeignApi.class);
        String flowId = delegateExecution.getProcessInstanceId();
        String appointConfirmTime = delegateExecution.getVariable("appointTime") == null
                ? "" : delegateExecution.getVariable("appointTime").toString();
        LOGGER.info("appointConfirmTime:" + appointConfirmTime);
        String loanTerm = delegateExecution.getVariable("loanTerm") == null
                ? "" : delegateExecution.getVariable("loanTerm").toString();
        LOGGER.info("loanTerm:" + loanTerm);
        String loanAmount = delegateExecution.getVariable("loanAmount") == null
                ? "" : delegateExecution.getVariable("loanAmount").toString();
        LOGGER.info("loanAmount:" + loanAmount);
        String reverifyDate = delegateExecution.getVariable("reverifyDate") == null
                ? "" : delegateExecution.getVariable("reverifyDate").toString();
        LOGGER.info("reverifyDate:" + reverifyDate);
        String actId = delegateExecution.getCurrentActivityId();
        LOGGER.info("actId:" + actId);
        Map<String, String> param = new HashMap<>();

        if (!actId.equals("stop") && !actId.equals("finish")) {
            //预约确认后才会传
            param.put("appointTime", appointConfirmTime);
        }
        
        param.put("status", actId);
        param.put("loanTerm", loanTerm);
        param.put("loanAmount", loanAmount);
        param.put("reverifyDate", reverifyDate);
        try {
            loanFeignApi.notifyLoanHandResult(flowId, param);
            LOGGER.error("回调成功");
        } catch (Exception e) {
            LOGGER.error("调用接口失败");
        }
    }
}
