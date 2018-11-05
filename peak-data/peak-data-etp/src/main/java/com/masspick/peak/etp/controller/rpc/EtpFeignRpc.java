package com.masspick.peak.etp.controller.rpc;

import com.masspick.peak.etp.service.IEtpBOService;
import com.masspick.peak.model.dto.etp.EtpBasicDTO;
import com.masspick.peak.service.IEtpFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by admin on 2018/7/6 0006.
 */
@RestController
public class EtpFeignRpc implements IEtpFeignApi {

    /**
     * iEtpBOService
     */
    @Autowired
    private IEtpBOService iEtpBOService;


    /**
     * @param entName
     * @return EtpBasicDTO
     */
    @Override
    public EtpBasicDTO findBasicById(@PathVariable("etpName") String etpName) throws InvocationTargetException, IllegalAccessException {
        EtpBasicDTO dto = iEtpBOService.findBasicById(etpName);
        return dto;
    }
}
