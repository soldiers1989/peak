package com.masspick.peak.etp.service.impl;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.etp.mapper.etp.EtpBaseMapper;
import com.masspick.peak.etp.mapper.legal.BreakfaithMapper;
import com.masspick.peak.etp.mapper.legal.CourtMapper;
import com.masspick.peak.etp.mapper.legal.CourtPubMapper;
import com.masspick.peak.etp.mapper.legal.ExecutedMapper;
import com.masspick.peak.etp.service.ILegalBOService;
import com.masspick.peak.model.dto.legal.BreakfaithDTO;
import com.masspick.peak.model.dto.legal.CourtDTO;
import com.masspick.peak.model.dto.legal.CourtPubDTO;
import com.masspick.peak.model.dto.legal.ExecutedDTO;
import com.masspick.peak.model.dto.legal.RiskDTO;
import com.masspick.peak.model.legal.Breakfaith;
import com.masspick.peak.model.legal.Court;
import com.masspick.peak.model.legal.CourtPub;
import com.masspick.peak.model.legal.Executed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/6/11 0011.
 */
@Service
public class ILegalBOServiceImpl implements ILegalBOService {

    /**
     * 企业基本信息
     */
    @Autowired
    private EtpBaseMapper etpBaseMapper;

    /**
     * courtMapper
     */
    @Autowired
    private CourtMapper courtMapper;

    /**
     * courtpubMapper
     */
    @Autowired
    private CourtPubMapper courtpubMapper;

    /**
     * executedMapper
     */
    @Autowired
    private ExecutedMapper executedMapper;

    /**
     * breakfaithMapper
     */
    @Autowired
    private BreakfaithMapper breakfaithMapper;

    @Override
    public RiskDTO findRiskById(String entName) {
        //根据名称去查询裁判文书信息
        //EtpBase etpBase = etpBaseMapper.findByEntName(entName);
        RiskDTO dto = new RiskDTO();
        List<Court> crdCourt = courtMapper.findByEtpId(entName, null);

        List<CourtDTO> courtDTOS = new ArrayList<>();
        for (Court court : crdCourt) {
            courtDTOS.add(JacksonUtils.copyProperties(court, CourtDTO.class));
        }
        dto.setCourt(courtDTOS);
        List<CourtPub> crdCourtPub = courtpubMapper.findByEtpId(entName);

        List<CourtPubDTO> courtPubDTOS = new ArrayList<>();
        for (CourtPub courtPub : crdCourtPub) {
            courtPubDTOS.add(JacksonUtils.copyProperties(courtPub, CourtPubDTO.class));
        }
        dto.setCourtPub(courtPubDTOS);

        List<Executed> crdExecuted = executedMapper.findByEtpId(entName);
        List<ExecutedDTO> executedDTOS = new ArrayList<>();
        for (Executed executed : crdExecuted) {
            executedDTOS.add(JacksonUtils.copyProperties(executed, ExecutedDTO.class));
        }
        dto.setExecuted(executedDTOS);

        List<Breakfaith> crdBreakfaith = breakfaithMapper.findByEtpId(entName);
        List<BreakfaithDTO> breakfaithDTOS = new ArrayList<>();
        for (Breakfaith breakfaith : crdBreakfaith) {
            breakfaithDTOS.add(JacksonUtils.copyProperties(breakfaith, BreakfaithDTO.class));
        }
        dto.setBreakfaith(breakfaithDTOS);
        return dto;
    }
}
