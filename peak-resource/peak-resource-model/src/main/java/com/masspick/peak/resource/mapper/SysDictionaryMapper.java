package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysDictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SysDictionaryMapper
 */
@Mapper
public interface SysDictionaryMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysDictionary pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysDictionary pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysDictionary> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysDictionary pojo);

    /**
     * @param id
     * @return int
     */
    int deleteById(@Param("id") String id);

    /**
     * @param id
     * @return SysDictionary
     */
    SysDictionary findById(@Param("id") String id);

    /**
     * @param type
     * @return List
     */
    List<SysDictionary> selectByQueryParams(@Param("type")String type);

    /**
     * @param queryParams
     * @return List
     */
    List<SysDictionary> select(Map<String, Object> queryParams);
}
