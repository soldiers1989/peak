package com.masspick.peak.task;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * AssetFilingTask
 */
public class AssetFilingTask implements JavaDelegate {

    /**
     * @param delegateExecution
     */
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("资产归档 " + delegateExecution.getVariable("riskDecisionLevel"));
    }
}
