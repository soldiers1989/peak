package com.masspick.peak.dd.service;

import com.masspick.peak.model.dto.etp.EtpBasicDTO;

/**
 * EtpService
 */
public interface EtpService {
    /**
     * @param etpName
     * @return EtpBasicDTO
     */
    EtpBasicDTO findEtpByEtpName(String etpName);
}
