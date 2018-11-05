package com.masspick.peak.guest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.guest.model.ControllerCer;

/**
 * ControllerCerMapper
 */
@Mapper
public interface ControllerCerMapper {
    /**
     * 单条插入
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") ControllerCer pojo);

    /**
     * 批量插入
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<ControllerCer> pojo);

    /**
     * 根据id更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") ControllerCer pojo);

    /**
     *  根据认证id查询
     * @param pojo pojo
     * @return int
     */
    int updateByCerId(@Param("pojo") ControllerCer pojo);

    /**
     * 通过认证id查询
     * @param cerId 认证id
     * @return ControllerCer
     */
    ControllerCer findByCerId(@Param("cerId") String cerId);
}
