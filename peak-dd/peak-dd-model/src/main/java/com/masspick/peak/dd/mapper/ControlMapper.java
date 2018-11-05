package com.masspick.peak.dd.mapper;

import com.masspick.peak.dd.model.Control;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ControlMapper
 */
@Mapper
public interface ControlMapper {

    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") Control pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") Control pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<Control> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") Control pojo);

    /**
     * 列表
     *
     * @param label
     * @param controlKey
     * @return List
     */
    List<Control> dataGrid(@Param("label") String label, @Param("controlKey") String controlKey);

    /**
     * 更新状态 0 删除
     * @param id
     * @return int
     */
    int updateState(@Param("id") String id);

    /**
     * @param label
     * @return Control
     */
    Control findByLabel(@Param("label") String label);

    /**
     * @param controlKey
     * @return Control
     */
    Control findByControlKey(@Param("controlKey") String controlKey);

    /**
     * @return List<Control>
     */
    List<Control> findByState();


}
