package com.masspick.peak.guest.model.base;

import com.masspick.peak.common.util.SequenceUtils;

import java.util.Date;

/**
 * model 基类
 */
public class BaseEntity {

    /**
     * 实体编号（唯一标识）
     */
    private String id;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets createDate
     *
     * @return value of createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets updateDate
     *
     * @return value of updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 添加
     */
    public void preInsert() {
        this.id = SequenceUtils.getUUID();
        this.createDate = new Date();
        this.updateDate = this.createDate;
    }
}
