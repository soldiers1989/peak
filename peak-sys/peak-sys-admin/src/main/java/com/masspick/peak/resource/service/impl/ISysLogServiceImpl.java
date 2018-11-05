package com.masspick.peak.resource.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.entity.SysLog;
import com.masspick.peak.resource.mapper.SysLogMapper;
import com.masspick.peak.resource.service.ISysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018/8/9 0009.
 */
@Service
public class ISysLogServiceImpl implements ISysLogService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ISysLogServiceImpl.class);
    /**
     * sysLogMapper
     */
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void insert(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }

    @Override
    public PageInfo<SysLog> dataGrid(Integer pageNum, Integer pageSize, String startDate, String endDate, String
            message, String title) {
        PageHelper.startPage(pageNum, pageSize);
        Date startD = null;
        Date endD = null;
        if (!StringUtils.isEmpty(startDate)) {
            try {
                startD = DateUtils.parseDate(startDate, "yyyy-MM-dd");
            } catch (ParseException e) {
                message = "开始时间格式转换异常!!!";
                LOGGER.error("error message:", e);
                return null;
            }
        }

        if (!StringUtils.isEmpty(endDate)) {
            try {

                endD = DateUtils.parseDate(endDate, "yyyy-MM-dd");
                endD = getEndOfDay(endD);
            } catch (ParseException e) {
                message = "开始时间格式转换异常!!!";
                LOGGER.error("error message:", e);
                return null;
            }
        }
        List<SysLog> sysLogList = sysLogMapper.find(startD, endD, title);
        return new PageInfo(sysLogList);
    }


    /**
     * @param date date
     * @return Date
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId
                .systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }
}
