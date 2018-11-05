package com.masspick.peak.guest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.masspick.peak.guest.model.base.BaseEntity;

import java.util.Date;

/**
 * Message
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message extends BaseEntity {

    /**
     * UN_READ_STATUS
     */
    public static final String UN_READ_STATUS = "0";

    /**
     * 消息类型 1 系统消息 2借款消息 3 还款消息
     */
    private String type;

    /**
     * 内容
     */
    private String content;

    /**
     * 状态 0 未读 1 已读
     */
    private String status;

    /**
     * 删除标记 0 未删除 1 已删除
     */
    private String delFlag;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 公司名称
     */
    private String etpName;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 构造函数
     */
    public Message() {
    }

    /**
     * 构造函数
     */
    public Message(String type, String content, String status, String delFlag, String userId, String etpName, Date sendTime) {
        this.type = type;
        this.content = content;
        this.status = status;
        this.delFlag = delFlag;
        this.userId = userId;
        this.etpName = etpName;
        this.sendTime = sendTime;
    }

    /**
     * 构造函数
     */
    public Message(String type, String content, String status, String userId) {
        this.type = type;
        this.content = content;
        this.status = status;
        this.userId = userId;
        this.sendTime = new Date();
        this.delFlag = UN_READ_STATUS;
    }

    /**
     * Gets type
     *
     * @return value of type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets content
     *
     * @return value of content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets status
     *
     * @return value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets delFlag
     *
     * @return value of delFlag
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag delFlag
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * Gets userId
     *
     * @return value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets etpName
     *
     * @return value of etpName
     */
    public String getEtpName() {
        return etpName;
    }

    /**
     * @param etpName etpName
     */
    public void setEtpName(String etpName) {
        this.etpName = etpName;
    }

    /**
     * Gets sendTime
     *
     * @return value of sendTime
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * @param sendTime sendTime
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Message{"
                + "type='" + type + '\''
                + ", content='" + content + '\''
                + ", status='" + status + '\''
                + ", delFlag='" + delFlag + '\''
                + ", userId='" + userId + '\''
                + ", etpName='" + etpName + '\''
                + ", sendTime=" + sendTime
                + '}';
    }
}
