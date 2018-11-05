package com.masspick.peak.guest.controller.vo;

import javax.validation.constraints.NotNull;

/**
 *  活体检测对象
 */
public class LiveDetectVo {
    /**
     *  姓名
     */
    @NotNull(message = "姓名不能为空")
    private String idCardName;

    /**
     *  身份证号码
     */
    @NotNull(message = "身份证号码不能为空")
    private String idCardNumber;

    /**
     *  唇语视频上传地址
     */
    @NotNull(message = "唇语视频上传地址不能为空")
    private String videoUrl;

    /**
     *  唇语码
     */
    @NotNull(message = "唇语码不能为空")
    private String validate;

    /**
     * Gets idCardName
     *
     * @return value of idCardName
     */
    public String getIdCardName() {
        return idCardName;
    }

    /**
     * @param idCardName idCardName
     */
    public void setIdCardName(String idCardName) {
        this.idCardName = idCardName;
    }

    /**
     * Gets idCardNumber
     *
     * @return value of idCardNumber
     */
    public String getIdCardNumber() {
        return idCardNumber;
    }

    /**
     * @param idCardNumber idCardNumber
     */
    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    /**
     * Gets videoUrl
     *
     * @return value of videoUrl
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * @param videoUrl videoUrl
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * Gets validate
     *
     * @return value of validate
     */
    public String getValidate() {
        return validate;
    }

    /**
     * @param validate validate
     */
    public void setValidate(String validate) {
        this.validate = validate;
    }
}
