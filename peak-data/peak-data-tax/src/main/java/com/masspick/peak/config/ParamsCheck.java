package com.masspick.peak.config;


import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.model.dto.tax.TaxRequestDTO;

/**
 * 参数校验
 */
public class ParamsCheck {

    /**
     * @param dto
     * @return String
     */
    public static String checkTaxParams(TaxRequestDTO dto) {
        if (dto == null) {
            return "请求对象不能为空";
        }
        if (StringUtils.isEmpty(dto.getCname())) {
            return "纳税人名称不能为空";
        }
        if (StringUtils.isEmpty(dto.getTaxNo())) {
            return "纳税人识别号不能为空";
        }
        if (StringUtils.isEmpty(dto.getAreaCode())) {
            return "纳税人所属行政区划不能为空";
        }
        if (StringUtils.isEmpty(dto.getLegalName())) {
            return "企业法定代表人姓名不能为空";
        }
        if (StringUtils.isEmpty(dto.getLegalIdCard())) {
            return "企业法定代表人证件号码不能为空";
        }
        if (StringUtils.isEmpty(dto.getMobile())) {
            return "企业法定代表人手机号码不能为空";
        }
        if (StringUtils.isEmpty(dto.getStartDate())) {
            return "查询时间起期不能为空";
        }
        if (StringUtils.isEmpty(dto.getEndDate())) {
            return "查询时间止期不能为空";
        }
        return "success";
    }
}
