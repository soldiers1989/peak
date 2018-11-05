package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SysDepartmentMapper
 */
@Mapper
public interface SysDepartmentMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysDepartment pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysDepartment pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysDepartment> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysDepartment pojo);

    /**
     * @param id
     * @return int
     */
    int deleteById(@Param("id") String id);

    /**
     * @param id
     * @return SysDepartment
     */
    SysDepartment findById(@Param("id") String id);

    /**
     * @param queryParams
     * @return List
     */
    List<SysDepartment> selectByQueryParams(Map<String, Object> queryParams);

    /**
     * @return List
     */
    List<SysDepartment> find();

}
