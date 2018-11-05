package com.masspick.peak.dd.controller;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.common.util.HeaderUtil;
import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.dd.service.TaskService;
import com.masspick.peak.dd.util.ResultEnum;
import com.masspick.peak.service.IUserFeignApi;
import com.masspick.peak.service.dto.SysUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/5/23 0023.
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    /**
     * taskService
     */
    @Autowired
    private TaskService taskService;

    /**
     * request
     */
    @Autowired
    private HttpServletRequest request;

    /**
     * iUserFeignApi
     */
    @Resource
    private IUserFeignApi iUserFeignApi;

    /**
     * 获取当前用户的所有任务
     *
     * @param pageNum
     * @param pageSize
     * @param flag
     * @return ApiResponse
     * @throws Exception Exception
     */
    @GetMapping
    public ApiResponse taskList(Integer pageNum, Integer pageSize, Boolean flag) throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();
        String account = request.getHeader(HeaderUtil.AUTH_USER);
        SysUserDTO sysUserDTO = iUserFeignApi.findByName(account);
        PageInfo pageInfo = taskService.pageInfo(pageNum, pageSize, sysUserDTO.getId(), flag);
        return apiResponse.success(pageInfo.getList());
    }

    /**
     * 获取某个任务
     *
     * @return ApiResponse
     */
    @GetMapping("/{taskId}")
    public ApiResponse task(@PathVariable("taskId") String taskId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        ResultEnum resultEnum;
        DueTask dueTask = taskService.findById(taskId);
        if (null == dueTask) {
            resultEnum = ResultEnum.UNKNOWN_TASK;
            return apiResponse.error(resultEnum.getCode(), resultEnum.getReason());
        } else {
            return apiResponse.success(dueTask);
        }
    }

    /**
     * 终止任务
     *
     * @param taskId
     * @param reasonMap
     * @return ApiResponse
     * @throws Exception Exception
     */
    @PutMapping("/{taskId}")
    public ApiResponse endTask(@PathVariable("taskId") String taskId, @RequestBody Map<String, String> reasonMap)
            throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();
        DueTask dueTask = taskService.findById(taskId);
        ResultEnum resultEnum;
        if (null == dueTask) {
            resultEnum = ResultEnum.UNKNOWN_TASK;
            apiResponse.error(resultEnum.getCode(), resultEnum.getReason());
        } else if (null != dueTask && dueTask.getState() == DueTask.END) {
            resultEnum = ResultEnum.TASK_END;
            apiResponse.error(resultEnum.getCode(), resultEnum.getReason());
        } else {
            String account = request.getHeader(HeaderUtil.AUTH_USER);
            dueTask.setReason(reasonMap.get("reason"));
            dueTask.setDesc(reasonMap.get("desc"));
            dueTask.setRefuseDate(new Date());
            dueTask.setState(DueTask.END);
            int i = taskService.endTask(dueTask, account);
            if (i == 0) {
                apiResponse.error("ERROR-500", "系统内部错误!!!");
            } else {
                Map<String, String> map = new HashMap<>();
                map.put("taskId", taskId);
                apiResponse.success(map);
            }
        }
        return apiResponse;
    }
}
