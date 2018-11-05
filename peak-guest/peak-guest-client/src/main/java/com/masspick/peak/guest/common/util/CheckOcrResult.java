package com.masspick.peak.guest.common.util;

import com.masspick.peak.common.util.StringHelper;
import com.masspick.peak.guest.model.BusLicenseCer;
import com.masspick.peak.guest.model.IdMobileCer;
import com.masspick.peak.guest.model.NameCardInfo;

/**
 *  OCR识别结果校验
 */
public class CheckOcrResult {
    /**
     * 校验名片识别必要信息
     * @param nameCardInfo 名片信息
     * @return boolean
     */
    public static boolean checkNameCardInfo(NameCardInfo nameCardInfo) {
        if (nameCardInfo == null) {
            return false;
        }
        if (StringHelper.isEmpty(nameCardInfo.getEtpName())) {
            return false;
        }
        if (StringHelper.isEmpty(nameCardInfo.getLegalName())) {
            return false;
        }
        return  true;
    }

    /**
     *  校验营业执照毕业信息
     * @param busLicenseCer 营业执照信息
     * @return boolean
     */
    public static boolean checkBusInfo(BusLicenseCer busLicenseCer) {
        if (busLicenseCer == null) {
            return false;
        }
        if (StringHelper.isEmpty(busLicenseCer.getEtpName())) {
            return false;
        }
        if (StringHelper.isEmpty(busLicenseCer.getLegalName())) {
            return false;
        }
        if (StringHelper.isEmpty(busLicenseCer.getCreditCode())) {
            return false;
        }
        return true;
    }

    /**
     * 校验身份证必要信息
     * @param idMobileCer 身份证信息
     * @return boolean
     */
    public static boolean checkIdInfo(IdMobileCer idMobileCer, Integer side) {

        if (idMobileCer == null) {
            return false;
        }

        if (side == 0) {
            if (StringHelper.isEmpty(idMobileCer.getName())) {
                return false;
            }
            if (StringHelper.isEmpty(idMobileCer.getBirth())) {
                return false;
            }
            if (StringHelper.isEmpty(idMobileCer.getAddress())) {
                return false;
            }
            if (StringHelper.isEmpty(idMobileCer.getIdCode())) {
                return false;
            }
            if (StringHelper.isEmpty(idMobileCer.getNation())) {
                return false;
            }
            if (StringHelper.isEmpty(idMobileCer.getSex())) {
                return false;
            }
        }

        if (side == 1) {
            if (StringHelper.isEmpty(idMobileCer.getIssuingAgency())) {
                return false;
            }
            if (StringHelper.isEmpty(idMobileCer.getValidityPeriod())) {
                return false;
            }
        }
        return true;
    }
}
