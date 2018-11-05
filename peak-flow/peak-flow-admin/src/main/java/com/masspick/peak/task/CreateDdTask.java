package com.masspick.peak.task;


import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.model.dto.DdTaskDTO;
import com.masspick.peak.service.DdTaskFeignApi;
import com.masspick.peak.utils.SpringContextHolder;
import org.flowable.engine.HistoryService;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.engine.history.HistoricDetail;
import org.flowable.engine.history.HistoricFormProperty;
import org.flowable.task.service.delegate.DelegateTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 尽职调查监听
 */
public class CreateDdTask implements TaskListener {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateDdTask.class);

    /**
     * historyService
     */
    @Autowired
    private HistoryService historyService;

    /**
     * @param delegateTask
     */
    @Override
    public void notify(DelegateTask delegateTask) {

        if (historyService == null) {
            historyService = (HistoryService) SpringContextHolder.getBean(HistoryService.class);
        }
        //
        String proInsId = delegateTask.getProcessInstanceId(); //存在processInsId
        DdTaskDTO dto = new DdTaskDTO();
        dto.setName(delegateTask.getEventName());
        dto.setOutId(delegateTask.getId());
        dto.setProcessInstanceId(proInsId);

        String appointTime = delegateTask.getVariable("appointTime") == null ? "" : delegateTask.getVariable("appointTime").toString();
        String contactAddress = delegateTask.getVariable("contactAddress") == null ? "" : delegateTask.getVariable("contactAddress").toString();
        String contactPhone = delegateTask.getVariable("contactPhone") == null ? "" : delegateTask.getVariable("contactPhone").toString();
        String userName = delegateTask.getVariable("userId") == null ? "" : delegateTask.getVariable("userId").toString();
        dto.setManager(userName);
        dto.setAddress(StringUtils.isEmpty(contactAddress) ? "" : contactAddress);
        List<HistoricDetail> details = historyService.createNativeHistoricDetailQuery()
                .sql("SELECT * FROM ACT_HI_DETAIL T WHERE T.PROC_INST_ID_ = #{processInstanceId} AND T.TYPE_= 'FormProperty'")
                .parameter("processInstanceId", proInsId).list();

        for (HistoricDetail detail : details) {
            HistoricFormProperty field = (HistoricFormProperty) detail;
            //确定开始是FormProperty
            String property = field.getPropertyId();
            String value = field.getPropertyValue();
            if ("entName".equals(property)) {
                dto.setCompanyName(value);
            }

            if ("legalRep".equals(property)) {
                dto.setLegalRep(value);
            }

            if ("legalPhone".equals(property)) {
                dto.setPhone(value);
            }

            if ("province".equals(property)) {
                dto.setProvince(value);
            }

            if ("city".equals(property)) {
                dto.setCity(value);
            }

            if ("area".equals(property)) {
                dto.setArea(value);
            }

            if ("customerType".equals(property)) {
                dto.setCompanyType(value);
            }

            if ("productId".equals(property)) {
                dto.setProductId(value);
            }
        }


        if (!StringUtils.isEmpty(appointTime)) {
            dto.setAppointmentDate(DateUtils.parseDateByPattern(appointTime, "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNoneBlank(contactPhone)) {
            dto.setPhone(contactPhone);
        }

        //获取taskId
        DdTaskFeignApi object = (DdTaskFeignApi) SpringContextHolder.getBean(DdTaskFeignApi.class);

        try {
            object.createDueTask(dto);
        } catch (Exception e) {
            LOGGER.error("添加尽调信息失败!", e.getCause());
        }
        System.out.println("尽职调查监听要干嘛？");
    }
}
