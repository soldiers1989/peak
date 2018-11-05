package com.masspick.peak.dd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.dd.controller.vo.TemplateControlVO;
import com.masspick.peak.dd.mapper.TemplateControlMapper;
import com.masspick.peak.dd.mapper.TemplateMapper;
import com.masspick.peak.dd.model.Template;
import com.masspick.peak.dd.model.TemplateControl;
import com.masspick.peak.dd.model.bo.TemplateControlBO;
import com.masspick.peak.dd.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/5/18 0018.
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    /**
     * TemplateMapper
     */
    @Autowired
    private TemplateMapper templateMapper;

    /**
     * TemplateControlMapper
     */
    @Autowired
    private TemplateControlMapper templateControlMapper;


    /**
     * 查询
     * @param page
     * @param rows
     * @param label
     * @return PageInfo
     */
    @Override
    public PageInfo dataGrid(Integer page, Integer rows, String label) {
        PageHelper.startPage(page - 1, rows);
        if (!StringUtils.isEmpty(label)) {
            label = "%" + label.replace("%", "\\%") + "%";
        }

        List<Template> controlList = templateMapper.dataGrid(label);
        return new PageInfo(controlList);
    }


    /**
     * 删除
     * @param id
     * @return int
     */
    @Transactional
    @Override
    public int updateState(String id) {
        return templateMapper.updateStateById(id);
    }


    /**
     * @param state
     * @return List<Template>
     */
    @Override
    public List<Template> findByState(Integer state) {
        return templateMapper.findByState(state);
    }

    /**
     * @param templateControlVO
     * @return int
     */
    @Transactional
    @Override
    public int addTemplate(TemplateControlVO templateControlVO) {
        int i = 0;
        //未空则是更新
        Template template = null;

        if (StringUtils.isEmpty(templateControlVO.getId())) {
            String tempId = SequenceUtils.getUUID();
            template = new Template(tempId, templateControlVO.getName(), "1", "admin", Template.ACTIVE);
            template.setCreateTime(new Date());
            template.setCreator("admin");
            template.setUpdateTime(new Date());

            i = templateMapper.insert(template);


        } else {
            template = new Template(templateControlVO.getId(), templateControlVO.getName(), "1", "admin", Template
                    .ACTIVE);
            template.setUpdater("admin");
            template.setUpdateTime(new Date());
            i = templateMapper.update(template);
            templateControlMapper.deleteByTemplateId(template.getId());
        }

        for (TemplateControl templateControl : templateControlVO.getTemplateControlList()) {
            templateControl.setId(SequenceUtils.getUUID());
            templateControl.setTemplateId(template.getId());
            templateControl.setCreateTime(new Date());
            templateControl.setCreator("admin");
            templateControl.setUpdater("admin");
            templateControl.setUpdateTime(new Date());
        }
        templateControlMapper.insertList(templateControlVO.getTemplateControlList());
        return i;
    }

    /**
     * 编辑模板
     * @param templateId
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> edit(String templateId) {
        Map<String, Object> map = new HashMap<>();
        Template template = templateMapper.findById(templateId);
        List<TemplateControlBO> controlDTOList = templateControlMapper.findByTemplateId(templateId);
        List<Map<String, Object>> groupKey = templateControlMapper.findGroupKey(templateId);
        map.put("template", template);
        map.put("controlList", controlDTOList);
        map.put("group", groupKey);
        return map;
    }

    /**
     * @param name
     * @return Template
     */
    @Override
    public Template findByName(String name) {
        return templateMapper.findByName(name);
    }
}
