package com.masspick.peak.dd.scheduled;

import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.dd.mapper.DueTaskMapper;
import com.masspick.peak.dd.mapper.TaskCountMapper;
import com.masspick.peak.dd.model.TaskCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by admin on 2018/5/29 0029.
 */
@Component
public class TaskScheduled {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskScheduled.class);

    /**
     * taskCountMapper
     */
    @Autowired
    private TaskCountMapper taskCountMapper;

    /**
     * dueTaskMapper
     */
    @Autowired
    private DueTaskMapper dueTaskMapper;

    /**
     * executeFileDownLoadTask
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void executeFileDownLoadTask() {
        Date date = DateUtils.yesterdayMin();
        Integer count = dueTaskMapper.count();
        Integer countByState = dueTaskMapper.countByState();
        Integer yesCount = dueTaskMapper.countByCreateTime(date);
        Integer yesCountByState = dueTaskMapper.countByCreateTimeAndState(date);
        TaskCount taskCount = new TaskCount(SequenceUtils.getUUID(), yesCount, yesCountByState, countByState, count,
                new Date(), new Date());
        taskCountMapper.insert(taskCount);
    }
}
