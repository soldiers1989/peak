package com.masspick.peak.dd.service;


import com.github.pagehelper.PageInfo;
import com.masspick.peak.dd.controller.vo.TemplateControlVO;
import com.masspick.peak.dd.model.Template;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/5/18 0018.
 */
public interface TemplateService {

    /**
     * @param page
     * @param rows
     * @param label
     * @return PageInfo<Template>
     */
    PageInfo<Template> dataGrid(Integer page, Integer rows, String label);

    /**
     * @param id
     * @return int
     */
    int updateState(String id);

    /**
     * @param state
     * @return List<Template>
     */
    List<Template> findByState(Integer state);

    /**
     * @param templateControlVO
     * @return int
     */
    int addTemplate(TemplateControlVO templateControlVO);

    /**
     * @param templateId
     * @return Map<String, Object>
     */
    Map<String, Object> edit(String templateId);

    /**
     * @param name
     * @return Template
     */
    Template findByName(String name);
}
