package com.masspick.peak.guest.mapper;

import com.masspick.peak.guest.model.IdMobileCer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * IdCerMapper
 */
@Mapper
public interface IdMobileCerMapper {
    /**
     * 单条插入
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") IdMobileCer pojo);


    /**
     * 根据id更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") IdMobileCer pojo);

    /**
     * 根据认证id更新
     * @param pojo pojo
     * @return int
     */
    int updateByCerId(@Param("pojo") IdMobileCer pojo);

    /**
     *  通过认证id查询
     * @param cerId 认证id
     * @return IdMobileCer
     */
    IdMobileCer findByCerId(@Param("cerId") String cerId);
}
