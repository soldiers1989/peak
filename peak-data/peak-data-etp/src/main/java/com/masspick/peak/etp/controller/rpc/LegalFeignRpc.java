package com.masspick.peak.etp.controller.rpc;

import com.masspick.peak.etp.service.ILegalBOService;
import com.masspick.peak.model.dto.legal.RiskDTO;
import com.masspick.peak.service.ILegalFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/7/6 0006.
 */
@RestController
public class LegalFeignRpc implements ILegalFeignApi {
    /**
     * iLegalBOService
     */
    @Autowired
    private ILegalBOService iLegalBOService;

    /**
     * @param etpId
     * @return RiskDTO
     */
    @Override
    public RiskDTO risk(@PathVariable("etpId")String etpId) {
        return iLegalBOService.findRiskById(etpId);
    }
}
