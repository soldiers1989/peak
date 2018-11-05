package com.masspick.peak.dd.controller;


import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.dd.controller.vo.TemplateControlVO;
import com.masspick.peak.dd.controller.vo.TemplateVO;
import com.masspick.peak.dd.model.Template;
import com.masspick.peak.dd.service.TemplateService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/5/18 0018.
 */
@Controller
@RequestMapping("/template")
public class TemplateController extends BaseController {

    /**
     * templateService
     */
    @Autowired
    private TemplateService templateService;

    /**
     * @return String
     */
    @RequiresPermissions("templateIndex")
    @GetMapping("/index")
    public String index() {
        return "mould/template";
    }

    /**
     * @return String
     */
    @RequiresPermissions("templateAdd")
    @GetMapping("/add")
    public String add() {
        return "mould/add";
    }

    /**
     * @param model
     * @param id
     * @return String
     */
    @RequiresPermissions("templateEdit")
    @GetMapping("/edit")
    public String edit(Model model, String id) {
        model.addAllAttributes(templateService.edit(id));
        return "mould/add";
    }


    /**
     * 查询数据
     *
     * @param page
     * @param rows
     * @param name
     * @return Object
     * @throws Exception Exception
     */
    @ResponseBody
    @GetMapping("/dataGrid")
    public Object dataGrid(Integer page, Integer rows, String name) throws Exception {
        PageInfo<Template> pageInfo = templateService.dataGrid(page, rows, name);
        List<TemplateVO> templateList = new ArrayList<>();
        for (Template template : pageInfo.getList()) {
            TemplateVO templateVO = new TemplateVO();
            BeanUtils.copyProperties(templateVO, template);
            templateVO.setCreateDate(DateUtils.DEFAULT_DATETIME_FORMAT.format(templateVO.getCreateTime()));
            templateVO.setUpdateDate(DateUtils.DEFAULT_DATETIME_FORMAT.format(templateVO.getUpdateTime()));
            templateList.add(templateVO);
        }
        return templateList;
    }


    /**
     * 删除模板
     *
     * @param id
     * @return Object
     */
    @ResponseBody
    @GetMapping("/delete")
    public Object delete(String id) {
        int i = templateService.updateState(id);
        if (i == 1) {
            return renderSuccess();
        } else {
            return renderError("删除失败！！！");
        }
    }

    /**
     * @return Object
     */
    @ResponseBody
    @GetMapping("/findAll")
    public Object template() {
        List<Template> list = templateService.findByState(Template.ACTIVE);
        return renderSuccess(list);
    }

    /**
     * @param templateControlVO
     * @return Object
     */
    @ResponseBody
    @PostMapping("/save")
    public Object save(@RequestBody TemplateControlVO templateControlVO) {
        Template template = templateService.findByName(templateControlVO.getName());
        if (!StringUtils.isEmpty(templateControlVO.getId())) {
            if (template != null && !templateControlVO.getId().equals(template.getId())) {
                return renderError("模板名称已存在！！！");
            }
        } else {
            if (template != null) {
                return renderError("模板名称已存在！！！");
            }
        }

        //更新模板
        int i = templateService.addTemplate(templateControlVO);
        if (i > 0) {
            return renderSuccess();
        } else {
            return renderError("保存模板失败！！！");
        }
    }
}
