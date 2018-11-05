package com.masspick.peak.guest.controller.v2;

import com.masspick.peak.common.util.HeaderUtil;
import com.masspick.peak.common.util.StringHelper;
import com.masspick.peak.guest.controller.BaseController;
import com.masspick.peak.guest.model.UserWeiXin;
import com.masspick.peak.guest.service.IUserService;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.Map;

/**
 * UserController
 */
@RestController
@RequestMapping("/v2/app/pre")
public class UserHtmlController extends BaseController {


    /**
     * userService
     */
    @Autowired
    private IUserService iUserService;

    /**
     * httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     *  用户查询
     * @return ApiResponse
     */
    @GetMapping(value = "/users")
    public ApiResponse findUserByMobile() {
        ApiResponse apiResponse = ApiResponse.getInstances();
        try {
            String moible = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
            UserWeiXin userWeiXin = iUserService.findUserByMobile(moible);
            if (userWeiXin  == null) {
                return apiResponse.error("401").setReason("该用户不存在");
            }
            return apiResponse.success().setResult(userWeiXin);
        } catch (Exception e) {
            return apiResponse.error("402").setReason("获取用户账号失败");
        }
    }

    /**
     *  h5端添加用户
     * @return ApiResponse
     */
    @PostMapping(value = "/user")
    public ApiResponse saveUser(@RequestBody Map<String, String> userMap) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        try {
            String moible = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
            if (moible == null || StringHelper.isEmpty(moible)) {
                return apiResponse.error("401").setReason("该用户不存在");
            }
            UserWeiXin userWeiXin = new UserWeiXin();
            if (StringHelper.isNotEmpty(userMap.get("insStaffNum"))) {
                userWeiXin.setInsStaffNum(userMap.get("insStaffNum"));
            }
            userWeiXin.setMobile(moible);
            return apiResponse.success().setResult(iUserService.saveUser(userWeiXin));
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponse.error("402").setReason("获取用户账号失败");
        }
    }
}
