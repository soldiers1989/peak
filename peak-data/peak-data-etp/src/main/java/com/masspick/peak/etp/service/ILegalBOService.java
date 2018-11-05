package com.masspick.peak.etp.service;

import com.masspick.peak.model.dto.legal.RiskDTO;

/**
 * Created by admin on 2018/6/11 0011.
 */
public interface ILegalBOService {
    /**
     * @param entName
     * @return RiskDTO
     */
    RiskDTO findRiskById(String entName);
}
