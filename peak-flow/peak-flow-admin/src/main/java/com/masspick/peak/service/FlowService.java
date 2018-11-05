package com.masspick.peak.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.masspick.peak.model.TodoAdd;
import com.masspick.peak.common.*;
import com.masspick.peak.common.mvel.MvelUtil;
import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.diagram.HMProcessDiagramGenerator;
import com.masspick.peak.model.*;
import com.masspick.peak.model.dto.ApiResponse;
import com.masspick.peak.model.dto.DdDataControlDTO;
import com.masspick.peak.model.dto.WhiteListEtpDto;
import com.masspick.peak.model.dto.WhiteListEtpFindBo;
import com.masspick.peak.service.dto.SysDictionaryDTO;
import com.masspick.peak.service.dto.SysProductInterestDTO;
import com.masspick.peak.service.dto.SysProductServiceDTO;
import com.masspick.peak.service.ext.ActGroupEntityService;
import com.masspick.peak.service.ext.ActUserEntityService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.*;
import org.flowable.engine.form.TaskFormData;
import org.flowable.engine.history.*;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.identitylink.api.history.HistoricIdentityLink;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.api.history.HistoricTaskInstanceQuery;
import org.flowable.variable.api.history.HistoricVariableInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.Key;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * FlowService
 */
@Service
public class FlowService {
    /**
     * runtimeService
     */
    @Autowired
    private RuntimeService runtimeService;

    /**
     * taskService
     */
    @Autowired
    private TaskService taskService;

    /**
     * repositoryService
     */
    @Autowired
    private RepositoryService repositoryService;

    /**
     * identityService
     */
    @Autowired
    private IdentityService identityService;

    /**
     * actGroupEntityService
     */
    @Autowired
    private ActGroupEntityService actGroupEntityService;

    /**
     * actUserEntityService
     */
    @Autowired
    private ActUserEntityService actUserEntityService;

    /**
     * formService
     */
    @Autowired
    private FormService formService;

    /**
     * historyService
     */
    @Autowired
    private HistoryService historyService;

    /**
     * actDeModelService
     */
    @Autowired
    private ActDeModelService actDeModelService;


    /**
     * cosPathConfig
     */
    @Autowired
    private CosPathConfig cosPathConfig;

    /**
     * decisionFeignApi
     */
    @Resource
    private DecisionFeignApi decisionFeignApi;

    /**
     * cosClient
     */
    @Autowired
    private COSClient cosClient;

    /**
     * ddTaskFeignApi
     */
    @Resource
    private DdTaskFeignApi ddTaskFeignApi;


    /**
     * IProductFeignApi
     */
    @Resource
    private IProductFeignApi productFeignApi;

    /**
     * CREDITTASKACTID
     */
    private static final String CREDITTASKACTID = "regCreditTask";

    /**
     * DDTASKACTID
     */
    private static final String DDTASKACTID = "ddTask";

    /**
     * AUTOBIDTASK
     */
    private static final String AUTOBIDTASK = "autoBidTask";

    /**
     * COMPLIANCETASK
     */
    private static final String COMPLIANCETASK = "complianceTask";


    /**
     * PRODUCTNAME
     */
    private static final String PRODUCTNAME = "productName";

    /**
     * PERCENT
     */
    private static final int PERCENT = 100;

    /**
     * deploy
     */
    @Transactional
    public void deploy() {
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("processes/companyCard.bpmn20.xml")
                .deploy();

        /*部署流程定义*/
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();
        System.out.println("Found process definition : " + processDefinition.getName());
    }

    /**
     * 根据传不同的productId来识别开启不同的流程
     *8
     * @param map
     * @return String
     * @throws Exception 异常
     */
    @Transactional
    public String startProcess(Map<String, String> map) throws Exception {
        if (map == null || map.isEmpty()) {
            throw new Exception("再无任何参数值的情况下不能发起流程!");
        }

        //根据所传productName去识别某个流程
        if (map.get(PRODUCTNAME) != null) {
            String key = "";
            identityService.setAuthenticatedUserId(map.get("userId"));

            if (map.get(PRODUCTNAME).equals(FlowEnum.COMPANY_FLOW.getType())) {
                key = FlowEnum.COMPANY_FLOW.getValue();
            } else if (map.get(PRODUCTNAME).equals(FlowEnum.TAXCREDIT_FLOW.getType())) {
                key = FlowEnum.TAXCREDIT_FLOW.getValue();
            }


            List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery()
                    .processDefinitionKey(key).latestVersion().list();

            for (ProcessDefinition processDefinition : processDefinitionList) {
                System.out.println(processDefinition.getId());
            }

            //传过来直接map
            //防止接口调用 实体类 时常改变
            ProcessInstance processInstance = formService.submitStartFormData(processDefinitionList.get(0).getId(), map);
            return processInstance.getProcessInstanceId();
        }

        return "";

    }

    /**
     * 平台执行任务接口
     *
     * @param taskId
     * @param map
     * @return String
     * @throws Exception 异常
     */
    public String completeTaskAdmin(String taskId, Map<String, Object> map) throws Exception {
        String result = "error";
        HistoricTaskInstance taskInstance = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
        if (taskInstance == null) {
            throw new Exception("未找到相应的任务节点");
        }

        if (StringUtils.isEmpty(map.get("action"))) {
            throw new Exception("签收还是执行?傻傻分不清楚!");
        }

        Map<String, String> vars = Maps.newHashMap();
        map.forEach((key, value) -> {
            if (value != null) {
                if ("self".equals(key) || "etp".equals(key)) {
                    vars.put(key, JSONObject.toJSONString(value));
                } else {
                    vars.put(key, value.toString());
                }
            }
        });

        if ("complete".equals(vars.get("action"))) {
            taskService.setAssignee(taskId, vars.get("userId"));
            formService.submitTaskFormData(taskId, vars);
            result = "true";
        } else if ("claim".equals(vars.get("action"))) {
            taskService.claim(taskId, vars.get("userId")); //签收即可
            result = "true";
        }

        return result;
    }


    /**
     * @param taskId
     * @param map
     * @return String
     * @throws Exception 异常
     */
    @Transactional
    public String completeTask(String taskId, Map<String, String> map) throws Exception {
        String result = "error";
        HistoricTaskInstance taskInstance = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
        if (taskInstance == null) {
            throw new Exception("未找到相应的任务节点");
        }

        if (StringUtils.isEmpty(map.get("action"))) {
            throw new Exception("签收还是执行?傻傻分不清楚!");
        }

        if ("complete".equals(map.get("action"))) {
            taskService.setAssignee(taskId, map.get("userId"));
            formService.submitTaskFormData(taskId, map);
            result = "true";
        } else if ("claim".equals(map.get("action"))) {
            taskService.claim(taskId, map.get("userId")); //签收即可
            result = "true";
        }
        return result;
    }


    /**
     * 分不同流程的待办任务
     *
     * @param userName
     * @return List
     * @throws Exception 异常
     */
    public List<Todo> findTaskTodoListByUserName(String userName, String productName) throws Exception {
        List<Todo> list = new ArrayList<>();

        List<Task> tasks = new ArrayList<>();

        if (productName.equals("QK")) {
            productName = "企业信用卡";
        } else if (productName.equals("ZXD")) {
            productName = "征信贷";
        }

        //签收了的
        TaskQuery todoTaskQuery = taskService.createTaskQuery()
                .processVariableValueEquals("productName", productName)
                .taskAssignee(userName).active()
                .includeProcessVariables().orderByTaskCreateTime().desc();
        List<Task> todoList = todoTaskQuery.list();
        tasks.addAll(todoList);

        // =============== 等待具体用户签收的任务 ===============
        TaskQuery toClaimQuery = taskService.createTaskQuery()
                .processVariableValueEquals("productName", productName)
                .taskCandidateUser(userName)
                .includeProcessVariables().active().orderByTaskCreateTime().desc();
        List<Task> toClaimList = toClaimQuery.list();
        tasks.addAll(toClaimList);

        // 查询当前用户所在角色
        List<String> groups = actGroupEntityService.findGroupStringByUser(userName);
        if (!CollectionUtils.isEmpty(groups)) {
            TaskQuery toGroupQuery = taskService.createTaskQuery()
                    .processVariableValueEquals("productName", productName)
                    .taskCandidateGroupIn(groups)
                    .includeProcessVariables().orderByTaskCreateTime().desc();
            List<Task> toGroupList = toGroupQuery.list();
            tasks.addAll(toGroupList);
        }

        for (Task t : tasks) {
            TodoAdd todo = new TodoAdd();
            todo.setTaskId(t.getId());
            todo.setProcessInsId(t.getProcessInstanceId());
            todo.setAssignee(t.getAssignee()); //查出是否有签收人
            //操作人 可以是具体的人也可以是某个角色
            List<HistoricIdentityLink> links = historyService.getHistoricIdentityLinksForTask(t.getId());
            if (!CollectionUtils.isEmpty(links)) {
                HistoricIdentityLink link = links.get(0); //任务ID可以确定唯一一个身份数据信息
                String userId = link.getUserId();
                String groupId = link.getGroupId();
                if (StringUtils.isEmpty(userId)) {
                    //通过角色ID查询角色名称
                    todo.setOperatorName(groupId);
                } else {
                    todo.setOperatorName(userId); //userId
                }
            }

            HistoricActivityInstance activityInstance = historyService.createHistoricActivityInstanceQuery()
                    .activityId(t.getTaskDefinitionKey())
                    .processInstanceId(t.getProcessInstanceId()).unfinished().singleResult();
            if (activityInstance != null) {
                todo.setActInsId(activityInstance.getId());
                todo.setActName(activityInstance.getActivityName());
                todo.setCreatTime(activityInstance.getStartTime());
                //查询开始流程的参数列表
                List<HistoricDetail> details = historyService.createHistoricDetailQuery()
                        .processInstanceId(t.getProcessInstanceId()).taskId(null).list();
                String province = "";
                String city = "";
                String area = "";
                if (!CollectionUtils.isEmpty(details)) {
                    for (HistoricDetail detail : details) {
                        HistoricFormProperty field = (HistoricFormProperty) detail;
                        //确定开始是FormProperty
                        String property = field.getPropertyId();
                        String value = field.getPropertyValue();
                        if ("entName".equals(property)) {
                            todo.setEntName(value);
                        }

                        if ("amount".equals(property)) {
                            todo.setAmount(BigDecimal.valueOf(Double.parseDouble(value)));
                        }

                        if ("no".equals(property)) {
                            todo.setNo(value);
                        }

                        if ("projectNumber".equals(property)) {
                            todo.setProjectNumber(value);
                        }


                        if ("productName".equals(property)) {
                            todo.setProductName(value);
                        }

                        if ("province".equals(property)) {
                            province = value;
                        }

                        if ("city".equals(property)) {
                            city = value;
                        }

                        if ("area".equals(property)) {
                            area = value;
                        }

                        if ("insStaffName".equals(property)) {
                            todo.setInsStaffName(value);
                        }

                        if ("insName".equals(property)) {
                            todo.setInsName(value);
                        }
                        if ("address".equals(property)) {
                            todo.setAddress(value);
                        }

                    }

                    String scope = StringUtils.isEmpty(province) ? "" : province + (StringUtils.isEmpty(city) ? "" : "-" + city)
                            + (StringUtils.isEmpty(area) ? "" : "-" + area);

                    todo.setScope(StringUtils.isEmpty(scope) ? "" : scope);
                }
            }
            list.add(todo);
        }
        return list;
    }


    /**
     * @param proInsId
     * @return String
     * @throws IOException 异常
     */
    @Transactional
    public String proMap(String proInsId) throws IOException {
        //从processInst中去取
        HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(proInsId).singleResult();
        if (processInstance != null) {
            //得到流程执行对象
            BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
            List<Execution> executions = runtimeService.createExecutionQuery()
                    .processInstanceId(proInsId).list();
            List<String> activityIds = new ArrayList<>();
            for (Execution exe : executions) {
                List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
                activityIds.addAll(ids);
            }
            //生成文件名每次不一样即可
            //  fileName = UUID.randomUUID().toString() + ".png";
            //ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
            List<String> highLightedFlows = new ArrayList<>();

            InputStream in = new HMProcessDiagramGenerator()
                    .generateDiagram(bpmnModel, "png", activityIds, highLightedFlows,
                            "宋体", "宋体", "宋体", null, 1.0);
            String uuid = SequenceUtils.getUUID();
            String key = cosPathConfig.getCosDir() + uuid + ".png";
            ObjectMetadata objectMetadata = new ObjectMetadata();
            byte[] byt = new byte[in.available()];
            objectMetadata.setContentLength(byt.length);
            PutObjectRequest putObjectRequest = new PutObjectRequest(cosPathConfig.getCosBucketName(),
                    key, in, objectMetadata);
            try {
                cosClient.putObject(putObjectRequest);
                return cosPathConfig.getCosUrl() + "/" + key;
            } catch (Exception e) {
                return "上传图片失败";
            } finally {
                cosClient.shutdown();
            }

        }
        return "";
    }


    /**
     * 基础信息
     *
     * @param processInstanceId
     * @return Map
     */
    public Map<String, String> basic(String processInstanceId) {
        Map<String, String> result = Maps.newHashMap();
        List<HistoricActivityInstance> activityInstances = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId(processInstanceId).orderByHistoricActivityInstanceStartTime().asc().list();
        if (!CollectionUtils.isEmpty(activityInstances)) {
            List<HistoricDetail> details = historyService.createHistoricDetailQuery().processInstanceId(processInstanceId).list();
            if (!CollectionUtils.isEmpty(details)) {
                for (HistoricDetail detail : details) {
                    if (detail instanceof HistoricFormProperty) {
                        // 表单中的字段
                        HistoricFormProperty field = (HistoricFormProperty) detail;
                        result.put(field.getPropertyId(), field.getPropertyValue());
                    } else if (detail instanceof HistoricVariableUpdate) {
                        HistoricVariableUpdate variable = (HistoricVariableUpdate) detail;
                        result.put(variable.getVariableName(), variable.getValue().toString());
                    }
                }
            }


            result.put("ddTask", "ufinish");
            result.put("register", "unfinish");

            //传征信拆解taskId
            for (HistoricActivityInstance activityInstance : activityInstances) {

                if (activityInstance.getActivityId().equals(CREDITTASKACTID)) {
                    result.put("creditTaskId", activityInstance.getTaskId());
                    result.put("assignee", activityInstance.getAssignee());
                    result.put("status", "未完成");
                    if (activityInstance.getEndTime() != null) {
                        result.put("status", "已完成");
                    }
                }

                //判断是否完成了尽调
                if (activityInstance.getActivityId().equals(DDTASKACTID) && activityInstance.getEndTime() != null) {
                    result.put("ddTask", "finish");
                }

                //判断是否融资登记
                if (activityInstance.getActivityId().equals(AUTOBIDTASK) || activityInstance.getActivityId().equals(COMPLIANCETASK)) {
                    result.put("register", "finish");
                }

            }
        }

        return result;
    }


    /**
     * @param taskId
     * @return TaskJson
     * @throws Exception 异常
     */
    public TaskJson findFormPropertiesByTaskId(String taskId) throws Exception {
        TaskJson taskJson = new TaskJson();
        String result = "";
        JSONObject object = null;
        TaskFormData formData = formService.getTaskFormData(taskId);
        if (formData != null) {
            String formKey = formData.getFormKey();
            ActDeModel model = actDeModelService.getByKey(formKey);
            if (model != null) {
                result = model.getModelEditorJson();
                object = JSONObject.parseObject(result);
                //对应的下拉选项需要加上
                //分别列出来
                //String loanAmount = taskService.getVariables()
                HistoricTaskInstance taskInstance = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
                String processInstaceId = taskInstance.getProcessInstanceId();
                Map<String, String> map = basic(processInstaceId);
                JSONArray array = object.getJSONArray("fields");
                for (int i = 0; i < array.size(); i++) {
                    JSONObject o = array.getJSONObject(i);
                    //之前节点有值的话  需要自动添加上去
                    String id = o.getString("id");
                    String value = map.get(id);
                    o.put("value", value);
                    //option
                    String optionsExpression = o.getString("optionsExpression");
                    if (!StringUtils.isEmpty(optionsExpression)) {
                        optionsExpression = optionsExpression.replace("${", "")
                                .replace("}", "");
                        List<SysDictionaryDTO> dicts = actUserEntityService.findDictByType(optionsExpression);
                        List<TaskDict> taskDicts = new ArrayList<>();
                        for (SysDictionaryDTO dict : dicts) {
                            TaskDict taskDict = new TaskDict();
                            taskDict.setName(dict.getName());
                            taskDict.setType(dict.getParentCode());
                            taskDict.setValue(dict.getCode());
                            taskDicts.add(taskDict);
                        }
                        if (!CollectionUtils.isEmpty(taskDicts)) {
                            o.put("options", taskDicts);
                        }
                    }
                }
                taskJson.setJsonObject(object);
            }

            //是否被签收
            Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
            if (StringUtils.isEmpty(task.getAssignee())) {
                taskJson.setClaim(Boolean.FALSE);
            } else {
                taskJson.setClaim(Boolean.TRUE);
            }
        }
        return taskJson;
    }


    /**
     * 已办任务列表
     *
     * @param page
     * @param assignee
     * @param etpName
     * @param createStartDate
     * @param createEndDate
     * @return Page
     * @throws ParseException 异常
     */
    public Page<Todo> historicTaskByAssignee(Page<Todo> page, String assignee,
                                             String etpName, String createStartDate,
                                             String createEndDate, String productName) throws ParseException {
        List<Todo> list = new ArrayList<>();

        if (productName.equals("QK")) {
            productName = "企业信用卡";
        } else if (productName.equals("ZXD")) {
            productName = "征信贷";
        }

        HistoricTaskInstanceQuery histTaskQuery = historyService.createHistoricTaskInstanceQuery()
                .processVariableValueEquals("productName", productName)
                .includeProcessVariables()
                .orderByHistoricTaskInstanceEndTime().desc();


        if (!StringUtils.isEmpty(assignee)) {
            histTaskQuery = histTaskQuery.taskAssignee(assignee).finished();
        }

        if (!StringUtils.isEmpty(etpName)) {
            histTaskQuery = histTaskQuery.finished()
                    .processVariableValueLike("entName", "%" + etpName + "%");
        }

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        if (!StringUtils.isEmpty(createStartDate)) {
            histTaskQuery = histTaskQuery.finished()
                    .taskCreatedAfter(sf.parse(createStartDate + " 00:00:00"));
        }

        if (!StringUtils.isEmpty(createEndDate)) {
            histTaskQuery = histTaskQuery.finished()
                    .taskCreatedBefore(sf.parse(createEndDate + " 23:59:59"));
        }


        page.setCount(histTaskQuery.count());
        List<HistoricTaskInstance> taskInstances = histTaskQuery.listPage(page.getFirstResult(), page.getMaxResults());

        int maxFlow = 0;

        if (FlowEnum.COMPANY_FLOW.getType().equals(productName)) {
            maxFlow = FlowDto.MAX_FLOW;
        } else if (FlowEnum.TAXCREDIT_FLOW.getType().equals(productName)) {
            maxFlow = FlowDto.TAX_MAX_FLOW;
        }


        if (!CollectionUtils.isEmpty(taskInstances)) {
            for (HistoricTaskInstance taskInstance : taskInstances) {
                Todo todo = new Todo();
                todo.setTaskId(taskInstance.getId());
                todo.setProcessInsId(taskInstance.getProcessInstanceId());
                todo.setCreatTime(taskInstance.getStartTime());
                todo.setEndTime(taskInstance.getEndTime());
                HistoricActivityInstance activityInstance = historyService.
                        createHistoricActivityInstanceQuery().
                        processInstanceId(taskInstance.getProcessInstanceId()).
                        activityId(taskInstance.getTaskDefinitionKey()).finished().singleResult();
                if (activityInstance != null) {
                    todo.setActInsId(activityInstance.getId());
                }

                //查询开始流程的参数列表
                List<HistoricDetail> details = historyService.createHistoricDetailQuery().
                        processInstanceId(taskInstance.getProcessInstanceId()).
                        taskId(null).list();
                if (!CollectionUtils.isEmpty(details)) {
                    for (HistoricDetail detail : details) {
                        HistoricFormProperty field = (HistoricFormProperty) detail;
                        String property = field.getPropertyId();
                        String value = field.getPropertyValue();

                        if ("amount".equals(property)) {
                            todo.setAmount(BigDecimal.valueOf(Double.parseDouble(value)));
                        }

                        if ("entName".equals(property)) {
                            todo.setEntName(value);
                        }

                        if ("productName".equals(property)) {
                            todo.setProductName(value);
                        }
                        if ("projectNumber".equals(property)) {
                            todo.setProjectNumber(value);
                        }
                    }
                }

                ProcessInstance rpi = runtimeService
                        .createProcessInstanceQuery()//创建流程实例查询对象
                        .processInstanceId(taskInstance.getProcessInstanceId())
                        .singleResult();

                List<HistoricActivityInstance> activityInstances = historyService.createHistoricActivityInstanceQuery()
                        .processInstanceId(taskInstance.getProcessInstanceId()).activityType(FlowDto.ACT_TYPE_USER_TASK).finished().list();
                int size = activityInstances.size();

                List<HistoricActivityInstance> activityInstancesUnfinished = historyService.createHistoricActivityInstanceQuery()
                        .processInstanceId(taskInstance.getProcessInstanceId()).activityType(FlowDto.ACT_TYPE_USER_TASK).unfinished().list();

                if (rpi == null) {
                    todo.setActName("已完成");
                    //完成
                    if (size < maxFlow) { //提前结束
                        todo.setActName("终止");
                    }

                    todo.setProgress("100%");
                } else { //未完成
                    //目前执行了多少条userTask
                    StringBuffer name = new StringBuffer("");
                    for (HistoricActivityInstance historicActivityInstance : activityInstancesUnfinished) {
                        name.append(historicActivityInstance.getActivityName() + "+");
                    }
                    todo.setActName(name.toString().substring(0, name.toString().lastIndexOf("+")));
                    NumberFormat numberFormat = NumberFormat.getInstance();
                    // 设置精确到小数点后2位
                    numberFormat.setMaximumFractionDigits(2);
                    String result = numberFormat.format((float) size / (float) maxFlow * PERCENT);
                    todo.setProgress(result + "%");
                }

                list.add(todo);
            }
        }
        page.setList(list);
        return page;
    }


    /**
     * 已办任务节点列表
     *
     * @param processInsId
     * @return List
     */
    public List<TaskDetail> historicTaskDetail(String processInsId) {
        List<TaskDetail> list = new ArrayList<>();
        List<HistoricActivityInstance> activityInstances = historyService.createHistoricActivityInstanceQuery()
                .orderByHistoricActivityInstanceStartTime().asc()
                .processInstanceId(processInsId).list();
        for (HistoricActivityInstance instance : activityInstances) {
            if (!StringUtils.isEmpty(instance.getTaskId())) {
                TaskDetail detail = new TaskDetail();
                detail.setActName(instance.getActivityName());
                detail.setTaskId(instance.getTaskId());
                detail.setAssignee(instance.getAssignee());
                detail.setCreateTime(instance.getStartTime());
                detail.setEndTime(instance.getEndTime());
                detail.setProcessInsId(instance.getProcessInstanceId());
                if (instance.getEndTime() == null) {
                    detail.setStatus("进行中");
                } else {
                    detail.setStatus("完成");
                }
                list.add(detail);
            }
        }
        return list;
    }


    /**
     * 详细列表中查看具体数据
     * 1.2.0中征信贷部分节点需要叠加处理
     *
     * @param taskId
     * @return JSONObject
     * @throws Exception 异常
     */
    public JSONArray findHistoricForm(String taskId) throws Exception {
        //需要先解析Form表单中的JSON 然后JSON拼接返回数据
        JSONArray jsonArray = new JSONArray();
        String str = "";
        HistoricTaskInstance taskInstance = historyService.createHistoricTaskInstanceQuery()
                .taskId(taskId).singleResult();
        if (taskInstance != null) {
            String processInstanceId = taskInstance.getProcessInstanceId();
            List<HistoricActivityInstance> historicActivityInstances = historyService.createHistoricActivityInstanceQuery()
                    .processInstanceId(processInstanceId).activityType(FlowDto.ACT_TYPE_USER_TASK).finished().list();
            //任务列表
            for (HistoricActivityInstance activityInstance : historicActivityInstances) {
                String actAaskId = activityInstance.getTaskId();
                String actName = activityInstance.getActivityName();
                if (!"征信拆解".equals(actName)) {
                    //征信吃拆解不在json数据中暂时
                    HistoricTaskInstance actTaskInstance = historyService.createHistoricTaskInstanceQuery()
                            .taskId(actAaskId).singleResult();
                    if (actTaskInstance != null) {
                        String formKey = actTaskInstance.getFormKey();
                        List<HistoricDetail> details = historyService.createHistoricDetailQuery().taskId(actAaskId).list();
                        ActDeModel model = actDeModelService.getByKey(formKey);
                        if (model != null && !StringUtils.isEmpty(model.getModelEditorJson())) {
                            str = model.getModelEditorJson();
                            JSONObject modelObject = JSONObject.parseObject(str);
                            for (HistoricDetail detail : details) {
                                HistoricFormProperty field = (HistoricFormProperty) detail;
                                String property = field.getPropertyId(); // 对应JSON ID
                                String value = field.getPropertyValue(); // value   key值
                                JSONArray array = modelObject.getJSONArray("fields");
                                for (int i = 0; i < array.size(); i++) {
                                    JSONObject object = array.getJSONObject(i);
                                    if (object.getString("id").equals(property)) {
                                        //对存在optionsExpression值的特殊处理一下即可
                                        object.put("value", value);
                                        String optionsExpression = object.getString("optionsExpression");
                                        if (!StringUtils.isEmpty(optionsExpression)) {
                                            optionsExpression = optionsExpression.replace("${", "")
                                                    .replace("}", ""); //type值
                                            String dictName = actUserEntityService.findDictNameByTypeAndKey(optionsExpression, value);
                                            object.put("value", dictName);
                                        }
                                    }
                                }
                            }
                            jsonArray.add(modelObject);
                            //jsonObject.put(actName, modelObject);
                        }
                    }
                }
            }
            JSONObject object = new JSONObject();
            if (taskInstance.getEndTime() == null) { //未完成
                object.put("status", "进行中");
            } else { //已完成
                object.put("status", "完成");
            }

            object.put("assignee", taskInstance.getAssignee());
            object.put("currentActName", taskInstance.getName());
            jsonArray.add(object);
        }
        return jsonArray;
    }


    /**
     * @param userName
     * @return Boolean
     * @throws Exception 异常
     */
    public Boolean rolesByName(String userName) throws Exception {
        Boolean result = Boolean.FALSE;
        List<String> roles = actGroupEntityService.findGroupStringByUser(userName);
        if (roles.contains(FlowDto.FINANC)) {
            //包含风控后台人员
            return Boolean.TRUE;
        }

        return result;
    }


    /**
     * 导出报告
     *
     * @param processInstanceId
     * @return Map
     * @throws IllegalAccessException 异常
     */
    public Map<String, Object> exportMapByTaskId(String processInstanceId) throws IllegalAccessException {
        Map<String, Object> map = Maps.newHashMap();
        List<HistoricDetail> list = historyService.createHistoricDetailQuery().processInstanceId(processInstanceId).list();
        String entName = "";
        String province = "";
        String city = "";
        String area = "";
        for (HistoricDetail detail : list) {
            if (detail instanceof HistoricFormProperty) {
                // 表单中的字段
                HistoricFormProperty field = (HistoricFormProperty) detail;
                map.put(field.getPropertyId(), field.getPropertyValue());
                if (field.getPropertyId().equals("entName")) {
                    entName = field.getPropertyValue();
                }

                if (field.getPropertyId().equals("province")) {
                    province = field.getPropertyValue();
                }

                if (field.getPropertyId().equals("city")) {
                    city = field.getPropertyValue();
                }

                if (field.getPropertyId().equals("area")) {
                    area = field.getPropertyValue();
                }

            }
        }

        String region = StringUtils.isEmpty(province) ? "" : province + (StringUtils.isEmpty(city) ? "" : "-" + city)
                + (StringUtils.isEmpty(area) ? "" : "-" + area);
        map.put("region", StringUtils.isEmpty(region) ? "" : region);
        // 调用其他数据接口 放入map中
        WhiteListEtpFindBo bo = new WhiteListEtpFindBo();
        bo.setEtpName(entName);
        WhiteListEtpDto dto = decisionFeignApi.findWhiteList(bo);
        if (dto != null) {
            Class cls = dto.getClass();
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                map.put(f.getName(), f.get(dto));
            }
        }

        //报告时间
        map.put("reportTime", DateUtils.format(new Date(), DateUtils.YEARHOURDAY_FORMAT));

        return map;
    }


    /**
     * 导出尽调报告
     *
     * @param processInstanceId
     * @return Map
     * @throws Exception 异常
     */
    public Map<String, Object> exportdDMapByProId(String processInstanceId) throws Exception {
        Map<String, Object> map = Maps.newHashMap();
        String province = "";
        String city = "";
        String area = "";
        List<HistoricDetail> list = historyService.createHistoricDetailQuery().processInstanceId(processInstanceId).list();
        for (HistoricDetail detail : list) {
            if (detail instanceof HistoricFormProperty) {
                // 表单中的字段
                HistoricFormProperty field = (HistoricFormProperty) detail;
                map.put(field.getPropertyId(), field.getPropertyValue());

                if (field.getPropertyId().equals("province")) {
                    province = field.getPropertyValue();
                }

                if (field.getPropertyId().equals("city")) {
                    city = field.getPropertyValue();
                }

                if (field.getPropertyId().equals("area")) {
                    area = field.getPropertyValue();
                }

            }
        }
        String region = StringUtils.isEmpty(province) ? "" : province + (StringUtils.isEmpty(city) ? "" : "-" + city)
                + (StringUtils.isEmpty(area) ? "" : "-" + area);
        map.put("region", StringUtils.isEmpty(region) ? "" : region);
        Map<String, Object> ddMap = ddTaskFeignApi.ddData(processInstanceId);
        if (ddMap != null && !ddMap.isEmpty()) {
            for (String key : ddMap.keySet()) {
                if (key.equals("data")) {
                    List<LinkedHashMap<String, String>> ddDataControlDTOS = (List<LinkedHashMap<String, String>>) ddMap.get(key);
                    for (LinkedHashMap<String, String> link : ddDataControlDTOS) {
                        map.put(link.get("controlKey"), link.get("value"));

                        //敏感手机号
                        String label = link.get("label");
                        if (!StringUtils.isEmpty(label) && (label.contains("手机号") || label.contains("联系方式") || label.contains("号码"))) {
                            map.put(link.get("controlKey"), DataEncrypt.mobileEncrypt(link.get("value")));
                        }
                    }
                }
            }
        }
        return map;
    }

    /**
     * 流程中找到贷款详细信息
     * @param flowId flowId
     * @return ApiResponse
     */
    public ApiResponse findLoanDetailByFlowId(String flowId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        //查询开始流程的参数列表
        List<HistoricDetail> details = historyService.createHistoricDetailQuery().
                processInstanceId(flowId).list();
        Map<String, String> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(details)) {
            for (HistoricDetail detail : details) {
                HistoricFormProperty field = (HistoricFormProperty) detail;
                String property = field.getPropertyId();
                String value = field.getPropertyValue();

                //对数据做脱敏处理
                // 财务联系人 姓名和电话未进行脱敏处理
                if(property.equals("financialContact")){
                    value = DataEncrypt.nameEncrypt(value);
                }

                if(property.equals("contactMobile")){
                    value = DataEncrypt.mobileEncrypt(value);
                }

                map.put(property, value);
            }
        }

        //flow
        List<HistoricActivityInstance> actList = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId(flowId).orderByHistoricActivityInstanceStartTime().asc().list();
        for (HistoricActivityInstance activityInstance : actList) {
            String actId = activityInstance.getActivityId();
            if (actId.equals("createTask")) {
                map.put("handleTime", DateUtils.format(activityInstance.getStartTime()));
            }
            if (actId.equals("stop")) {
                map.put("stopTime", DateUtils.format(activityInstance.getStartTime()));
            }

            if (actId.equals("finish")) {
                map.put("finshTime", DateUtils.format(activityInstance.getStartTime()));
            }


        }

        //居间费率 贷款利率
        String loanAmount = map.get("loanAmount");
        String loanTerm = map.get("loanTerm");
        String productId = map.get("productId");
        Map<String, Object> borrowRateMap = new HashMap<>();
        borrowRateMap.put("Month", loanTerm);
        borrowRateMap.put("Amount", loanAmount);
        if(!StringUtils.isEmpty(loanAmount) && !StringUtils.isEmpty(loanTerm)){
            Map<String, String> rateMap = findBorrowRate(productId, borrowRateMap);
            if (rateMap != null && !rateMap.isEmpty()) {
                String borrowRate = rateMap.get("interestRate");
                String commissionRate = rateMap.get("serviceRate");
                map.put("borrowRate",borrowRate);
                map.put("commissionRate",commissionRate);
            }
        }

        return apiResponse.success().setResult(map);
    }


    /**
     * 查找利率
     *
     * @param productId
     * @param data
     * @return Map
     */
    public Map<String, String> findBorrowRate(String productId, Map<String, Object> data) {
        Map<String, String> map = new HashMap<>();
        try {
            MvelUtil mvelUtil = new MvelUtil();
            List<SysProductInterestDTO> interestDTOList = productFeignApi.findId(productId).getProductInterestDTOS();
            List<SysProductServiceDTO> serviceDTOList = productFeignApi.findId(productId).getProductServiceDTOS();
            SysProductInterestDTO sysProductInterestDTO = mvelUtil.match(interestDTOList, data);
            if (sysProductInterestDTO != null) {
                map.put("interestRate", sysProductInterestDTO.getRate());
            }
            SysProductServiceDTO sysProductServiceDTO = mvelUtil.match(serviceDTOList, data);
            if (sysProductServiceDTO != null) {
                map.put("serviceRate", sysProductServiceDTO.getRate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 统计已办任务、待办任务、订单总数、申请总金额、居间费金额
     *
     * @param interfacestate
     * @param assignee
     * @param createStartDate
     * @param createEndDate
     * @param productName
     * @return List<HistoricTaskInstance> list
     * @throws Exception ParseException
     */
    public JSONObject historicTaskByAssigneeList(int interfacestate, String assignee, String createStartDate, String createEndDate, String productName) throws Exception {
        if (productName.equals("QK")) {
            productName = "企业信用卡";
        } else if (productName.equals("ZXD")) {
            productName = "征信贷";
        }
        if (interfacestate == 0) {
            //查询已办任务
            HistoricTaskInstanceQuery histTaskQuery = historyService.createHistoricTaskInstanceQuery()
//                    .processVariableValueEquals("productName", productName)
                    .includeProcessVariables()
                    .orderByHistoricTaskInstanceEndTime().desc();

            int alreadyNum = 0;
            int waitNum = 0;
        /*当前登录用户的待办任务数目*/
            alreadyNum = histTaskQuery.taskAssignee(assignee).finished().list().size();
            // =============== 当前登录用户的待办任务数目 ===============
            waitNum = taskService.createTaskQuery()
//                    .processVariableValueEquals("productName", productName)
                    .taskAssignee(assignee).active()
                    .includeProcessVariables().orderByTaskCreateTime().desc().list().size();
            //等待具体用户签收的任务
            waitNum = waitNum + taskService.createTaskQuery()
//                    .processVariableValueEquals("productName", productName)
                    .taskCandidateUser(assignee)
                    .includeProcessVariables().active().orderByTaskCreateTime().desc().list().size();

            // 查询当前用户所在角色
            List<String> groups = actGroupEntityService.findGroupStringByUser(assignee);
            if (!CollectionUtils.isEmpty(groups)) {
                waitNum = waitNum + taskService.createTaskQuery()
//                        .processVariableValueEquals("productName", productName)
                        .taskCandidateGroupIn(groups)
                        .includeProcessVariables().orderByTaskCreateTime().desc().list().size();
            }
            //=====================================================
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("already", alreadyNum);
            jsonObject.put("waiting", waitNum);
            return jsonObject;
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");

        List<Map> list = new ArrayList<>();
        int sumOrder = 0;
        HistoricProcessInstanceQuery finishedActivity = historyService.createHistoricProcessInstanceQuery()
                .finished();
        List<HistoricProcessInstance> list1 = finishedActivity.list();
        if (interfacestate == 3) { //居间费处理
            BigDecimal sumConsumeAmount = new BigDecimal(0);
            for (HistoricProcessInstance processInstance : list1) {
                BigDecimal consumeAmount = new BigDecimal(0);
                Date starttime = processInstance.getStartTime();
                List<HistoricVariableInstance> variable = historyService.createHistoricVariableInstanceQuery().
                        processInstanceId(processInstance.getId()).list();
                Map borrowRateMap = new HashMap();
                String productId = null;
                String loanAmount = null;
                if (!CollectionUtils.isEmpty(variable)) {
                    for (HistoricVariableInstance hv : variable) {
                        String property = hv.getVariableName();
                        String value = (String) hv.getValue();
                        if ("amount".equals(property)) {
                            loanAmount = value;
                            borrowRateMap.put("Amount", value);
                        }
                        if ("term".equals(property)) {
                            borrowRateMap.put("Month", value);
                        }
                        if ("productId".equals(property)) {
                            productId = value;
                        }
                    }
                    Map<String, String> rateMap = findBorrowRate(productId, borrowRateMap);
                    if (rateMap != null && !rateMap.isEmpty()) {
                        String borrowRate = rateMap.get("interestRate");
                        String commissionRate = rateMap.get("serviceRate");
                        //应收居间费
                        BigDecimal commRate = BigDecimal.valueOf(Double.valueOf(commissionRate));
                        BigDecimal amounts = BigDecimal.valueOf(Double.valueOf(loanAmount));
                        consumeAmount = (amounts.multiply(commRate)).divide(BigDecimal.valueOf(PERCENT));
                    }
                }
                if (starttime.after(sf.parse(createStartDate + " 00:00:00")) && starttime.before(sf.parse(createEndDate + " 23:59:59"))) {
                    Map map = new HashMap();
                    map.put("consumeAmount", consumeAmount);
                    map.put("time", sf2.format(starttime));
                    list.add(map);
                }
                sumConsumeAmount = sumConsumeAmount.add(consumeAmount);
            }
            return com.masspick.peak.utils.DateUtils.orderConsumeAmountUtils(list, sumConsumeAmount);
        }
        if (interfacestate == 1) { //订单数
            HistoricProcessInstanceQuery unfinishedActivity = historyService.createHistoricProcessInstanceQuery()
                    .unfinished();
            sumOrder = sumOrder + (unfinishedActivity.list().size() + finishedActivity.list().size());
            list1.addAll(unfinishedActivity.list());
            if (list1 != null && list1.size() > 0) {
                for (HistoricProcessInstance processInstance : list1) {
                    Date starttime = processInstance.getStartTime();
                    if (starttime.after(sf.parse(createStartDate + " 00:00:00")) && starttime.before(sf.parse(createEndDate + " 23:59:59"))) {
                        Map map = new HashMap();
                        map.put("time", sf2.format(starttime));
                        list.add(map);
                    }
                }
            }
            return com.masspick.peak.utils.DateUtils.orderSumUtils(list, sumOrder);
        }
        if (interfacestate == 2) { //订单金额
            HistoricProcessInstanceQuery unfinishedActivity = historyService.createHistoricProcessInstanceQuery()
                    .unfinished();
            list1.addAll(unfinishedActivity.list());
            BigDecimal sumAmount = new BigDecimal(0);
            if (list1 != null && list1.size() > 0) {
                for (HistoricProcessInstance processInstance : list1) {
                    BigDecimal amount = new BigDecimal(0);
                    Date starttime = processInstance.getStartTime();
                    List<HistoricDetail> details = historyService.createHistoricDetailQuery()
                            .processInstanceId(processInstance.getId()).taskId(null).list();
                    if (!CollectionUtils.isEmpty(details)) {
                        for (HistoricDetail detail : details) {
                            HistoricFormProperty field = (HistoricFormProperty) detail;
                            String property = field.getPropertyId();
                            String value = field.getPropertyValue();
                            if ("amount".equals(property)) {
                                amount = BigDecimal.valueOf(Double.parseDouble(value));
                                sumAmount = sumAmount.add(amount);
                            }
                        }
                        if (starttime.after(sf.parse(createStartDate + " 00:00:00")) && starttime.before(sf.parse(createEndDate + " 23:59:59"))) {
                            Map map = new HashMap();
                            map.put("time", sf2.format(starttime));
                            map.put("amount", amount);
                            list.add(map);
                        }
                    }
                }
            }
            return com.masspick.peak.utils.DateUtils.orderAmountUtils(list, sumAmount);
        }
        return null;
    }

    /**
     * 获取三大报告字段数据
     *
     * @return list
     * @throws Exception ex
     */
    public List<Map> fieldInfo() throws Exception {
        List<Map> list = productFeignApi.findField();
        return list;
    }

    /**
     * 获取三大报告模板数据
     *
     * @return Map
     * @throws Exception ex
     */
    public String fieldTemplate(String templateId) throws Exception {
        String str = productFeignApi.findFieldTemplate(templateId);
        return str;
    }

    /**
     * 获取进件数据信息
     *
     * @param processInstanceid pro
     * @return map
     * @throws Exception ss
     */
    public Map intoData(String processInstanceid) throws Exception {
        List<HistoricDetail> details = historyService.createHistoricDetailQuery()
                .processInstanceId(processInstanceid).taskId(null).list();
        Map map = new HashMap();
        if (!CollectionUtils.isEmpty(details)) {
            for (HistoricDetail detail : details) {
                HistoricFormProperty field = (HistoricFormProperty) detail;
                //确定开始是FormProperty
                String property = field.getPropertyId();
                String value = field.getPropertyValue();
                if (property.equals("creditConformRequest")) {
                    switch (value) {
                        case "conform":
                            value = "符合";
                            break;
                        case "notConform":
                            value = "不符合";
                            break;
                        default:
                            break;
                    }

                }
                if (property.equals("infoConformRequest")) {
                    switch (value) {
                        case "conform":
                            value = "符合";
                            break;
                        case "notConform":
                            value = "不符合";
                            break;
                        default:
                            break;
                    }
                }
                if (property.equals("dateConformRequest")) {
                    switch (value) {
                        case "conform":
                            value = "符合";
                            break;
                        case "notConform":
                            value = "不符合";
                            break;
                        default:
                            break;
                    }
                }
                if (property.equals("dueDiligenceProposal")) {
                    switch (value) {
                        case "yes":
                            value = "是";
                            break;
                        case "no":
                            value = "否";
                            break;
                        default:
                            break;
                    }
                }
                map.put(property, value);
            }
        }
        return map;
    }

    /**
     * 获取尽调数据并处理
     *
     * @param processId
     * @return map
     * @throws Exception ex
     */
    public Map<String, Object> taskData(String processId) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> map = ddTaskFeignApi.ddData(processId);
        List<DdDataControlDTO> listddc = new ArrayList<>();
        if (map != null) {
            if (map.containsKey("task")) {
                resultMap = (Map<String, Object>) map.get("task");
            }
            if (map.containsKey("data")) {
                listddc = (List<DdDataControlDTO>) map.get("data");
                if (listddc != null && listddc.size() > 0) {
                    for (Object obj : listddc) {
                        DdDataControlDTO ds = JacksonUtils.copyProperties(obj, DdDataControlDTO.class);
                        String key = ds.getControlKey();
                        String value = ds.getValue();
                        resultMap.put(key, value);
                    }
                }
            }
        }
        return resultMap;
    }

    /**
     * 获取流程数据并处理
     *
     * @param processId
     * @return map
     * @throws Exception ex
     */
    public Map<String, Object> processData(String processId) throws Exception {
        String taskid = null;
        List<HistoricTaskInstance> s = historyService.createHistoricTaskInstanceQuery()
                .processInstanceId(processId).taskDefinitionKey("syntheticalApprove").list();
        for (HistoricTaskInstance taskInstance:s) {
            taskid = taskInstance.getId();
        }
        Map<String, Object> map = new HashMap<>();
        List<HistoricDetail> detailQuery = historyService.createHistoricDetailQuery().taskId(taskid).list();
        for (HistoricDetail historicDetail : detailQuery) {
            HistoricFormProperty field = (HistoricFormProperty) historicDetail;
            //确定开始是FormProperty
            String property = field.getPropertyId();
            String value = field.getPropertyValue();
            if (property.equals("loanTerm")) {
                map.put("finalLoanTerm", value);
            }
            if (property.equals("loanAmount")) {
                map.put("finalLoanAmount", value);
            }
            if (property.equals("guarantMode")) {
                switch (value) {
                    case "theFirstGuarante":
                        value = "I类担保";
                        break;
                    case "theSecondGuarante":
                        value = "II类担保";
                        break;
                    case "theThirdGuarante":
                        value = "III类担保";
                        break;
                    case "theForthGuarante":
                        value = "IV类担保";
                        break;
                    default:
                        break;
                }
                map.put("finalGuarantMode", value);
            }
            if (property.equals("ratingResult")) {
                switch (value) {
                    case "firstRank":
                        value = "一级";
                        break;
                    case "secondRank":
                        value = "二级";
                        break;
                    case "thirdRank":
                        value = "三级";
                        break;
                    case "forthRank":
                        value = "四级";
                        break;
                    case "fifthRank":
                        value = "五级";
                        break;
                    default:
                        break;
                }
                map.put("ratingResult", value);
            }
        }
        return map;
    }
}
