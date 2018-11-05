package com.masspick.peak.resource.rpc;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.resource.controller.vo.MenuTreeVO;
import com.masspick.peak.resource.controller.vo.MenuVO;
import com.masspick.peak.resource.entity.SysApp;
import com.masspick.peak.resource.entity.SysUser;
import com.masspick.peak.resource.entity.bo.SysPermissionBO;
import com.masspick.peak.resource.service.IAppService;
import com.masspick.peak.resource.service.IPermissionService;
import com.masspick.peak.resource.service.IUserService;
import com.masspick.peak.resource.utils.HeaderUtil;
import com.masspick.peak.service.PermissionFeignApi;
import com.masspick.peak.service.dto.ApiResponseDTO;
import com.masspick.peak.service.dto.SysPermissionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限对外暴露接口实现类
 */
@RestController
public class PermissionFeignRpc implements PermissionFeignApi {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionFeignRpc.class);

    /**
     * permissionService
     */
    @Autowired
    private IPermissionService permissionService;

    /**
     * httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * iUserService
     */
    @Autowired
    private IUserService iUserService;

    /**
     * iAppService
     */
    @Autowired
    private IAppService iAppService;


    @Override
    public ApiResponseDTO userPermission() throws Exception {
        ApiResponseDTO apiResponse = ApiResponseDTO.getInstances();
        String appId = httpServletRequest.getHeader(HeaderUtil.AUTH_ID);
        String account = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
        LOGGER.info("---->userPermission params AUTH_ID={}, AUTH_USER={}<----", appId, account);

        //判断应用
        SysApp sysApp = iAppService.findByAppId(appId);
        if (sysApp == null) {
            return apiResponse.error("ERR-404", "未找到应用！！！");
        } else if (sysApp != null && sysApp.getStatus() == 0) {
            return apiResponse.error("ERR-404", "该应用已被禁用!!!");
        }

        //判断用户
        SysUser sysUser = iUserService.findByAccount(account);
        if (sysUser == null) {
            return apiResponse.error("ERR-404", "未找到该用户!!!");
        } else if (sysUser != null && sysUser.getStatus() == 0) {
            return apiResponse.error("ERR-403", "该用户已被禁用!!!");
        }

        List<SysPermissionBO> list = permissionService.findByAccountAndAppId(sysUser.getId(), appId);
        MenuTreeVO menuTreeVO = new MenuTreeVO();
        menuTreeVO.setPermissions(list);
        List<MenuVO> menuVOS = menuTreeVO.menuTree(appId);
        Map<String, Object> map = new HashMap<>();
        map.put("menu", menuVOS);
        map.put("resource", menuTreeVO.getResource());
        return apiResponse.success().setResult(map);
    }

    @Override
    public List<SysPermissionDTO> ddPermission(@RequestParam("account") String account, @RequestParam("appId") String
            appId) throws Exception {
        LOGGER.info("---->userPermission params AUTH_ID={}, AUTH_USER={}<----", appId, account);
        SysApp sysApp = iAppService.findByAppId(appId);
        if (sysApp == null) {
            LOGGER.info("ERR-404", "未找到应用！！！");
            return null;
        } else if (sysApp != null && sysApp.getStatus() == 0) {
            LOGGER.info("ERR-404", "该应用已被禁用!!!");
            return null;
        }

        //判断用户
        SysUser sysUser = iUserService.findByAccount(account);
        if (sysUser == null) {
            LOGGER.info("ERR-404", "未找到该用户!!!");
            return null;
        } else if (sysUser != null && sysUser.getStatus() == 0) {
            LOGGER.info("ERR-404", "该用户已被禁用!!!");
            return null;
        }

        List<SysPermissionDTO> sysPermissionDTOS = new ArrayList<>();
        List<SysPermissionBO> list = permissionService.findByAccountAndAppId(sysUser.getId(), appId);
        for (SysPermissionBO sysPermissionBO : list) {
            sysPermissionDTOS.add(JacksonUtils.copyProperties(sysPermissionBO, SysPermissionDTO.class));
        }
        return sysPermissionDTOS;
    }
}
