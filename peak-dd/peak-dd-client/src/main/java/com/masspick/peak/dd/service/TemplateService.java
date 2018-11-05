package com.masspick.peak.dd.service;


import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.dd.model.Template;

/**
 * Created by admin on 2018/5/23 0023.
 */
public interface TemplateService {

    /**
     * @param templateId
     * @param taskId
     * @return ApiResponse
     * @throws Exception Exception
     */
    ApiResponse template(String templateId, String taskId) throws Exception;


    /**
     * @param templateId
     * @return Template
     */
    Template findById(String templateId);
}
