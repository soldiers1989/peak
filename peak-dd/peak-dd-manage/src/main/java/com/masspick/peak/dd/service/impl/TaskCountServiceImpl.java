package com.masspick.peak.dd.service.impl;

import com.masspick.peak.dd.mapper.TaskCountMapper;
import com.masspick.peak.dd.model.TaskCount;
import com.masspick.peak.dd.service.TaskCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/5/29 0029.
 */
@Service
public class TaskCountServiceImpl implements TaskCountService {
    /**
     * taskCountMapper
     */
    @Autowired
    private TaskCountMapper taskCountMapper;

    /**
     * @return TaskCount
     */
    @Override
    public TaskCount findByTaskCount() {
        return taskCountMapper.maxTaskCount();
    }
}
