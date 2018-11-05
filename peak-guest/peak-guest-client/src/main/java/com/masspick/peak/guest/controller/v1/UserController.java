package com.masspick.peak.guest.controller.v1;

import com.masspick.peak.guest.controller.BaseController;
import com.masspick.peak.guest.model.UserWeiXin;
import com.masspick.peak.guest.service.IUserService;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * UserController
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/app/pre")
public class UserController extends BaseController {


    /**
     * userService
     */
    @Autowired
    private IUserService userService;

    /**
     * 添加用户信息
     * @param userWeiXin 用户信息
     * @return ApiResponse
     */
    @PostMapping(value = "/user")
    public ApiResponse addUser(@Valid @RequestBody UserWeiXin userWeiXin, BindingResult bindingResult) {
        return userService.saveUser(userWeiXin, bindingResult);
    }

    /**
     * 用户查询
     * @param openId 用户微信唯一标识
     * @return ApiResponse
     */
    @GetMapping(value = "/users")
    public ApiResponse findUserBy(String openId) {
        return userService.findUserByOpenId(openId);
    }


    /**
     * 巅峰用户对应公司贷款统计
     * @return ApiResponse
     */
    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping(value = "/user/count")
    public ApiResponse findUserLoanCount(HttpServletRequest request) {
        String number = request.getHeader("number");
        return userService.findUserCountByNumber(number);
    }
}
