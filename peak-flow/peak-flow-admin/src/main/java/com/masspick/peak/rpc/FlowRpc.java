package com.masspick.peak.rpc;

import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.mapper.ActDeModelMapper;
import com.masspick.peak.model.Property;
import com.masspick.peak.service.FlowService;
import com.masspick.peak.service.IFlowService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.history.HistoricDetail;
import org.flowable.engine.history.HistoricFormProperty;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.api.history.HistoricTaskInstanceQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FlowRpc
 */
@RestController
public class FlowRpc implements IFlowService {

    /**
     * flowService
     */
    @Autowired
    private FlowService flowService;

    /**
     * runtimeService
     */
    @Autowired
    private RuntimeService runtimeService;

    /**
     * historyService
     */
    @Autowired
    private HistoryService historyService;

    /**
     *  actDeModelMapper
     */
    @Autowired
    private ActDeModelMapper actDeModelMapper;

    @Transactional
    @Override
    public String startProcess(@RequestBody Map<String, String> map) throws Exception {
        return flowService.startProcess(map);
    }

    @Transactional
    @Override
    public String completeTask(@PathVariable("taskId") String taskId, @RequestBody Map<String, String> map) throws Exception {
        return flowService.completeTask(taskId, map);
    }


    /**
     * @param processInstanceId 流程 进行中  完成 总结
     * @return
     */
    @Override
    public Map<String, String> taskbyProInsId(@PathVariable("processInstanceId") String processInstanceId) {
        Map<String, String> map = new HashMap<>();
        List<HistoricDetail> details = historyService.createHistoricDetailQuery().processInstanceId(processInstanceId).list();
        for (HistoricDetail detail : details) {
            HistoricFormProperty field = (HistoricFormProperty) detail;
            //确定开始是FormProperty
            String property = field.getPropertyId();
            String value = field.getPropertyValue();
            map.put(property, value);
        }

        return map;
    }

    /**
     * 通过taskId查询流程节点所填参数
     *
     * @param processInstanceId
     * @return Map
     * @throws Exception
     */
    @Override
    public Map<String, String> findFlowMapByTaskId(@PathVariable("processInstanceId") String processInstanceId,
                                                   @RequestBody Property property) throws Exception {
        Map<String, String> map = new HashMap<>();
        List<HistoricDetail> details = historyService.createHistoricDetailQuery().processInstanceId(processInstanceId).list();

        for (HistoricDetail detail : details) {
            if (detail instanceof HistoricFormProperty) {
                // 表单中的字段
                HistoricFormProperty field = (HistoricFormProperty) detail;
                //不暴露过多参数
                String key = field.getPropertyId();
                String value = field.getPropertyValue();
                String isAll = property.getIsAll();
                if (!StringUtils.isEmpty(isAll) && "all".equals(isAll)) {
                    //查询所有
                    map.put(key, value);
                } else {
                    //查询固定字段值
                    List<String> attribute = property.getAttribute();
                    if (!CollectionUtils.isEmpty(attribute) && attribute.contains(key)) {
                        for (String str : attribute) {
                            if (str.equals(key)) {
                                map.put(key, value);
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    /**
     * 对应参数找寻对应taskId
     *
     * @return String
     * @throws Exception Exception
     */
    @Override
    public String findTaskIdByParam(@PathVariable("no") String no,
                                    @PathVariable("actId") String actId) throws Exception {

        HistoricTaskInstanceQuery histTaskQuery = historyService.createHistoricTaskInstanceQuery()
                .processVariableValueEquals("projectNumber", no);
        if (histTaskQuery != null) {
            List<HistoricTaskInstance> taskInstances = histTaskQuery.list();
            if (!CollectionUtils.isEmpty(taskInstances)) {
                //no是唯一值
                for (HistoricTaskInstance taskInstance : taskInstances) {
                    if (taskInstance.getFormKey().equals(actId) && taskInstance.getEndTime() == null) {
                        //存在推送 并且未完成
                        return taskInstance.getId();
                    }
                }
            }
        }


        return "";
    }

    /**
     *
     * @param key 表单key
     * @return String
     * @throws Exception
     */
    @Override
    public String findFormByKey(@PathVariable("key") String key) throws Exception {
        return actDeModelMapper.getByKey(key).getModelEditorJson();
    }
}
