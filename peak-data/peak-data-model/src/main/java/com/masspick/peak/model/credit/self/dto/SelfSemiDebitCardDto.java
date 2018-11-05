package com.masspick.peak.model.credit.self.dto;



import com.masspick.peak.model.credit.self.SelfOverdue;
import com.masspick.peak.model.credit.self.SelfSemiDebitCard;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public class SelfSemiDebitCardDto extends SelfSemiDebitCard {

    /**
     * 逾期统计
     */
    private List<SelfOverdue> overdueList;

    /**
     * Gets overdueList
     *
     * @return value of overdueList
     */
    public List<SelfOverdue> getOverdueList() {
        return overdueList;
    }

    /**
     * @param overdueList
     */
    public void setOverdueList(List<SelfOverdue> overdueList) {
        this.overdueList = overdueList;
    }
}
