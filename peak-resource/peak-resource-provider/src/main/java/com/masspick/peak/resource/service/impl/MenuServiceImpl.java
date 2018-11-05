package com.masspick.peak.resource.service.impl;

import com.masspick.peak.resource.mapper.SysMenuMapper;
import com.masspick.peak.resource.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MenuServiceImpl
 */
@Service
public class MenuServiceImpl implements MenuService {

    /**
     * sysMenuMapper
     */
    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * @param menuId
     * @return String
     */
    @Override
    public String findHoleUpNameById(String menuId) {
        String str = "";
        return str;
    }

    /**
     * @param id
     * @return String
     */
    @Override
    public String findHoleDownNameById(String id) {
        return null;
    }

    /**
     * @param id
     * @return String
     */
    @Override
    public String findTotalNameById(String id) {
        return null;
    }
}
