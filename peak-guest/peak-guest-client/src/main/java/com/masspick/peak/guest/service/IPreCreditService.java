package com.masspick.peak.guest.service;


import com.masspick.peak.guest.model.NameCardInfo;
import com.masspick.peak.guest.vo.ApiResponse;

/**
 * IPreCreditService
 */
public interface IPreCreditService {

    /**
     * @param nameCardInfo
     * @return ApiResponse
     */
    ApiResponse addPreCard(NameCardInfo nameCardInfo);

    /**
     * @param nameCardInfo
     * @return NameCardInfo
     */
    NameCardInfo saveNameCardInfo(NameCardInfo nameCardInfo);

    /**
     * @param openId
     * @return ApiResponse
     */
    ApiResponse findNameCardListByOpenId(String openId);

    /**
     * @param openId
     * @return ApiResponse
     */
    ApiResponse findNameCardByOpenId(String openId);
}
