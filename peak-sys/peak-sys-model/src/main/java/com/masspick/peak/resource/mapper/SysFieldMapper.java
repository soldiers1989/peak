package com.masspick.peak.resource.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * SysAreaMapper
 */
@Mapper
public interface SysFieldMapper {

    /**
     * @return List
     */
    List<Map> findAll();


    /**
     * @return Map
     */
    String findFieldTemplate(String templateId);

}
