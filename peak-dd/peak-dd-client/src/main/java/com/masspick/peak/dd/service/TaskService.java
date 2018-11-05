package com.masspick.peak.dd.service;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.model.dto.DdTaskDTO;

/**
 * Created by admin on 2018/5/23 0023.
 */
public interface TaskService {

    /**
     *
     * @param dueTask
     * @param account
     * @return int
     * @throws Exception Exception
     */
    int endTask(DueTask dueTask, String account) throws Exception;

    /**
     * @param taskId
     * @return DueTask
     */
    DueTask findById(String taskId);

    /**
     * @param pageNum
     * @param pageSize
     * @param executorId
     * @param flag
     * @return PageInfo<DueTask>
     */
    PageInfo<DueTask> pageInfo(Integer pageNum, Integer pageSize, String executorId, Boolean flag);

    /**
     *
     * @param taskDTO
     * @return int
     * @throws Exception Exception
     */
    int saveTask(DdTaskDTO taskDTO) throws Exception;
}
