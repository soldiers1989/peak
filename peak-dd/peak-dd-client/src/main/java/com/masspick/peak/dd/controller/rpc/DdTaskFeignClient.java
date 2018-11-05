package com.masspick.peak.dd.controller.rpc;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.dd.mapper.DueDilDataMapper;
import com.masspick.peak.dd.mapper.DueTaskMapper;
import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.dd.model.bo.DueDilDataBO;
import com.masspick.peak.dd.service.TaskService;
import com.masspick.peak.model.dto.DdDataControlDTO;
import com.masspick.peak.model.dto.DdDataDTO;
import com.masspick.peak.model.dto.DdTaskDTO;
import com.masspick.peak.service.DdTaskFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/6/20 0020.
 */
@RestController
public class DdTaskFeignClient implements DdTaskFeignApi {

    /**
     * taskService
     */
    @Autowired
    private TaskService taskService;

    /**
     * dueDilDataMapper
     */
    @Autowired
    private DueDilDataMapper dueDilDataMapper;

    /**
     * dueTaskMapper
     */
    @Autowired
    private DueTaskMapper dueTaskMapper;

    /**
     * branch 1.2.0 修改
     * @param ddTaskDTO
     * @return Integer
     * @throws Exception Exception
     */
    @Override
    public Integer createDueTask(@RequestBody DdTaskDTO ddTaskDTO) throws Exception {
        return taskService.saveTask(ddTaskDTO);
    }

    /**
     * @param processId
     * @return Map<String, Object>
     * @throws Exception Exception
     */
    @Override
    public Map<String, Object> ddData(@PathVariable("processId") String processId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        DueTask dueTask = dueTaskMapper.findByProcessId(processId);
        if (dueTask == null) {
            return null;
        }
        DdDataDTO ddDataDTO = JacksonUtils.copyProperties(dueTask, DdDataDTO.class);
        List<Map<String, Object>> mapList = dueDilDataMapper.groupByGroupSeq(dueTask.getId(), dueTask.getTemplateId());
        List<DueDilDataBO> boList = dueDilDataMapper.findTaskBO(dueTask.getId());
        List<DdDataControlDTO> ddDataControlDTOS = new ArrayList<>();
        for (DueDilDataBO dueDilDataBO : boList) {
            ddDataControlDTOS.add(JacksonUtils.copyProperties(dueDilDataBO, DdDataControlDTO.class));
        }
        map.put("task", ddDataDTO);
        map.put("group", mapList);
        map.put("data", ddDataControlDTOS);
        return map;
    }
}
