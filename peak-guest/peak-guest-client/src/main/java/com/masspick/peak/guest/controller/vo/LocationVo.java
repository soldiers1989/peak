package com.masspick.peak.guest.controller.vo;


import javax.validation.constraints.NotNull;

/**
 * LocationVo
 */
public class LocationVo {
    /**
     * longitude
     */
    @NotNull(message = "经度不能为空")
    private String longitude;

    /**
     * latitude
     */
    @NotNull(message = "纬度不能为空")
    private String latitude;

    /**
     * Gets longitude
     * @return value of longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets latitude
     *
     * @return value of latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
