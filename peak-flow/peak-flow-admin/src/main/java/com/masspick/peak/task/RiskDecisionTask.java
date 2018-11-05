package com.masspick.peak.task;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * 风险决策
 */
public class RiskDecisionTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {

        //调用风险决策接口

        delegateExecution.setVariable("riskDecisionLevel", new StringBuffer("B").toString());
        delegateExecution.setVariable("riskDecisionAccess", new StringBuffer("access").toString());


        System.out.println("风险决策要干嘛?!" + delegateExecution.getVariable("ddOperator"));
    }
}
