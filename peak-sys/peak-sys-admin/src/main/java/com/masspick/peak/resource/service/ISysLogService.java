package com.masspick.peak.resource.service;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.resource.entity.SysLog;

/**
 * Created by admin on 2018/8/9 0009.
 */
public interface ISysLogService {

    /**
     * @param sysLog sysLog
     */
    void insert(SysLog sysLog);

    /**
     * 分页查询日志
     *
     * @param pageNum   pageNum
     * @param pageSize  pageSize
     * @param startDate startDate
     * @param endDate   endDate
     * @param message   message
     * @param title     title
     * @return PageInfo
     */
    PageInfo<SysLog> dataGrid(Integer pageNum, Integer pageSize, String startDate, String endDate, String message,
                              String title);
}
