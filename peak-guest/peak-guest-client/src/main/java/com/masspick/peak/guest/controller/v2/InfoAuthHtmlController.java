package com.masspick.peak.guest.controller.v2;

import com.masspick.peak.common.util.HeaderUtil;
import com.masspick.peak.guest.controller.BaseController;
import com.masspick.peak.guest.controller.vo.BaseVo;
import com.masspick.peak.guest.model.InfoAuth;
import com.masspick.peak.guest.model.UserWeiXin;
import com.masspick.peak.guest.service.IInfoAuthService;
import com.masspick.peak.guest.service.IUserService;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URLDecoder;

/**
 * 信息采集授权
 */
@RestController
@RequestMapping("/v2/app/pre")
public class InfoAuthHtmlController extends BaseController {

    /**
     * infoAuthService
     */
    @Autowired
    private IInfoAuthService infoAuthService;

    /**
     *  userService
     */
    @Autowired
    private IUserService iUserService;

    /**
     *  httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     *  发送邮件
     * @param baseVo baseVo
     * @return ApiResponse
     */
    @PostMapping(value = "/email")
    public ApiResponse sendEmail(@RequestBody BaseVo baseVo) {
        return infoAuthService.sendEmail(baseVo);
    }

    /**
     *  信息采集授权添加
     * @param infoAuth 信息采集授权信息
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @PostMapping(value = "/infoAuth")
    public ApiResponse addEtpStepTwo(@Valid @RequestBody InfoAuth infoAuth, BindingResult bindingResult) {
        try {
            String moible = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
            UserWeiXin userWeiXin = iUserService.findUserByMobile(moible);
            if (userWeiXin  == null) {
                return ApiResponse.getInstances().error("401").setReason("该用户不存在");
            }
            infoAuth.setUserId(userWeiXin.getId());
            return infoAuthService.addInfoAuth(infoAuth, bindingResult);
        } catch (Exception e) {
            return ApiResponse.getInstances().error("402").setReason("获取用户账号失败");
        }
    }

    /**
     * 通过企业资质认证id查询信息采集授权
     * @param etpCerId etpCerId
     * @return ApiResponse
     */
    @GetMapping(value = "/infoAuths/etpCers/{etpCerId}")
    public ApiResponse findInfoAuthByEtpCerId(@PathVariable("etpCerId") String etpCerId) {
        return infoAuthService.findInfoAuthByEtpCerId(etpCerId);
    }

}
