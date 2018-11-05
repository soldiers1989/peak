package com.masspick.peak.dd.controller.vo;

import com.masspick.peak.dd.model.Template;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/5/23 0023.
 */
public class TemplateVO {

    /**
     * id
     */
    private String id;

    /**
     * label
     */
    private String label;

    /**
     * blockList
     */
    private List<GroupVO> blockList = new ArrayList<>();

    /**
     * @param templateVO
     * @param template
     */
    public void transfer(TemplateVO templateVO, Template template) {
        templateVO.setId(template.getId());
        templateVO.setLabel(template.getName());
    }

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets label
     *
     * @return value of label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets blockList
     *
     * @return value of blockList
     */
    public List<GroupVO> getBlockList() {
        return blockList;
    }

    /**
     * @param blockList
     */
    public void setBlockList(List<GroupVO> blockList) {
        this.blockList = blockList;
    }
}
