package com.masspick.peak.task;


import com.masspick.peak.common.DataEncrypt;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.model.SMSDto;
import com.masspick.peak.model.dto.etp.EtpBasicDTO;
import com.masspick.peak.service.IEtpFeignApi;
import com.masspick.peak.service.IUserFeignApi;
import com.masspick.peak.service.RoleFeignApi;
import com.masspick.peak.service.SendsmsFeignApi;
import com.masspick.peak.service.dto.SysUserDTO;
import com.masspick.peak.utils.SpringContextHolder;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.flowable.engine.impl.el.FixedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * SmsSendTask
 */
public class SmsSendTask implements ExecutionListener {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsSendTask.class);

    /**
     * userName
     */
    private FixedValue userName;

    /**
     * msgTemplate
     */
    private FixedValue msgTemplate;

    /**
     * params
     */
    private FixedValue params;


    /**
     * Gets userName
     *
     * @return value of userName
     */
    public FixedValue getUserName() {
        return userName;
    }

    /**
     * @param userName userName
     */
    public void setUserName(FixedValue userName) {
        this.userName = userName;
    }

    /**
     * Gets msgTemplate
     *
     * @return value of msgTemplate
     */
    public FixedValue getMsgTemplate() {
        return msgTemplate;
    }

    /**
     * @param msgTemplate msgTemplate
     */
    public void setMsgTemplate(FixedValue msgTemplate) {
        this.msgTemplate = msgTemplate;
    }

    /**
     * Gets params
     *
     * @return value of params
     */
    public FixedValue getParams() {
        return params;
    }

    /**
     * @param params params
     */
    public void setParams(FixedValue params) {
        this.params = params;
    }


    List<SMSDto> getSms(List<SysUserDTO> list, int tempId, ArrayList<String> param) {
        List<SMSDto> smsDtos = new ArrayList<>();
        for (SysUserDTO dto : list) {
            if (StringUtils.isNotBlank(dto.getMobile())) {
                SMSDto smsDto = new SMSDto();
                smsDto.setMobile(dto.getMobile());
                smsDto.setTempId(tempId);
                smsDto.setParams(param);
                smsDtos.add(smsDto);
            }
        }
        return smsDtos;
    }

    /**
     * @param execution
     */
    @Override
    public void notify(DelegateExecution execution) {
        //开启流程后 发起后
        int tempId = DataEncrypt.getTempA();
        ArrayList<String> param = new ArrayList<>();
        List<SMSDto> list = new ArrayList<>();
        Object legalAddress = execution.getVariable("legalAddress");
        Object entName = execution.getVariable("entName");
        Object approvalResult = execution.getVariable("approvalResult");
        Object allowOrNot = execution.getVariable("allowOrNot");
        Object legalPhone = execution.getVariable("legalPhone");
        SendsmsFeignApi providerApi = (SendsmsFeignApi) SpringContextHolder.getBean(SendsmsFeignApi.class);
        RoleFeignApi roleFeignApi = (RoleFeignApi) SpringContextHolder.getBean(RoleFeignApi.class);
        IEtpFeignApi etpFeignApi = (IEtpFeignApi) SpringContextHolder.getBean(IEtpFeignApi.class);
        IUserFeignApi userFeignApi = (IUserFeignApi) SpringContextHolder.getBean(IUserFeignApi.class);

        if (execution.getCurrentActivityId().equals("createTask")) {
            //发送给风控后台人员
            list.addAll(getSmsByRoleName("riskAssistant", param, tempId, roleFeignApi));
        }

        if (execution.getCurrentActivityId().equals("regCreditTask")) {
            //征信  发送给区域经理
            //查询公司对应区域
            if (allowOrNot != null) {
                String creditAllow = allowOrNot.toString();
                if ("reject".equals(creditAllow) && legalPhone != null
                        && StringUtils.isNotBlank(legalPhone.toString())) {
                    param.clear();
                    //发禁止短信
                    tempId = DataEncrypt.getTempB();
                    SMSDto smsDto = new SMSDto();
                    smsDto.setMobile(legalPhone.toString());
                    smsDto.setTempId(tempId);
                    smsDto.setParams(param);
                    list.add(smsDto);
                }

                if ("pass".equals(creditAllow)) {
                    param.clear();
                    tempId = DataEncrypt.getTempC();
                    String province = execution.getVariable("province") == null ? "" : execution.getVariable("province").toString();
                    String city = execution.getVariable("city") == null ? "" : execution.getVariable("city").toString();
                    String area = execution.getVariable("area") == null ? "" : execution.getVariable("area").toString();
                    legalAddress = province + city + area;
                    param.add(legalAddress == null ? "" : legalAddress.toString());

                    list.addAll(getSmsByEntAndRoleName(entName, "regionManager", param, tempId, etpFeignApi, userFeignApi));

                }
            }
        }

        if (execution.getCurrentActivityId().equals("comfirmAppointTask")) { //预约确认
            tempId = DataEncrypt.getTempD();
            list.addAll(getSmsByRoleName("riskAssistant", param, tempId, roleFeignApi));
        }

        if (execution.getCurrentActivityId().equals("riskDecisionTask")) { //风险决策 分区域经理跟客户
            tempId = DataEncrypt.getTempE(); //区域经理对应模板
            //获取企业名称
            param.clear();
            param.add(entName == null ? "" : entName.toString());
            list.addAll(getSmsByEntAndRoleName(entName, "regionManager", param, tempId, etpFeignApi, userFeignApi));

            tempId = DataEncrypt.getTempF(); //业务辅助岗
            param.clear();
            list.addAll(getSmsByRoleName("businessAssistant", param, tempId, roleFeignApi));
        }


        //approveRegisterTask
        if (execution.getCurrentActivityId().equals("approveRegisterTask")) { //审批登记
            //参数
            if (approvalResult != null && approvalResult.toString().equals("reject")) {
                //区域经理
                param.clear();
                tempId = DataEncrypt.getTempG();
                param.add(entName == null ? "" : entName.toString());
                list.addAll(getSmsByEntAndRoleName(entName, "regionManager", param, tempId, etpFeignApi, userFeignApi));

                //客户
                tempId = DataEncrypt.getTempH();
                param.clear();
                param.add(entName == null ? "" : entName.toString());
                if (legalPhone != null && StringUtils.isNotBlank(legalPhone.toString())) {
                    SMSDto smsDto1 = new SMSDto();
                    smsDto1.setMobile(legalPhone.toString());
                    smsDto1.setTempId(tempId);
                    smsDto1.setParams(param);
                    list.add(smsDto1);
                }
            } else if (approvalResult != null && approvalResult.toString().equals("pass")) {
                //区域经理
                param.clear();
                tempId = DataEncrypt.getTempI();
                ArrayList<String> param1 = new ArrayList<>();
                param1.add(entName == null ? "" : entName.toString());
                list.addAll(getSmsByEntAndRoleName(entName, "regionManager", param1, tempId, etpFeignApi, userFeignApi));

                //合规人员
                ArrayList<String> param2 = new ArrayList<>();
                //145381
                tempId = DataEncrypt.getTempJ();
                param2.add("");
                list.addAll(getSmsByRoleName("compliancePersonnel", param2, tempId, roleFeignApi));
            }
        }

        for (SMSDto smsDto : list) {
            try {
                providerApi.sendSMS(smsDto.getMobile(), smsDto.getParams(), smsDto.getTempId());
            } catch (Exception e) {
                LOGGER.error("发送短信失败", e.getCause());
            }
        }
    }

    List<SMSDto> getSmsByRoleName(String roleName, ArrayList<String> param, int tempId, RoleFeignApi roleFeignApi) {
        List<SMSDto> list = new ArrayList<>();
        try {
            List<SysUserDTO> userList = roleFeignApi.findUserListByRoleName(roleName);
            list.addAll(getSms(userList, tempId, param));
        } catch (Exception e) {
            LOGGER.error("获取业务辅助岗人员异常", e.getCause());
            LOGGER.error("发送短信失败");
        }
        return list;
    }

    List<SMSDto> getSmsByEntAndRoleName(Object entName, String roleName, ArrayList<String> param,
                                        int tempId, IEtpFeignApi etpFeignApi, IUserFeignApi userFeignApi) {
        List<SMSDto> list = new ArrayList<>();
        try {
            if (entName != null && StringUtils.isNotBlank(entName.toString())) {
                EtpBasicDTO etpBasicDTO = etpFeignApi.findBasicById(entName.toString());
                if (etpBasicDTO != null) {
                    String etpCity = etpBasicDTO.getCity();
                    if (StringUtils.isNotBlank(etpCity)) {
                        List<SysUserDTO> userDTOS = userFeignApi.findUserByRoleAndAreaName(roleName, etpCity);
                        list.addAll(getSms(userDTOS, tempId, param));
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("获取区域经理人员异常", e.getCause());
            LOGGER.error("发送短信失败");
        }
        return list;
    }


}
