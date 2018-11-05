package com.masspick.peak.dd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.dd.mapper.DueTaskMapper;
import com.masspick.peak.dd.mapper.TemplateMapper;
import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.dd.model.Template;
import com.masspick.peak.dd.service.TaskService;
import com.masspick.peak.dd.util.SpringContextHolder;
import com.masspick.peak.model.Property;
import com.masspick.peak.model.dto.DdTaskDTO;
import com.masspick.peak.service.IDictionaryFeignApi;
import com.masspick.peak.service.IFlowService;
import com.masspick.peak.service.IProductFeignApi;
import com.masspick.peak.service.IRandomFeignApi;
import com.masspick.peak.service.IUserFeignApi;
import com.masspick.peak.service.SendsmsFeignApi;
import com.masspick.peak.service.dto.SysDictionaryDTO;
import com.masspick.peak.service.dto.SysUserDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/5/23 0023.
 */
@Service
public class TaskServiceImpl implements TaskService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);

    /**
     * dueTaskMapper
     */
    @Autowired
    private DueTaskMapper dueTaskMapper;


    /**
     * templateMapper
     */
    @Autowired
    private TemplateMapper templateMapper;

    /**
     * sendsmsFeignApi
     */
    @Autowired
    private SendsmsFeignApi sendsmsFeignApi;

    /**
     * providerApi
     */
    @Resource
    private IUserFeignApi iUserFeignApi;

    /**
     * iDictionaryFeignApi
     */
    @Resource
    private IDictionaryFeignApi iDictionaryFeignApi;

    /**
     * iProductFeignApi
     */
    @Resource
    private IProductFeignApi iProductFeignApi;

    /**
     * iRandomFeignApi
     */
    @Resource
    private IRandomFeignApi iRandomFeignApi;

    /**
     * APP_ID_1
     */
    private static final int APP_ID_1 = 145394;

    /**
     * APP_ID_2
     */
    private static final int APP_ID_2 = 145396;

    /**
     * TIME_LENGTH_14
     */
    private static final int TIME_LENGTH_14 = 14;

    /**
     * 终止任务
     *
     * @return int
     */
    @Override
    public int endTask(DueTask dueTask, String account) throws Exception {

//        List<SysDictionaryDTO> sysDictionaryList = null;
//        try {
//            sysDictionaryList = iDictionaryFeignApi.getDictionaryItem("refusalReason");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String reasonKey = "";
//        for (SysDictionaryDTO sysDictionaryDTO : sysDictionaryList) {
//            if (sysDictionaryDTO.getName().equals(dueTask.getReason())) {
//                reasonKey = sysDictionaryDTO.getCode();
//            }
//        }
//        Map<String, String> map = new HashMap<>();
//        Template template = templateMapper.findById(dueTask.getTemplateId());
//        map.put("userId", account);
//        map.put("action", "complete");
//        map.put("state", "reject");
//        map.put("ddOperator", "reject");
//        map.put("ddRejectReason", StringUtils.isEmpty(reasonKey) ? dueTask.getReason() : reasonKey);
//        map.put("ddRejectDesc", dueTask.getDesc());
//        map.put("completeTime", DateUtils.format(dueTask.getRefuseDate(), "yyyy-MM-dd HH:mm:ss"));
//        map.put("templateName", template.getName());
//        try {
//            IFlowService iFlowService = (IFlowService) SpringContextHolder.getBean(IFlowService.class);
//            String code = iFlowService.completeTask(dueTask.getOutId(), map);
//            if (StringUtils.isEmpty(code) || code.equals("error")) {
//                return 0;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error(e.toString());
//            return 0;
//        }

        //发送短信给客户
        Map<String, Object> customerMap = new HashMap<>();
        customerMap.put("mobile", dueTask.getPhone());
        customerMap.put("appId", APP_ID_1);
        try {
            sendsmsFeignApi.sendSMSToDd(customerMap);
        } catch (Exception e) {
            LOGGER.info("--------> customer send message taskNum = {}  mobile = {} , name = {} <--------", dueTask
                    .getTaskNum(), dueTask.getPhone(), dueTask.getLegalRep());
            e.printStackTrace();
        }

        try {
            //发送短信区域经理
            SysUserDTO manageUser = iUserFeignApi.findByName(dueTask.getManager());
            if (manageUser != null) {
                Map<String, Object> managerMap = new HashMap<>();
                managerMap.put("mobile", manageUser.getMobile());
                managerMap.put("param", dueTask.getCompanyName());
                managerMap.put("appId", APP_ID_2);
                sendsmsFeignApi.sendSMSToDd(managerMap);
            } else {
                LOGGER.info("--------> message is null taskNum = {}  mobile = {} , name = {} <--------", dueTask
                        .getTaskNum(), dueTask.getPhone(), dueTask.getLegalRep());
            }
        } catch (Exception e) {
            LOGGER.info("--------> manager send message taskNum = {}  mobile = {} , name = {} <--------", dueTask
                    .getTaskNum(), dueTask.getPhone(), dueTask.getLegalRep());
            e.printStackTrace();
        }

        return dueTaskMapper.update(dueTask);
    }


    /**
     * 1.0.4 branch需要加上三个属性 从流程中去取
     *
     * @param taskId
     * @return
     */
    @Override
    public DueTask findById(String taskId) {
        DueTask task = dueTaskMapper.findById(taskId);

        Property property = new Property(); //声明流程所取需要参数
        property.setIsAll("notAll");
        List<String> attribute = new ArrayList<>();
        attribute.add("amount");
        attribute.add("term");
        attribute.add("contactor");
        property.setAttribute(attribute);

        try {
            SysUserDTO sysUserDTO = iUserFeignApi.findByName(task.getManager());
            task.setManager(sysUserDTO.getName());
        }catch (Exception e) {
            task.setManager(task.getManager());
        }

        try {
            IFlowService iFlowService = (IFlowService) SpringContextHolder.getBean(IFlowService.class);
            Map<String, String> map = iFlowService.findFlowMapByTaskId(task.getProcessInstanceId(), property);
            if (map != null && !map.isEmpty()) {
                task.setAmount(map.get("amount"));
                task.setTerm(map.get("term"));
                task.setContactor(map.get("contactor"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return task;
    }

    @Override
    public PageInfo<DueTask> pageInfo(Integer pageNum, Integer pageSize, String executorId, Boolean flag) {
        PageHelper.startPage(pageNum, pageSize);
        List<DueTask> dueTaskList = dueTaskMapper.findByExecutorId(executorId, flag);
        return new PageInfo(dueTaskList);
    }

    @Override
    public int saveTask(DdTaskDTO taskDTO) throws Exception {
        DueTask dueTask = new DueTask();
        dueTask.setOutId(taskDTO.getOutId());
        dueTask.setCompanyName(taskDTO.getCompanyName());
        dueTask.setCompanyId(taskDTO.getCompanyId());
        dueTask.setCompanyType(taskDTO.getCompanyType());
        dueTask.setName(taskDTO.getName());
        dueTask.setProvince(taskDTO.getProvince());
        dueTask.setCity(taskDTO.getCity());
        dueTask.setArea(taskDTO.getArea());
        dueTask.setAddress(taskDTO.getAddress());
        dueTask.setManager(taskDTO.getManager());
        dueTask.setLegalRep(taskDTO.getLegalRep());
        dueTask.setPhone(taskDTO.getPhone());
        dueTask.setAppointmentDate(taskDTO.getAppointmentDate());
        dueTask.setProcessInstanceId(taskDTO.getProcessInstanceId());
        dueTask.setProductId(taskDTO.getProductId());
        dueTask.setProductName(iProductFeignApi.findById(taskDTO.getProductId()).getName());
        String taskNum = "dd" + iRandomFeignApi.getRandom();
        dueTask.setTaskNum(taskNum);
        dueTask.setId(SequenceUtils.getUUID());
        dueTask.setReceiveDate(new Date());
        dueTask.setState(DueTask.TO_START);
        dueTask.setCreateTime(new Date());

        //获取区域经理名称
        SysUserDTO sysUserDTO = iUserFeignApi.findByName(taskDTO.getManager());
        dueTask.setManagerName(sysUserDTO == null ? "" : sysUserDTO.getName());

        return dueTaskMapper.insert(dueTask);
    }
}
