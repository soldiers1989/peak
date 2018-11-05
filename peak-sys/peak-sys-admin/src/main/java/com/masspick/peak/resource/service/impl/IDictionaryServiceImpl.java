package com.masspick.peak.resource.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.entity.SysDictionary;
import com.masspick.peak.resource.mapper.SysDictionaryMapper;
import com.masspick.peak.resource.service.IDictionaryService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/7/30 0030.
 */
@Service
public class IDictionaryServiceImpl implements IDictionaryService {

    /**
     * sysDictionaryMapper
     */
    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;

    @Override
    public PageInfo<SysDictionary> dataGrid(Integer pageNum, Integer pageSize, String name, Integer status, String
            code) {
        PageHelper.startPage(pageNum, pageSize);
        if (!StringUtils.isEmpty(name)) {
            name = "%" + name.replace("%", "\\%").replace("_", "\\_") + "%";
        }
        List<SysDictionary> sysDictionaryList = sysDictionaryMapper.dataGrid(name, status, code);
        return new PageInfo(sysDictionaryList);
    }

    @Override
    public SysDictionary findByCode(String code, String name) {
        return sysDictionaryMapper.findByCodeAndName(code, name);
    }

    @Override
    public List<SysDictionary> findByCodeAndParentId(String code, String name, String parentId, String id) {
        return sysDictionaryMapper.findByCodeOrNameAndParentId(code, name, parentId, id);
    }

    @Override
    public SysDictionary findById(String id) {
        return sysDictionaryMapper.findById(id);
    }

    @Override
    public int create(SysDictionary sysDictionary) {
        sysDictionary.setId(SequenceUtils.getUUID());
        sysDictionary.setUpdateDate(new Date());
        sysDictionary.setCreateDate(new Date());
        return sysDictionaryMapper.insert(sysDictionary);
    }

    @Override
    public int update(SysDictionary sysDictionary) {
        return sysDictionaryMapper.update(sysDictionary);
    }

    @Override
    public PageInfo<SysDictionary> findByParentCode(String parentId, Integer pageNum, Integer pageSize, String name,
                                                    Integer status) {
        PageHelper.startPage(pageNum, pageSize);
        if (!StringUtils.isEmpty(name)) {
            name = "%" + name.replace("%", "\\%").replace("_", "\\_") + "%";
        }
        List<SysDictionary> sysDictionaryList = sysDictionaryMapper.findByParentId(parentId, name, status);
        return new PageInfo(sysDictionaryList);
    }

    @Override
    public List<SysDictionary> findDictionaries() {
        return sysDictionaryMapper.findByParentIdIsNull();
    }

    @Override
    public SysDictionary findByCode(String code) {
        return sysDictionaryMapper.findByCode(code);
    }

    @Override
    public List<SysDictionary> findByParentId(String parentId) {
        return sysDictionaryMapper.getByParentId(parentId);
    }

    /**
     * 通过type和key查询名称
     * @param type
     * @param bussKey
     * @return String
     */
    @Override
    public String findDictNameByTypeAndKey(String type, String bussKey) {
        Map<String, String> map = new HashedMap();
        map.put("type", type);
        map.put("bussKey", bussKey);
        List<SysDictionary> list = sysDictionaryMapper.getDictByTypeAndKey(map);
        if (!CollectionUtils.isEmpty(list)) {
            SysDictionary dict = list.get(0);
            return dict.getName();
        }
        return "";
    }
}
