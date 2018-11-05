package com.masspick.peak.dd.mapper;

import com.masspick.peak.dd.model.DueDilData;
import com.masspick.peak.dd.model.bo.DueDilDataBO;
import com.masspick.peak.dd.model.bo.TemplateControlBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * DueDilDataMapper
 */
@Mapper
public interface DueDilDataMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") DueDilData pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") DueDilData pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<DueDilData> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") DueDilData pojo);

    /**
     * @param taskId
     * @return List<DueDilDataBO>
     */
    List<DueDilDataBO> findTaskBO(@Param("taskId") String taskId);

    /**
     * @param taskId
     * @param templateId
     * @return int
     */
    int delete(@Param("taskId") String taskId, @Param("templateId") String templateId);

    /**
     * @param taskId
     * @param templateId
     * @return List<Map<String,Object>>
     */
    List<Map<String, Object>> groupByGroupSeq(@Param("taskId") String taskId, @Param("templateId") String templateId);

    /**
     * @param templateId
     * @param taskId
     * @return List<TemplateControlBO>
     */
    List<TemplateControlBO> taskData(@Param("templateId") String templateId, @Param("taskId") String taskId);

    /**
     * @param taskId     taskId
     * @param controlKey controlKey
     * @return DueDilData
     */
    DueDilData findByTaskIdAndControlKey(@Param("taskId") String taskId, @Param("controlKey") String controlKey);
}
