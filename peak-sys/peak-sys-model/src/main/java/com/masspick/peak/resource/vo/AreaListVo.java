package com.masspick.peak.resource.vo;


import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *  员工授权区域对象
 */
public class AreaListVo {

    /**
     *  区域id
     */
    @NotNull(message = "区域id不能为空")
    private List<String> areaId;

    /**
     * Gets areaId
     *
     * @return value of areaId
     */
    public List<String> getAreaId() {
        return areaId;
    }

    /**
     * @param areaId areaId
     */
    public void setAreaId(List<String> areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "UserAreaVo{"
                + "areaId=" + areaId
                + '}';
    }
}
