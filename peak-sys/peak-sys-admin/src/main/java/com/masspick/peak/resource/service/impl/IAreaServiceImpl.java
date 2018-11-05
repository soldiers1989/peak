package com.masspick.peak.resource.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.entity.SysArea;
import com.masspick.peak.resource.entity.bo.Node;
import com.masspick.peak.resource.mapper.SysAreaMapper;
import com.masspick.peak.resource.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/7/30 0030.
 */
@Service
public class IAreaServiceImpl implements IAreaService {

    /**
     * sysAreaMapper
     */
    @Autowired
    private SysAreaMapper sysAreaMapper;

    /**
     * 区域查询
     *
     * @param pageNum  页码
     * @param pageSize 条数
     * @param name     区域名称
     * @param code     区域code
     * @param cityCode 行政区号
     * @param zipCode  邮政编码
     * @return PageInfo
     */
    @Override
    public PageInfo<SysArea> dataGrid(Integer pageNum, Integer pageSize, String name, String code, String cityCode,
                                      String zipCode) {
        PageHelper.startPage(pageNum, pageSize);
        if (!StringUtils.isEmpty(name)) {
            name = "%" + name.replace("%", "\\%").replace("_", "\\_") + "%";
        }
        List<SysArea> sysAreaList = sysAreaMapper.dataGrid(name, code, cityCode, zipCode);
        return new PageInfo(sysAreaList);
    }

    @Override
    public List<Node> findAll(String userId) {
        return sysAreaMapper.findByUserId(userId);
    }

    @Override
    public List<Node> findByParentId(String userId, String parentId) {
        return sysAreaMapper.findByUserIdAndParentId(userId, parentId);
    }
}
