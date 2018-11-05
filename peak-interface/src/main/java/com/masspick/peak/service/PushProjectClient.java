package com.masspick.peak.service;

import com.alibaba.fastjson.JSONObject;
import com.masspick.peak.common.util.HttpRequestUtils;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.config.PushConfig;
import com.masspick.peak.model.dto.ApiResponse;
import com.masspick.peak.model.dto.BorrowProjectBean;
import com.masspick.peak.utils.DESUtils;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * PushProjectClient
 */
@RestController
public class PushProjectClient implements PushProjectApi {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PushProjectClient.class);

    /**
     * PushConfig
     */
    @Autowired
    private PushConfig pushConfig;

    /**
     * IFlowService
     */
    @Autowired
    private IFlowService flowService;

    /**
     * pushProject
     *
     * @param borrowProjectBean
     * @return ApiResponse
     */
    @Override
    public ApiResponse pushProject(@RequestBody BorrowProjectBean borrowProjectBean) throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();
        String name = "pushProject";
        if (borrowProjectBean != null) {
            String jsonObject = JSONObject.toJSONString(borrowProjectBean);
            try {
                String data = DESUtils.encryptToString(jsonObject, pushConfig.getDesKey());
                Map<String, String> map = new HashMap<>();
                map.put("name", name);
                map.put("data", data);
                HttpEntity entity = HttpRequestUtils.requestPost(pushConfig.getPushUrl(), map);
                return apiResponse.success().setReason(EntityUtils.toString(entity));
            } catch (Exception e) {
                return apiResponse.error("400").setErrmsg("加密异常");
            }
        }

        return apiResponse.error("401").setErrmsg("参数为空");
    }

    /**
     * 查询还款计划
     *
     * @param borrowProjectId
     * @param borrowId
     * @return
     */
    @Override
    public ApiResponse borrowRepayDetail(@RequestParam("borrowProjectId") String borrowProjectId,
                                         @RequestParam("borrowId") String borrowId) throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();
        String name = "borrowRepayDetail";
        Map<String, String> param = new HashMap<>();
        param.put("borrowProjectId", borrowProjectId);
        param.put("borrowId", borrowId);
        String jsonObject = JSONObject.toJSONString(param);
        try {
            String data = DESUtils.encryptToString(jsonObject, pushConfig.getDesKey());
            Map<String, String> map = new HashMap<>();
            map.put("name", name);
            map.put("data", data);
            HttpEntity entity = HttpRequestUtils.requestPost(pushConfig.getPushUrl(), map);
            //返回回来的数据是通过机密处理的
            String message = EntityUtils.toString(entity);
            JSONObject json = JSONObject.parseObject(message);
            String result = DESUtils.decryptToString(json.getString("borrowRepay"), pushConfig.getDesKey());
            return apiResponse.success().setResult(result);
        } catch (Exception e) {
            return apiResponse.error("400").setErrmsg("加密异常");
        }
    }

    /**
     * 对外执行流程任务接口
     *
     * @return ApiResponse
     * @throws Exception
     */
    @Override
    public ApiResponse completeTask(@RequestBody Map<String, String> map) throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();

        try {
            String data = map.get("data");
            String message = DESUtils.decryptToString(data, pushConfig.getDesKey());
            JSONObject json = JSONObject.parseObject(message);
            String borrowProjectId = json.getString("borrowProjectId");
            String borrowId = json.getString("borrowId");
            String borrowAccount = json.getString("borrowAccount");
            String borrowRate = json.getString("borrowRate");
            String periodType = json.getString("periodType");
            String borrowPeriod = json.getString("borrowPeriod");
            String repayAccountTimes = json.getString("repayAccountTimes");
            String publishTime = json.getString("publishTime");
            String borrowTitle = json.getString("borrowTitle");
            String projectNumber = json.getString("projectNumber");

            //String taskId = json.getString("taskId");

            Map<String, String> param = new HashMap<>();
            param.put("userId", "zenuo"); //默认执行账号为泽诺
            param.put("action", "complete");
            param.put("borrowProjectId", borrowProjectId);
            param.put("borrowId", borrowId);
            param.put("borrowAccount", borrowAccount);
            param.put("borrowRate", borrowRate);
            param.put("periodType", periodType);
            param.put("borrowPeriod", borrowPeriod);
            param.put("repayAccountTimes", repayAccountTimes);
            param.put("publishTime", publishTime);
            param.put("borrowTitle", borrowTitle);

            if (StringUtils.isEmpty(projectNumber)) {
                return apiResponse.error("000002").setErrmsg("项目编号为空");
            }

            //通过projectNumber去找寻taskId

            String taskId = flowService.findTaskIdByParam(projectNumber, "financingRegForm");
            if (StringUtils.isEmpty(taskId)) {
                return apiResponse.error("000001").setErrmsg("未找到对应的任务id");
            }

            flowService.completeTask(taskId, param);
            return apiResponse.success().setCode("000000").setReason("流程执行成功!");

        } catch (Exception e) {
            return apiResponse.error("000003").setErrmsg(e.getMessage());
        }

    }

    /**
     * @param flowId
     * @return
     * @throws Exception
     */
    @Override
    public ApiResponse borrowRepayDetailByflowId(@PathVariable("flowId") String flowId) throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();
        Map<String, String> map = flowService.taskbyProInsId(flowId);
        if (map != null && !map.isEmpty()) {
            String borrowProjectId = map.get("borrowProjectId");
            String borrowId = map.get("borrowId");
            if (StringUtils.isEmpty(borrowProjectId) || StringUtils.isEmpty(borrowId)) {
                return apiResponse.error("400").setErrmsg("获取参数borrowProjectId或者borrowId为空");
            }
            return borrowRepayDetail(borrowProjectId, borrowId);
        }

        return apiResponse.error("401").setErrmsg("流程查询不到相应数据");
    }
}
