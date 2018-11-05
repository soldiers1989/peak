package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysIns;
import com.masspick.peak.resource.vo.InsDataGridFindVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 机构mapper
 */
@Mapper
public interface SysInsMapper {
    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysIns pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysIns pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojo") List<SysIns> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysIns pojo);

    /**
     * @param insDataGridFindVo insDataGridFindVo
     * @return List<SysIns>
     */
    List<SysIns> findByPage(@Param("pojo") InsDataGridFindVo insDataGridFindVo);

    /**
     * @return List<SysIns>
     */
    List<SysIns> findAll();

    /**
     * @return  List<SysIns>
     */
    List<SysIns> findAllAble();

    /**
     * @param id id
     * @return SysIns
     */
    SysIns findById(@Param("id") String id);

    /**
     * @param code code
     * @return SysIns
     */
    SysIns findByCode(@Param("code") String code);
}
