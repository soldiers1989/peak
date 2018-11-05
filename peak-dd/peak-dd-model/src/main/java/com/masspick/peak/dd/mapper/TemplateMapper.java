package com.masspick.peak.dd.mapper;

import com.masspick.peak.dd.model.Template;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TemplateMapper
 */
@Mapper
public interface TemplateMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") Template pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") Template pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<Template> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") Template pojo);

    /**
     * @param label
     * @return List<Template>
     */
    List<Template> dataGrid(@Param("label") String label);

    /**
     * @param id
     * @return int
     */
    int updateStateById(@Param("id") String id);

    /**
     * @return List<Template>
     */
    List<Template> findAll();

    /**
     * @param state
     * @return List<Template>
     */
    List<Template> findByState(@Param("state") Integer state);

    /**
     * @param id
     * @return Template
     */
    Template findById(@Param("id") String id);

    /**
     * @param name
     * @return Template
     */
    Template findByName(@Param("name") String name);
}
