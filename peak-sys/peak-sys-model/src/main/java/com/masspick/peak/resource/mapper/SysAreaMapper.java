package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysArea;
import com.masspick.peak.resource.entity.bo.Node;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysAreaMapper
 */
@Mapper
public interface SysAreaMapper {

    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysArea pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysArea pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysArea> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysArea pojo);

    /**
     * @param name     name
     * @param id       id
     * @param cityCode cityCode
     * @param zipCode  zipCode
     * @return List
     */
    List<SysArea> dataGrid(@Param("name") String name, @Param("id") String id, @Param("cityCode") String cityCode,
                           @Param("zipCode") String zipCode);

    /**
     * @return List
     */
    List<Node> find();

    /**
     * @param userId userId
     * @return List
     */
    List<Node> findByUserId(@Param("userId") String userId);

    /**
     * @param userId   userId
     * @param parentId parentId
     * @return List
     */
    List<Node> findByUserIdAndParentId(@Param("userId") String userId, @Param("parentId") String parentId);
}
