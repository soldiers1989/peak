package com.masspick.peak.dd.mapper;

import com.masspick.peak.dd.model.TemplateControl;
import com.masspick.peak.dd.model.bo.TemplateControlBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * TemplateControlMapper
 */
@Mapper
public interface TemplateControlMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") TemplateControl pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") TemplateControl pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<TemplateControl> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") TemplateControl pojo);

    /**
     * @param templateId
     * @return List<TemplateControlBO>
     */
    List<TemplateControlBO> findByTemplateId(@Param("templateId") String templateId);

    /**
     * @param templateId
     * @param taskId
     * @return List<TemplateControlBO>
     */
    List<TemplateControlBO> template(@Param("templateId") String templateId, @Param("taskId") String taskId);

    /**
     * @param templateId
     * @param taskId
     * @return List<TemplateControlBO>
     */
    List<TemplateControlBO> templateRelate(@Param("templateId") String templateId, @Param("taskId") String taskId);

    /**
     * @param templateId
     * @return List<Map<String,Object>>
     */
    List<Map<String, Object>> findGroupKey(@Param("templateId") String templateId);

    /**
     * @param templateId
     * @return int
     */
    int deleteByTemplateId(@Param("templateId") String templateId);
}
