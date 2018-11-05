package com.masspick.peak.resource.service;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.resource.entity.SysDictionary;

import java.util.List;

/**
 * Created by admin on 2018/7/30 0030.
 */
public interface IDictionaryService {

    /**
     * 字典列表查询
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @param name     name
     * @param status   status
     * @param code     code
     * @return PageInfo
     */
    PageInfo<SysDictionary> dataGrid(Integer pageNum, Integer pageSize, String name, Integer status, String code);

    /**
     * 根据code查找字典
     *
     * @param code code
     * @param name name
     * @return SysDictionary
     */
    SysDictionary findByCode(String code, String name);

    /**
     * @param code     code
     * @param name     name
     * @param parentId parentId
     * @param id       id
     * @return SysDictionary
     */
    List<SysDictionary> findByCodeAndParentId(String code, String name, String parentId, String id);

    /**
     * 根据id查找字典
     *
     * @param id id
     * @return SysDictionary
     */
    SysDictionary findById(String id);

    /**
     * 创建字典
     *
     * @param sysDictionary sysDictionary
     * @return int
     */
    int create(SysDictionary sysDictionary);

    /**
     * 更新字典
     *
     * @param sysDictionary sysDictionary
     * @return int
     */
    int update(SysDictionary sysDictionary);

    /**
     * 查询字典项
     *
     * @param parentCode parentCode
     * @param pageNum    pageNum
     * @param pageSize   pageSize
     * @param name       name
     * @param status     status
     * @return PageInfo
     */
    PageInfo<SysDictionary> findByParentCode(String parentCode, Integer pageNum, Integer pageSize, String name,
                                             Integer status);

    /**
     * 暴露接口的服务  查询所有的字典数据
     *
     * @return List
     */
    List<SysDictionary> findDictionaries();

    /**
     * 根据字典code查询该字典
     *
     * @param code code
     * @return SysDictionary
     */
    SysDictionary findByCode(String code);

    /**
     * 查询当前字典的字典项
     *
     * @param parentId parentId
     * @return List
     */
    List<SysDictionary> findByParentId(String parentId);


    /**
     * 通过type和key查询名称
     * @param type
     * @param bussKey
     * @return String
     */
    String findDictNameByTypeAndKey(String type, String bussKey);
}

