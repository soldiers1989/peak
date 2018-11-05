package com.masspick.peak.dd.service.impl;

import com.masspick.peak.dd.service.EtpService;
import com.masspick.peak.dd.util.SpringContextHolder;
import com.masspick.peak.model.dto.etp.EtpBasicDTO;
import com.masspick.peak.service.IEtpFeignApi;
import org.springframework.stereotype.Service;

/**
 * EtpServiceImpl
 */
@Service
public class EtpServiceImpl implements EtpService {


    /**
     * @param etpName
     * @return EtpBasicDTO
     */
    @Override
    public EtpBasicDTO findEtpByEtpName(String etpName) {
        try {
            IEtpFeignApi iEtpFeignApi = (IEtpFeignApi) SpringContextHolder.getBean(IEtpFeignApi.class);
            EtpBasicDTO dto = iEtpFeignApi.findBasicById(etpName);
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
