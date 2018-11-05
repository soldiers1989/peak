package com.masspick.peak.resource.service;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.resource.entity.SysArea;
import com.masspick.peak.resource.entity.bo.Node;

import java.util.List;

/**
 * Created by admin on 2018/7/30 0030.
 */
public interface IAreaService {

    /**
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @param name     name
     * @param code     code
     * @param cityCode cityCode
     * @param zipCode  zipCode
     * @return PageInfo
     */
    PageInfo<SysArea> dataGrid(Integer pageNum, Integer pageSize, String name, String code, String cityCode, String
            zipCode);


    /**
     * 查询所有
     *
     * @param userId userId
     * @return List
     */
    List<Node> findAll(String userId);

    /**
     * 查询所有
     *
     * @param userId userId
     * @param parentId parentId
     * @return List
     */
    List<Node> findByParentId(String userId, String parentId);
}
