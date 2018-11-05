package com.masspick.peak.guest.controller.vo;

/**
 * Created by Administrator on 2018\7\13 0013.
 */
public class InfoAuthReviewVo {
    /**
     * 信息采集授权id
     */
    private String id;

    /**
     * 审核意见
     */
    private String comments;

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
     * Gets comments
     *
     * @return value of comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}
