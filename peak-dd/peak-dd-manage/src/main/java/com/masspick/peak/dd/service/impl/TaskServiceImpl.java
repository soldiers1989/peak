package com.masspick.peak.dd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.dd.config.SystemConfig;
import com.masspick.peak.dd.dto.SysUserDTO;
import com.masspick.peak.dd.mapper.DueDilDataMapper;
import com.masspick.peak.dd.mapper.DueTaskMapper;
import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.dd.model.bo.DueDilDataBO;
import com.masspick.peak.dd.model.bo.DueTaskBO;
import com.masspick.peak.dd.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/5/18 0018.
 */
@Service
public class TaskServiceImpl implements TaskService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);

    /**
     * systemConfig
     */
    @Autowired
    private SystemConfig systemConfig;

    /**
     * dueTaskMapper
     */
    @Autowired
    private DueTaskMapper dueTaskMapper;

    /**
     * dueDilDataMapper
     */
    @Autowired
    private DueDilDataMapper dueDilDataMapper;

    /**
     * APP_ID_142791
     */
    public static final int APP_ID_165771 = 165771;

    /**
     * APP_ID_142788
     */
    public static final int APP_ID_142788 = 142788;


    /**
     * @param page
     * @param rows
     * @param state
     * @param taskNum
     * @return PageInfo
     */
    @Override
    public PageInfo dataGrid(Integer page, Integer rows, Integer state, String taskNum) {

        PageHelper.startPage(page - 1, rows);
        if (!StringUtils.isEmpty(taskNum)) {
            taskNum = "%" + taskNum.replace("%", "\\%") + "%";
        }
        List<DueTaskBO> dueTaskList = dueTaskMapper.dataGrid(state, taskNum);
        return new PageInfo(dueTaskList);
    }

    /**
     * @param id
     * @return DueTaskBO
     */
    @Override
    public DueTaskBO findByTaskBO(String id) {
        return dueTaskMapper.findByTaskBO(id);
    }

    /**
     * @param dueTask
     * @return int
     */
    @Transactional
    @Override
    public int update(DueTask dueTask) {

        int i = dueTaskMapper.update(dueTask);
        DueTask dbDueTask = dueTaskMapper.findById(dueTask.getId());
        String url = systemConfig.getZuulUrl() + "/peak-resource/v1/resource/users/";
        RestTemplate restTemplate = new RestTemplate();

        //区域经理
        ResponseEntity<SysUserDTO> mangerResponseEntity = restTemplate.getForEntity(url + dbDueTask.getManager(),
                SysUserDTO.class);
        SysUserDTO mangerUser = mangerResponseEntity.getBody();

        //尽调员
        ResponseEntity<SysUserDTO> executorResponseEntity = restTemplate.getForEntity(url + dbDueTask.getExecutor(),
                SysUserDTO.class);
        SysUserDTO executorUser = executorResponseEntity.getBody();


        String smsUrl = systemConfig.getZuulUrl() + "/interface/api/interface/dd/send";
        //String smsUrl = "http://192.168.111.216:7900/api/interface/dd/send";
        Map<String, Object> managerMap = new HashMap<>();
        managerMap.put("mobile", mangerUser.getMobile());
        managerMap.put("param", executorUser.getAccount());
        managerMap.put("appId", APP_ID_165771);

        try {

            restTemplate.postForEntity(smsUrl, managerMap, Object.class);
        } catch (Exception e) {
            LOGGER.info("--------> manager mobile = {} , name = {} <--------", mangerUser.getMobile(), mangerUser
                    .getAccount());
            e.printStackTrace();
        }
        Map<String, Object> executorMap = new HashMap<>();
        executorMap.put("mobile", executorUser.getMobile());
        executorMap.put("param", mangerUser.getAccount());
        executorMap.put("appId", APP_ID_142788);
        try {
            restTemplate.postForEntity(smsUrl, executorMap, Object.class);
        } catch (Exception e) {
            LOGGER.info("--------> executor mobile = {} , name = {} <--------", executorUser.getMobile(), executorUser
                    .getAccount());
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Map<String, Object> data(String processId) {
        Map<String, Object> map = new HashMap<>();
        DueTask dueTask = dueTaskMapper.findByProcessId(processId);
        List<Map<String, Object>> mapList = dueDilDataMapper.groupByGroupSeq(dueTask.getId(), dueTask
                .getTemplateId());
        List<DueDilDataBO> boList = dueDilDataMapper.findTaskBO(dueTask.getId());
        map.put("group", mapList);
        map.put("data", boList);
        map.put("task", dueTask);
        return map;
    }
}
