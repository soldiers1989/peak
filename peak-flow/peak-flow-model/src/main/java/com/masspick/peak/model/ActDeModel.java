package com.masspick.peak.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * ActDeModel
 */
public class ActDeModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * name
     */
    private String name;

    /**
     * modelKey
     */
    private String modelKey;

    /**
     * description
     */
    private String description;

    /**
     * created
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;

    /**
     * modelEditorJson
     */
    private String modelEditorJson;

    /**
     * tenantId
     */
    private String tenantId;

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
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets modelKey
     *
     * @return value of modelKey
     */
    public String getModelKey() {
        return modelKey;
    }

    /**
     * @param modelKey
     */
    public void setModelKey(String modelKey) {
        this.modelKey = modelKey;
    }

    /**
     * Gets description
     *
     * @return value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets created
     *
     * @return value of created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * Gets modelEditorJson
     *
     * @return value of modelEditorJson
     */
    public String getModelEditorJson() {
        return modelEditorJson;
    }

    /**
     * @param modelEditorJson
     */
    public void setModelEditorJson(String modelEditorJson) {
        this.modelEditorJson = modelEditorJson;
    }

    /**
     * Gets tenantId
     *
     * @return value of tenantId
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * @param tenantId
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
