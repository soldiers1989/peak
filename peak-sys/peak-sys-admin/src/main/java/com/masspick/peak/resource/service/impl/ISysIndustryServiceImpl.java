package com.masspick.peak.resource.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.entity.SysIndustry;
import com.masspick.peak.resource.mapper.SysIndustryMapper;
import com.masspick.peak.resource.service.ISysIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/8/1 0001.
 */
@Service
public class ISysIndustryServiceImpl implements ISysIndustryService {

    /**
     * sysIndustryMapper
     */
    @Autowired
    private SysIndustryMapper sysIndustryMapper;

    @Override
    public PageInfo<SysIndustry> dataGrid(Integer pageNum, Integer pageSize, String name, String code) {
        PageHelper.startPage(pageNum, pageSize);
        if (!StringUtils.isEmpty(name)) {
            name = "%" + name.replace("%", "\\%").replace("_", "\\_") + "%";
        }
        List<SysIndustry> sysIndustryList = sysIndustryMapper.findByNameAndCode(name, code);
        return new PageInfo<>(sysIndustryList);
    }
}
