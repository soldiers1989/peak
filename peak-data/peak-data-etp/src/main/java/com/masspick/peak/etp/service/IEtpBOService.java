package com.masspick.peak.etp.service;


import com.masspick.peak.model.dto.etp.EtpBasicDTO;

/**
 * Created by admin on 2018/6/11 0011.
 */
public interface IEtpBOService {
    /**
     * @param entName
     * @return EtpBasicDTO
     */
    EtpBasicDTO findBasicById(String entName);
}
