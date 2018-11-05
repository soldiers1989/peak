package com.masspick.peak.dd.controller;

import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.common.util.HeaderUtil;
import com.masspick.peak.dd.controller.vo.DueDiligenceDataVO;
import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.dd.model.Template;
import com.masspick.peak.dd.service.DueDiligenceDataService;
import com.masspick.peak.dd.service.TaskService;
import com.masspick.peak.dd.service.TemplateService;
import com.masspick.peak.dd.util.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by admin on 2018/5/23 0023.
 */
@RestController
@RequestMapping("/dueDiligence")
public class DueDiligenceDataController {

    /**
     * dueDiligenceDataService
     */
    @Autowired
    private DueDiligenceDataService dueDiligenceDataService;

    /**
     * taskService
     */
    @Autowired
    private TaskService taskService;

    /**
     * templateService
     */
    @Autowired
    private TemplateService templateService;

    /**
     * httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 保存 与更新 尽调数据
     *
     * @param dueDiligenceDataVO
     * @return ApiResponse
     * @throws Exception Exception
     */
    @PostMapping
    public ApiResponse save(@RequestBody DueDiligenceDataVO dueDiligenceDataVO) throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();
        ResultEnum resultEnum;
        Template template = templateService.findById(dueDiligenceDataVO.getTemplateId());
        if (null == template) {
            resultEnum = ResultEnum.UNKNOWN_TEMPLATE;
            return apiResponse.error(resultEnum.getCode(), resultEnum.getReason());
        }

        DueTask dueTask = taskService.findById(dueDiligenceDataVO.getTaskId());

        //判断 任务
        if (null == dueTask) {
            resultEnum = ResultEnum.UNKNOWN_TASK;
            return apiResponse.error(resultEnum.getCode(), resultEnum.getReason());
        } else if (DueTask.END == dueTask.getState()) {
            resultEnum = ResultEnum.TASK_END;
        } else if (DueTask.FINISH == dueTask.getState()) {
            resultEnum = ResultEnum.TASK_FINISH;
        } else if (DueTask.ABNORMAL == dueTask.getState()) {
            resultEnum = ResultEnum.TASK_ABNORMAL;
        } else {
            String account = httpServletRequest.getHeader(HeaderUtil.AUTH_USER);
            return dueDiligenceDataService.updateAndSave(dueDiligenceDataVO, account);
        }
        return apiResponse.error(resultEnum.getCode(), resultEnum.getReason());
    }


    /**
     * 上传图片
     *
     * @param map
     * @return ApiResponse
     * @throws IOException IOException
     */
    @PostMapping("/upload")
    public ApiResponse upload(@RequestBody Map<String, String> map) throws IOException {
        return dueDiligenceDataService.generateImageCos(map.get("baseImg"));
    }


    /**
     * 查看尽调历史
     *
     * @param taskId
     * @param templateId
     * @return ApiResponse
     * @throws Exception Exception
     */
    @GetMapping("/{taskId}/{templateId}")
    public ApiResponse history(@PathVariable("taskId") String taskId, @PathVariable("templateId") String templateId)
            throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();
        ResultEnum resultEnum;
        DueTask dueTask = taskService.findById(taskId);
        if (null == dueTask) {
            resultEnum = ResultEnum.UNKNOWN_TASK;
            return apiResponse.error(resultEnum.getCode(), resultEnum.getReason());
        } else {
            return templateService.template(templateId, taskId);
        }
    }
}
