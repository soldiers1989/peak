package com.masspick.peak.guest.service.impl;

import com.masspick.peak.common.util.StringHelper;
import com.masspick.peak.guest.common.constant.CommonConstant;
import com.masspick.peak.guest.common.email.DocumentHandler;
import com.masspick.peak.guest.common.email.MailUtil;
import com.masspick.peak.guest.common.upload.FileConfig;
import com.masspick.peak.guest.controller.vo.BaseVo;
import com.masspick.peak.guest.mapper.EtpCerMapper;
import com.masspick.peak.guest.mapper.InfoAuthMapper;
import com.masspick.peak.guest.model.EtpCer;
import com.masspick.peak.guest.model.InfoAuth;
import com.masspick.peak.guest.service.IInfoAuthService;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 信息采集授权
 */
@Service
public class InfoAuthServiceImpl implements IInfoAuthService {

    /**
     * InfoAuthMapper
     */
    @Autowired
    private InfoAuthMapper infoAuthMapper;

    /**
     * fileConfig
     */
    @Autowired
    private FileConfig fileConfig;

    /**
     * etpCerMapper
     */
    @Autowired
    private EtpCerMapper etpCerMapper;

    /**
     * 发送邮件
     * @param baseVo baseVo
     * @return ApiResponse
     */
    @Override
    public ApiResponse sendEmail(BaseVo baseVo) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        //合同确认后 生成文件
        String email = baseVo.getString("email");
        String type = baseVo.getString("type");
        String no = baseVo.getString("infoAuthNum");

        if (StringHelper.isEmpty(email)) {
            return apiResponse.error("400").setReason("发送邮箱为空");
        }

        if (StringHelper.isEmpty(type)) {
            return apiResponse.error("400").setReason("缺少发送邮件类型");
        }

        Boolean b = Boolean.FALSE;
        if (type.equals("contract")) {
            try {
                DocumentHandler mdoc = new DocumentHandler();
                String path = fileConfig.getTempFilePath();
                String contractAttUrl = path + File.separator + no + "contract.doc";
                mdoc.createDocArea(null, contractAttUrl, "contract.ftl");
                b = MailUtil.send(email, contractAttUrl);
                if (!b.booleanValue()) {
                    return apiResponse.error("400").setReason("发送邮件失败");
                }
            } catch (Exception e) {
                return apiResponse.error("400").setReason("发送邮件失败");
            }
        } else if (type.equals("auth")) {
            if (StringHelper.isEmpty(no)) {
                return apiResponse.error("400").setReason("授权书编号为空");
            }
            Map<String, Object> authMap = new HashMap<>();
            authMap.put("no", no);
            Calendar cal = Calendar.getInstance();
            int year = cal.get(cal.YEAR);
            authMap.put("year", year);
            int month = cal.get(cal.MONTH) + 1;
            authMap.put("month", month);
            int day = cal.get(cal.DATE);
            authMap.put("day", day);

            Map<String, Object> creditMap = new HashMap<>();
            creditMap.put("no", String.valueOf(no));
            creditMap.put("year", String.valueOf(year));
            creditMap.put("month", String.valueOf(month));
            creditMap.put("day", String.valueOf(day));

            try {
                DocumentHandler mdoc = new DocumentHandler();
                //发送合同文件 生成
                String path = fileConfig.getTempFilePath();
                String etpAttUrl = path + File.separator + no + "etpAuth.doc";
                String controllerAttUrl = path + File.separator + no + "controllerCredit.doc";
                mdoc.createDocArea(authMap, etpAttUrl, "etpAuth.ftl");
                mdoc.createDocArea(creditMap, controllerAttUrl, "controllerCredit.ftl");
                b = MailUtil.send(email, etpAttUrl, controllerAttUrl);
                if (!b.booleanValue()) {
                    return apiResponse.error("400").setReason("发送邮件失败");
                }
            } catch (Exception e) {
                return apiResponse.error("400").setReason("生成合同失败");
            }
        }
        return apiResponse.success().setResult(b.booleanValue());
    }

    /**
     *  添加信息采集授权信息
     * @param infoAuth 信息采集授权
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @Override
    @Transactional
    public ApiResponse addInfoAuth(InfoAuth infoAuth, BindingResult bindingResult) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        //1.校验参数必填
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        //2.信息采集授权必须是企业资质认证通过的企业
        EtpCer etpCer = etpCerMapper.findById(infoAuth.getEtpCerId());
        if (etpCer == null) {
            return apiResponse.error("401").setReason("该公司未进行企业资质认证，无法提交信息采集授权！");
        }
        if (!CommonConstant.PASSED_CER_STATUS.equals(etpCer.getStatus())) {
            return apiResponse.error("401").setReason("该公司未企业资质认证未通过，无法提交信息采集授权！");
        }

        //3.添加信息采集授权信息
        infoAuth.preInsert();
        infoAuthMapper.insert(infoAuth);
        return apiResponse.success().setResult(infoAuthMapper.findById(infoAuth.getId()));
    }

    /**
     *  通过企业资质认证id查询信息采集授权
     * @param etpCerId 企业资质认证id
     * @return ApiResponse
     */
    @Override
    public ApiResponse findInfoAuthByEtpCerId(String etpCerId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        return apiResponse.success().setResult(infoAuthMapper.findByEtpCerId(etpCerId));
    }
}
