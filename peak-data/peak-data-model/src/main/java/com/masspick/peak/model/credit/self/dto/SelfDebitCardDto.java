package com.masspick.peak.model.credit.self.dto;



import com.masspick.peak.model.credit.self.SelfDebitCard;
import com.masspick.peak.model.credit.self.SelfOverdue;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 * 贷记卡
 */
public class SelfDebitCardDto extends SelfDebitCard {

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
