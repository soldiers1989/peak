package com.masspick.peak.resource.service;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.resource.entity.SysIndustry;

/**
 * Created by admin on 2018/8/1 0001.
 */
public interface ISysIndustryService {

    /**
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @param name     name
     * @param code     code
     * @return PageInfo
     */
    PageInfo<SysIndustry> dataGrid(Integer pageNum, Integer pageSize, String name, String code);
}
