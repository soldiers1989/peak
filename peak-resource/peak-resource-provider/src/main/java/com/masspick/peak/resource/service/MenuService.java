package com.masspick.peak.resource.service;

/**
 * MenuService
 */
public interface MenuService {
    /**
     * @param menuId
     * @return String
     */
    String findHoleUpNameById(String menuId);

    /**
     * @param id
     * @return String
     */
    String findHoleDownNameById(String id);

    /**
     * @param id
     * @return String
     */
    String findTotalNameById(String id);
}
