package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysAppMenu;
import org.apache.ibatis.annotations.Param;

/**
 * SysAppMenuMapper
 */
public interface SysAppMenuMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysAppMenu pojo);

    /**
     * @param menuId
     * @return SysAppMenu
     */
    SysAppMenu findByMenuId(@Param("menuId") String menuId);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysAppMenu pojo);
}
