package com.masspick.peak.resource.entity;

import com.masspick.peak.common.util.SequenceUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 合作机构
 */
public class SysIns {
    /**
     * 机构名称
     */
    private String id;

    /**
     * 机构简称
     */
    @NotEmpty(message = "机构名称不能为空")
    private String name;

    /**
     * 主键id
     */
    private String shortName;

    /**
     * 机构编码
     */
    @NotEmpty(message = "机构编码不能为空")
    private String code;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 机构类型取值
     */
    @NotEmpty(message = "机构类型取值不能为空")
    private String typeValue;

    /**
     * 机构类型名称
     */
    @NotEmpty(message = "机构类型名称不能为空")
    private String typeName;


    /**
     * 状态（0-禁用 1-启用）
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 新增初始化
     */
    public void preInsert() {
        this.id = SequenceUtils.getUUID();
        this.createDate = new Date();
        this.updateDate = this.createDate;
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
     * @param id id
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
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets shortName
     *
     * @return value of shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Gets code
     *
     * @return value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets principal
     *
     * @return value of principal
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * @param principal principal
     */
    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    /**
     * Gets mobile
     *
     * @return value of mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return String
     */
    public String getTypeValue() {
        return typeValue;
    }

    /**
     * @param typeValue typeValue
     */
    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    /**
     * @return String
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * Gets status
     *
     * @return value of status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Gets remark
     *
     * @return value of remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
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

    @Override
    public String toString() {
        return "SysIns{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", shortName='" + shortName + '\''
                + ", code='" + code + '\''
                + ", principal='" + principal + '\''
                + ", mobile='" + mobile + '\''
                + ", typeValue='" + typeValue + '\''
                + ", typeName='" + typeName + '\''
                + ", status=" + status
                + ", remark='" + remark + '\''
                + ", createDate=" + createDate
                + ", updateDate=" + updateDate
                + '}';
    }
}
