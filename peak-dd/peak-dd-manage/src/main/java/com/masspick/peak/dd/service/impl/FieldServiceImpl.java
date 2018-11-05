package com.masspick.peak.dd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.dd.mapper.ControlMapper;
import com.masspick.peak.dd.model.Control;
import com.masspick.peak.dd.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * Created by admin on 2018/5/16 0016.
 */
@Service("fieldService")
public class FieldServiceImpl implements FieldService {

    /**
     * controlMapper
     */
    @Autowired
    private ControlMapper controlMapper;

    /**
     * @param page
     * @param rows
     * @param label
     * @param controlKey
     * @return PageInfo
     */
    @Override
    public PageInfo dataGrid(Integer page, Integer rows, String label, String controlKey) {
        PageHelper.startPage(page - 1, rows);
        if (!StringUtils.isEmpty(label)) {
            label = "%" + label.replace("%", "\\%") + "%";
        }

        if (!StringUtils.isEmpty(controlKey)) {
            controlKey = "%" + controlKey.replace("%", "\\%") + "%";
        }
        List<Control> controlList = controlMapper.dataGrid(label, controlKey);
        return new PageInfo(controlList);
    }

    @Override
    public void delete(String id) {
        controlMapper.updateState(id);
    }

    @Transactional
    @Override
    public int saveOrUpdate(Control control) {

        control.setUpdateTime(new Date());
        control.setCreateTime(new Date());

        //有id是保存 无是修改
        if (StringUtils.isEmpty(control.getId())) {
            control.setId(SequenceUtils.getUUID());
            control.setState(1);
            return controlMapper.insert(control);
        } else {
            return controlMapper.update(control);
        }
    }

    @Override
    public Boolean findByLabel(Control control) {
        Control dbControl = controlMapper.findByLabel(control.getLabel());
        return check(control, dbControl);
    }

    @Override
    public Boolean findByControlKey(Control control) {
        Control dbControl = controlMapper.findByControlKey(control.getControlKey());
        return check(control, dbControl);
    }

    @Override
    public List<Control> findAll() {
        return controlMapper.findByState();
    }

    private Boolean check(Control control, Control dbControl) {
        if (!StringUtils.isEmpty(control.getId())) {
            if (dbControl != null && !control.getId().equals(dbControl.getId())) {
                return true;
            }
        } else {
            if (dbControl != null) {
                return true;
            }
        }
        return false;
    }

}
