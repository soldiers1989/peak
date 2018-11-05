package com.masspick.peak.etp.service.impl;

import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.etp.mapper.etp.EtpBaseMapper;
import com.masspick.peak.etp.mapper.etp.EtpBranchMapper;
import com.masspick.peak.etp.mapper.etp.EtpSeniorManagerMapper;
import com.masspick.peak.etp.mapper.etp.EtpShareholderMapper;
import com.masspick.peak.etp.service.IEtpBOService;
import com.masspick.peak.model.dto.etp.EtpBasicDTO;
import com.masspick.peak.model.dto.etp.EtpBranchDTO;
import com.masspick.peak.model.dto.etp.EtpSeniorManagerDTO;
import com.masspick.peak.model.dto.etp.EtpShareholderDTO;
import com.masspick.peak.model.etp.EtpBase;
import com.masspick.peak.model.etp.EtpBranch;
import com.masspick.peak.model.etp.EtpSeniorManager;
import com.masspick.peak.model.etp.EtpShareholder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018/6/11 0011.
 */
@Service
public class IEtpBOServiceImpl implements IEtpBOService {

    /**
     * etpBaseMapper
     */
    @Autowired
    private EtpBaseMapper etpBaseMapper;

    /**
     * etpShareholderMapper
     */
    @Autowired
    private EtpShareholderMapper etpShareholderMapper;

    /**
     * etpSeniorManagerMapper
     */
    @Autowired
    private EtpSeniorManagerMapper etpSeniorManagerMapper;


    /**
     * etpBranchMapper
     */
    @Autowired
    private EtpBranchMapper etpBranchMapper;

    /**
     * INT_100
     */
    private static final int INT_100 = 100;

    /**
     * @param entName
     * @return EtpBasicDTO
     */
    @Override
    public EtpBasicDTO findBasicById(String entName) {

        EtpBase etpBase = etpBaseMapper.findByEntName(entName);

        EtpBasicDTO basicDTO = new EtpBasicDTO();

        if (etpBase != null) {
            basicDTO.setCreditCode(etpBase.getCreditCode());
            basicDTO.setRegState(etpBase.getRegStateCn());
            basicDTO.setRegDate(etpBase.getRegDate());
            basicDTO.setType(etpBase.getType());

            Date businessStart = etpBase.getBusinessStart();
            Date businessFinish = etpBase.getBusinessFinish();
            StringBuilder businessStartFinish = new StringBuilder("");
            if (businessStart != null) {
                businessStartFinish.append(DateUtils.format(businessStart, "yyyy-MM-dd"));
            }

            if (businessFinish != null) {
                businessStartFinish.append("-" + DateUtils.format(businessFinish, "yyyy-MM-dd"));
            } else {
                businessStartFinish.append("-无固定期限");
            }
            basicDTO.setBusinessStartFinish(businessStartFinish.toString());
            basicDTO.setLegalRep(etpBase.getLegalPerson());
            basicDTO.setCheckDate(etpBase.getCheckDate());

            basicDTO.setRegCapital(etpBase.getRegCapital());
            basicDTO.setRegOffice(etpBase.getRegOffice());
            basicDTO.setBusinessScope(etpBase.getBusinessScope());
            basicDTO.setAddress(etpBase.getAddress());
            basicDTO.setCity(etpBase.getCity());
            List<EtpShareholder> etpShareholder = etpShareholderMapper.findByEtpId(etpBase.getEntName());
            List<EtpShareholderDTO> etpShareholderDTOS = new ArrayList<>();
            String regCapital = etpBase.getRegCapital();
            if (StringUtils.isNotBlank(regCapital)) {
                for (EtpShareholder etpShareholderRate : etpShareholder) {
                    Double r = (etpShareholderRate.getConfusingAmount() / Double.parseDouble(regCapital)) * INT_100;
                    etpShareholderRate.setRate(r.toString() + "%");
                    etpShareholderDTOS.add(JacksonUtils.copyProperties(etpShareholderRate, EtpShareholderDTO.class));
                }
            }
            basicDTO.setEtpShareholder(etpShareholderDTOS);
            //成员信息
            List<EtpSeniorManager> etpSeniorManagerList = etpSeniorManagerMapper.findByEtpId(etpBase.getEntName());
            List<EtpSeniorManagerDTO> etpSeniorManagerDTOS = new ArrayList<>();
            for (EtpSeniorManager etpSeniorManager : etpSeniorManagerList) {
                etpSeniorManagerDTOS.add(JacksonUtils.copyProperties(etpSeniorManager, EtpSeniorManagerDTO.class));
            }
            basicDTO.setEtpSeniorManager(etpSeniorManagerDTOS);


            List<EtpBranch> etpBranchList = etpBranchMapper.findByEtpId(etpBase.getEntName());
            List<EtpBranchDTO> etpBranchDTOS = new ArrayList<>();
            for (EtpBranch etpBranch : etpBranchList) {
                etpBranchDTOS.add(JacksonUtils.copyProperties(etpBranch, EtpBranchDTO.class));
            }
            basicDTO.setEtpBranch(etpBranchDTOS);
            //变更信息
        }

        return basicDTO;
    }
}
