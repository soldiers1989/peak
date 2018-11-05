package com.masspick.peak.guest.service.impl;

import com.masspick.peak.guest.common.constant.CommonConstant;
import com.masspick.peak.guest.common.util.EtpScoreModel;
import com.masspick.peak.guest.mapper.NameCardInfoMapper;
import com.masspick.peak.guest.model.NameCardInfo;
import com.masspick.peak.guest.service.IPreCreditService;
import com.masspick.peak.guest.vo.ApiResponse;
import com.masspick.peak.model.dto.WhiteListEtpDto;
import com.masspick.peak.model.dto.WhiteListEtpFindBo;
import com.masspick.peak.service.DecisionFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 预授权
 */
@Service
public class PreCreditServiceImpl implements IPreCreditService {

    /**
     * nameCardInfoMapper
     */
    @Autowired
    private NameCardInfoMapper nameCardInfoMapper;

    /**
     * decisionFeignApi
     */
    @Autowired
    private DecisionFeignApi decisionFeignApi;

    /**
     * MIN_ETP_SCORE
     */
    private static final double MIN_ETP_SCORE = 427.2;

    /**
     * 预授信评估
     * @param nameCardInfo nameCardInfo
     * @return
     */
    @Override
    @Transactional
    public ApiResponse addPreCard(NameCardInfo nameCardInfo) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        //白名单校验
        WhiteListEtpFindBo whiteListEtpFindBo = new WhiteListEtpFindBo();
        whiteListEtpFindBo.setEtpName(nameCardInfo.getEtpName());
        WhiteListEtpDto whiteListEtpDto = decisionFeignApi.findWhiteList(whiteListEtpFindBo);
        if (whiteListEtpDto == null) {
            return apiResponse.error("401").setReason("非常抱歉,本服务暂未对贵公司开放!");
        }

        String legalName = whiteListEtpDto.getLegalName();
        if (!nameCardInfo.getLegalName().equals(legalName)) {
            return apiResponse.error("402").setReason("企业法人代表不是本人，申请授信失败！");
        }

        Double totalEtpScore = whiteListEtpDto.getTotalEtpScore();
        if (totalEtpScore == null) {
            return apiResponse.error("403").setReason("白名单对应企业评分为空，授信失败！");
        }

        nameCardInfo.setScore(totalEtpScore.toString());
        if (totalEtpScore.doubleValue() < MIN_ETP_SCORE) {
            return apiResponse.error("405").setReason("授信失败，您的信用记录无法通过系统评估！");
        }

        //根据评分获取 贷款额度和信用等级
        nameCardInfo.setCreditLevel(EtpScoreModel.getLevelByScore(totalEtpScore));
        nameCardInfo.setLoanLimit(EtpScoreModel.getLoanLimit(nameCardInfo.getCreditLevel()));

        //更新预授信记录
        NameCardInfo cardInfo = saveNameCardInfo(nameCardInfo);
        return apiResponse.success().setResult(cardInfo);
    }

    /**
     * 保存名片信息
     * @param nameCardInfo nameCardInfo
     * @return
     */
    @Override
    @Transactional
    public NameCardInfo saveNameCardInfo(NameCardInfo nameCardInfo) {
        //存在记录则更新 不存在则新增
        NameCardInfo cardInfo = nameCardInfoMapper.findByEtpNameAndOpenId(nameCardInfo.getEtpName(), nameCardInfo.getOpenId());
        if (cardInfo != null) {
            nameCardInfo.setId(cardInfo.getId());
            nameCardInfo.setUpdateDate(new Date());
            nameCardInfoMapper.update(nameCardInfo);
            nameCardInfo = nameCardInfoMapper.findByEtpNameAndOpenId(nameCardInfo.getEtpName(), nameCardInfo.getOpenId());
        } else {
            nameCardInfo.preInsert();
            nameCardInfo.setDelFlag(CommonConstant.NOT_DELETED_DELFLAG);
            nameCardInfoMapper.insert(nameCardInfo);
        }
        return nameCardInfo;
    }

    /**
     * 单条预授信查询
     * @param openId openId
     * @return
     */
    @Override
    public ApiResponse findNameCardByOpenId(String openId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<NameCardInfo> nameCardInfoList = nameCardInfoMapper.findByOpenId(openId);
        if (CollectionUtils.isEmpty(nameCardInfoList)) {
            return apiResponse.error("400").setReason("未信用评估任何公司");
        } else {
            return apiResponse.success().setResult(nameCardInfoList.get(0));
        }
    }

    /**
     * 多条预授信查询
     * @param openId openId
     * @return
     */
    @Override
    public ApiResponse findNameCardListByOpenId(String openId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<NameCardInfo> nameCardInfoList = nameCardInfoMapper.findByOpenId(openId);
        if (CollectionUtils.isEmpty(nameCardInfoList)) {
            return apiResponse.error("400").setReason("未信用评估任何公司");
        } else {
            return apiResponse.success().setResult(nameCardInfoList);
        }
    }


}
