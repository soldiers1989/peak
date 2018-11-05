package com.masspick.peak.resource.rpc;

import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.resource.entity.SysUser;
import com.masspick.peak.resource.service.IUserService;
import com.masspick.peak.resource.utils.HeaderUtil;
import com.masspick.peak.resource.utils.MD5Util;
import com.masspick.peak.service.IUserFeignApi;
import com.masspick.peak.service.dto.ApiResponseDTO;
import com.masspick.peak.service.dto.SysUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/9/5 0005.
 */
@RestController
public class IUserFeignRpc implements IUserFeignApi {

    /**
     * iUserService
     */
    @Autowired
    private IUserService iUserService;

    /**
     * httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * @param account account
     * @return SysUserDTO
     * @throws Exception Exception
     */
    @Override
    public SysUserDTO findByName(@PathVariable("account") String account) throws Exception {
        SysUser sysUser = iUserService.findByAccount(account);
        return JacksonUtils.copyProperties(sysUser, SysUserDTO.class);
    }

    /**
     *
     * @param account account
     * @param userMap 用户信息
     * @return
     * @throws Exception
     */
    @Override
    public ApiResponseDTO modifyUserPass(@PathVariable("account") String account, @RequestBody  Map<String, String> userMap) throws Exception {
        com.masspick.peak.resource.controller.vo.ApiResponse apiResponse = iUserService.modifyUserPass(account, userMap);
        return JacksonUtils.copyProperties(apiResponse, ApiResponseDTO.class);
    }

    /**
     * @param map map
     * @return SysUserDTO
     * @throws Exception Exception
     */
    @Override
    public ApiResponse findByNameAndPassword(@RequestBody Map<String, String> map) throws Exception {
        String account = map.get("loginName");
        String password = MD5Util.md5Pwd(map.get("password"));
        SysUser accSysUser = iUserService.findByAccount(account);
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (accSysUser == null) {
            apiResponse.setCode("ERR-404").setReason("用户不存在");
        } else if (!accSysUser.getPassword().equals(password)) {
            apiResponse.setCode("ERR-403").setReason("错误的用户密码");
        } else if (accSysUser.getStatus() == 0) {
            apiResponse.setCode("ERR-405").setReason("用户被禁用");
        } else {
            apiResponse.success().setResult(JacksonUtils.copyProperties(accSysUser, SysUserDTO.class));
        }
        return apiResponse;
    }

    /**
     * @param roleName
     * @param areaName
     * @return List
     * @throws Exception Exception
     */
    @Override
    public List<SysUserDTO> findUserByRoleAndAreaName(String roleName, String areaName) throws Exception {
        List<SysUser> users = iUserService.findUserByRoleAndAreaName(roleName, areaName);
        List<SysUserDTO> list = new ArrayList<>();
        for (SysUser user : users) {
            SysUserDTO dto = JacksonUtils.copyProperties(user, SysUserDTO.class);
            list.add(dto);
        }
        return list;
    }

    /**
     * @return ApiResponseDTO
     * @throws Exception Exception
     */
    @Override
    public ApiResponseDTO userInfo() throws Exception {
        ApiResponseDTO apiResponse = ApiResponseDTO.getInstances();
        String account = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
        SysUser sysUser = iUserService.findByAccount(account);
        return apiResponse.success().setResult(sysUser);
    }
}
