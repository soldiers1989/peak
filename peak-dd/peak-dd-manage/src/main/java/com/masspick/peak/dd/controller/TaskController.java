package com.masspick.peak.dd.controller;


import com.github.pagehelper.PageInfo;
import com.masspick.peak.dd.config.SystemConfig;
import com.masspick.peak.dd.controller.vo.DueTaskVO;
import com.masspick.peak.dd.controller.vo.UserVO;
import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.dd.model.bo.DueTaskBO;
import com.masspick.peak.dd.service.TaskService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/5/18 0018.
 */
@Controller
@RequestMapping("/task")
public class TaskController extends BaseController {

    /**
     * taskService
     */
    @Autowired
    private TaskService taskService;

    /**
     * systemConfig
     */
    @Autowired
    private SystemConfig systemConfig;

    /**
     * @return String
     */
    @RequiresPermissions("ddTask")
    @GetMapping("/index")
    public String index() {
        return "task/index";
    }

    /**
     * @param page
     * @param rows
     * @param state
     * @param taskNum
     * @return Object
     */
    @GetMapping("/dataGrid")
    @ResponseBody
    public Object dataGrid(Integer page, Integer rows, Integer state, String taskNum) {
        PageInfo<DueTaskBO> taskPageInfo = taskService.dataGrid(page, rows, state, taskNum);
        return taskPageInfo.getList();
    }

    /**
     * @param model
     * @param id
     * @return String
     */
    @RequiresPermissions("taskInfo")
    @GetMapping("/info")
    public String taskInfo(Model model, String id) {
        DueTaskBO dueTaskBO = taskService.findByTaskBO(id);
        DueTaskVO dueTaskVO = new DueTaskVO();
        dueTaskVO.transfer(dueTaskVO, dueTaskBO);
        model.addAttribute("task", dueTaskVO);
        return "task/info";
    }

    /**
     * @param model
     * @param processId
     * @return String
     */
    @GetMapping("/result")
    public String result(Model model, String processId) {
        model.addAllAttributes(taskService.data(processId));
        return "task/result";
    }

    /**
     * @param model
     * @param processId
     * @return String
     */
    @GetMapping("/resultInfo")
    public String resultInfo(Model model, String processId) {
        model.addAllAttributes(taskService.data(processId));
        return "task/resultInfo";
    }

    /**
     * 指派操作
     *
     * @param dueTask
     * @return Object
     */
    @ResponseBody
    @PostMapping("/update")
    public Object taskInfo(@RequestBody DueTask dueTask) {
        int i = taskService.update(dueTask);
        if (i == 1) {
            return renderSuccess();
        } else {
            return renderError("保存失败！！！");
        }
    }

    /**
     * @return Object
     */
    @ResponseBody
    @RequestMapping("/user")
    public Object userList() {
        String url = systemConfig.getZuulUrl() + "/peak-resource/api/resource/userList/dd-Investigator";
        List<UserVO> list = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
        List<Map<String, Object>> sysUserList = responseEntity.getBody();
        for (Map<String, Object> map : sysUserList) {
            UserVO userVO = new UserVO();
            userVO.transfer(userVO, map);
            list.add(userVO);
        }
        return renderSuccess(list);
    }

}
