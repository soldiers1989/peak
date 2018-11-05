package com.masspick.peak.dd.service;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.dd.model.Control;

import java.util.List;

/**
 * Created by admin on 2018/5/16 0016.
 */
public interface FieldService {
    /**
     * @param page
     * @param rows
     * @param label
     * @param controlKey
     * @return PageInfo
     */
    PageInfo dataGrid(Integer page, Integer rows, String label, String controlKey);

    /**
     * @param id
     */
    void delete(String id);

    /**
     * @param control
     * @return int
     */
    int saveOrUpdate(Control control);

    /**
     * @param control
     * @return Boolean
     */
    Boolean findByLabel(Control control);

    /**
     * @param control
     * @return Boolean
     */
    Boolean findByControlKey(Control control);

    /**
     * @return List<Control>
     */
    List<Control> findAll();

}
