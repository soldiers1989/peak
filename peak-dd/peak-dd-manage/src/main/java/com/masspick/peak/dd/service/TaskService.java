package com.masspick.peak.dd.service;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.dd.model.bo.DueTaskBO;

import java.util.Map;

/**
 * Created by admin on 2018/5/18 0018.
 */
public interface TaskService {
    /**
     * @param page
     * @param rows
     * @param state
     * @param taskNum
     * @return PageInfo
     */
    PageInfo dataGrid(Integer page, Integer rows, Integer state, String taskNum);

    /**
     * @param id
     * @return DueTaskBO
     */
    DueTaskBO findByTaskBO(String id);

    /**
     * @param dueTask
     * @return int
     */
    int update(DueTask dueTask);

    /**
     * @param processId
     * @return Map<String, Object>
     */
    Map<String, Object> data(String processId);
}
