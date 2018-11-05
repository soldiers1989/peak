package com.masspick.peak.dd.controller;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.dd.controller.vo.ControlVO;
import com.masspick.peak.dd.model.Control;
import com.masspick.peak.dd.service.FieldService;
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
 * Created by admin on 2018/5/16 0016.
 * <p>
 * 模板管理
 */
@Controller
@RequestMapping(value = "/field")
public class FieldController extends BaseController {

    /**
     * fieldService
     */
    @Autowired
    private FieldService fieldService;


    /**
     * @param page
     * @param rows
     * @param label
     * @param controlKey
     * @return Object
     */
    @GetMapping("/dataGrid")
    @ResponseBody
    private Object dataGrid(Integer page, Integer rows, String label, String controlKey) {
        PageInfo<Control> controlPageInfo = fieldService.dataGrid(page, rows, label, controlKey);
        return controlPageInfo.getList();
    }

    /**
     * @param model
     * @return String
     */
    //@RequiresPermissions("fieldIndex")
    @GetMapping("/index")
    public String filed(Model model) {
        return "mould/field";
    }


    /**
     * @param control
     * @return Object
     */
    @ResponseBody
    @PostMapping("/save")
    public Object saveOrUpdate(@RequestBody Control control) {

        if (fieldService.findByLabel(control) || fieldService.findByControlKey(control)) {
            return renderError("已经存在相同的key或者字段名称！！！");
        }
        fieldService.saveOrUpdate(control);
        return renderSuccess();
    }

    /**
     * @param id
     * @return Object
     */
    @ResponseBody
    @GetMapping("/delete")
    public Object delete(String id) {
        fieldService.delete(id);
        return renderSuccess();
    }

    /**
     * 添加模板所需的
     *
     * @param page
     * @param rows
     * @param label
     * @param controlKey
     * @return
     */
    @GetMapping("/tempControl")
    @ResponseBody
    private Object tempControl(Integer page, Integer rows, String label, String controlKey) {
        PageInfo<Control> controlPageInfo = fieldService.dataGrid(page, rows, label, controlKey);
        List<ControlVO> controlVOList = new ArrayList<>();
        for (Control control : controlPageInfo.getList()) {
            ControlVO controlVO = new ControlVO();
            controlVO.transfer(control, controlVO);
            controlVOList.add(controlVO);
        }
        return controlVOList;
    }

    /**
     * @return Object
     */
    @GetMapping("/findAll")
    @ResponseBody
    public Object findAll() {
        return fieldService.findAll();
    }

}
