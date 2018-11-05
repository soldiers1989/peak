package com.masspick.peak.guest.controller.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

/**
 * PicInfoVo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PicInfoVo {
    /**
     * type
     */
    @NotNull(message = "图片类型不能为空")
    private String type;

    /**
     * url
     */
    @NotNull(message = "文件上传地址不能为空")
    private String url;

    /**
     *  面
     */
    private Integer side;

    /**
     * Gets type
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
     * Gets url
     * @return value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets side
     *
     * @return value of side
     */
    public Integer getSide() {
        return side;
    }

    /**
     * @param side side
     */
    public void setSide(Integer side) {
        this.side = side;
    }
}
