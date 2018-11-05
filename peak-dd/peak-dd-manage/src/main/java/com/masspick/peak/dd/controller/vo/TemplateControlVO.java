package com.masspick.peak.dd.controller.vo;

import com.masspick.peak.dd.model.Template;
import com.masspick.peak.dd.model.TemplateControl;
import java.util.List;

/**
 * Created by admin on 2018/5/21 0021.
 */
public class TemplateControlVO extends Template {
    /**
     * templateControlList
     */
    private List<TemplateControl> templateControlList;

    /**
     * Gets templateControlList
     *
     * @return value of templateControlList
     */
    public List<TemplateControl> getTemplateControlList() {
        return templateControlList;
    }

    /**
     * @param templateControlList
     */
    public void setTemplateControlList(List<TemplateControl> templateControlList) {
        this.templateControlList = templateControlList;
    }
}
