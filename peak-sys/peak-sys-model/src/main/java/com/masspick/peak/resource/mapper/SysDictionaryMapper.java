package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysDictionary;
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
     * 插入数据
     *
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysDictionary pojo);

    /**
     * 选择插入数据
     *
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysDictionary pojo);

    /**
     * 批量插入
     *
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysDictionary> pojo);

    /**
     * 更新
     *
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysDictionary pojo);

    /**
     * 查询
     *
     * @param name   name
     * @param status status
     * @param code   code
     * @return List<SysDictionary>
     */
    List<SysDictionary> dataGrid(@Param("name") String name, @Param("status") Integer status, @Param("code") String
            code);

    /**
     * findByCode
     *
     * @param code code
     * @param name name
     * @return SysDictionary
     */
    SysDictionary findByCodeAndName(@Param("code") String code, @Param("name") String name);

    /**
     * @param code     code
     * @param name     name
     * @param parentId parentId
     * @param id       id
     * @return SysDictionary
     */
    List<SysDictionary> findByCodeOrNameAndParentId(@Param("code") String code, @Param("name") String name, @Param
            ("parentId") String parentId, @Param("id") String id);

    /**
     * findById
     *
     * @param id id
     * @return SysDictionary
     */
    SysDictionary findById(@Param("id") String id);

    /**
     * findByParentCode
     *
     * @param parentId parentId
     * @param name     name
     * @param status   status
     * @return List<SysDictionary>
     */
    List<SysDictionary> findByParentId(@Param("parentId") String parentId, @Param("name") String name, @Param
            ("status") Integer status);


    /**
     * 查询所有字典
     * @return List
     */
    List<SysDictionary> findByParentIdIsNull();

    /**
     *根据字典code查询该字典
     * @param code code
     * @return SysDictionary
     */
    SysDictionary findByCode(@Param("code")String code);

    /**
     * 查询当前字典的字典项
     * @return List
     */
    List<SysDictionary> getByParentId(@Param("parentId")String parentId);

    /**
     *
     * @param queryParams
     * @return List
     */
    List<SysDictionary> getDictByTypeAndKey(Map<String, String> queryParams);
}
