package com.masspick.peak.dd.controller;

import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.dd.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/5/23 0023.
 */
@RequestMapping("/template")
@RestController
public class TemplateController {

    /**
     * templateService
     */
    @Autowired
    private TemplateService templateService;


    /**
     * 获取模板
     * @param templateId
     * @param taskId
     * @return ApiResponse
     * @throws Exception Exception
     */
    @GetMapping("/{templateId}/{taskId}")
    public ApiResponse template(@PathVariable("templateId") String templateId, @PathVariable("taskId") String taskId) throws Exception {
        return templateService.template(templateId, taskId);
    }
}
