package com.masspick.peak.service.dto;

import java.util.List;

/**
 * Created by admin on 2018/9/18 0018.
 */
public class ProductDTO {

    /**
     * 无参构造
     */
    public ProductDTO() {
    }

    /**
     * sysProductDTO
     */
    private SysProductDTO sysProductDTO;

    /**
     * productInterestDTOS
     */
    private List<SysProductInterestDTO> productInterestDTOS;

    /**
     * productServiceDTOS
     */
    private List<SysProductServiceDTO> productServiceDTOS;

    /**
     * Gets sysProductDTO
     *
     * @return value of sysProductDTO
     */
    public SysProductDTO getSysProductDTO() {
        return sysProductDTO;
    }

    /**
     * @param sysProductDTO sysProductDTO
     */
    public void setSysProductDTO(SysProductDTO sysProductDTO) {
        this.sysProductDTO = sysProductDTO;
    }

    /**
     * Gets productInterestDTOS
     *
     * @return value of productInterestDTOS
     */
    public List<SysProductInterestDTO> getProductInterestDTOS() {
        return productInterestDTOS;
    }

    /**
     * @param productInterestDTOS productInterestDTOS
     */
    public void setProductInterestDTOS(List<SysProductInterestDTO> productInterestDTOS) {
        this.productInterestDTOS = productInterestDTOS;
    }

    /**
     * Gets productServiceDTOS
     *
     * @return value of productServiceDTOS
     */
    public List<SysProductServiceDTO> getProductServiceDTOS() {
        return productServiceDTOS;
    }

    /**
     * @param productServiceDTOS productServiceDTOS
     */
    public void setProductServiceDTOS(List<SysProductServiceDTO> productServiceDTOS) {
        this.productServiceDTOS = productServiceDTOS;
    }
}
