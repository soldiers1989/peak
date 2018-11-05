package com.masspick.peak.decision.service.impl;

import com.masspick.peak.decision.mapper.WhiteListEtpMapper;
import com.masspick.peak.decision.model.WhiteListEtp;
import com.masspick.peak.decision.service.IDecisionRpcService;
import com.masspick.peak.model.dto.WhiteListEtpDto;
import com.masspick.peak.model.dto.WhiteListEtpFindBo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DecisionRpcServiceImpl
 */
@Service
public class DecisionRpcServiceImpl implements IDecisionRpcService {

    /**
     * whiteListEtpMapper
     */
    @Autowired
    private WhiteListEtpMapper whiteListEtpMapper;

    /**
     * @param whiteListEtpFindBo
     * @return WhiteListEtpDto
     */
    @Override
    public WhiteListEtpDto findWhiteList(WhiteListEtpFindBo whiteListEtpFindBo) {
        WhiteListEtpDto whiteListEtpDto = new WhiteListEtpDto();

        if (whiteListEtpFindBo == null || StringUtils.isEmpty(whiteListEtpFindBo.getEtpName())) {
            return null;
        }
        WhiteListEtp whiteListEtp = whiteListEtpMapper.findByEtpName(whiteListEtpFindBo.getEtpName());
        if (whiteListEtp == null) {
            return null;
        }
        BeanUtils.copyProperties(whiteListEtp, whiteListEtpDto);
        return whiteListEtpDto;
    }
}
