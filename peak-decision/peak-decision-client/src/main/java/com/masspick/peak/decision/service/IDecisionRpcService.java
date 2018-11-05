package com.masspick.peak.decision.service;


import com.masspick.peak.model.dto.WhiteListEtpDto;
import com.masspick.peak.model.dto.WhiteListEtpFindBo;

/**
 * IDecisionRpcService
 */
public interface IDecisionRpcService {
    /**
     * @param whiteListEtpFindBo
     * @return WhiteListEtpDto
     */
    WhiteListEtpDto findWhiteList(WhiteListEtpFindBo whiteListEtpFindBo);
}
