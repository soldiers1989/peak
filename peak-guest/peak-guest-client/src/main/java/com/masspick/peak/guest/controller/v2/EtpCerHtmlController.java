package com.masspick.peak.guest.controller.v2;


import com.masspick.peak.common.util.HeaderUtil;
import com.masspick.peak.guest.controller.BaseController;
import com.masspick.peak.guest.controller.vo.EtpCerAddVo;
import com.masspick.peak.guest.controller.vo.LiveDetectVo;
import com.masspick.peak.guest.model.UserWeiXin;
import com.masspick.peak.guest.service.IEtpCerService;
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
 * 企业资质认证
 */
@RestController
@RequestMapping("/v2/app/pre")
public class EtpCerHtmlController extends BaseController {

    /**
     * etpCerService
     */
    @Autowired
    private IEtpCerService etpCerService;

    /**
     * httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     *  userWeiXinMapper
     */
    @Autowired
    private IUserService iUserService;

    /**
     * 获取唇语验证码
     * @return ApiResponse
     */
    @GetMapping(value = "/lipCode")
    public ApiResponse validateData() {
        return etpCerService.validateData();
    }

    /**
     *  活体检测
     * @param liveDetectVo 活体检测对象
     * @return ApiResponse
     */
    @PostMapping(value = "/liveDetect")
    public ApiResponse liveDetect(@Valid @RequestBody LiveDetectVo liveDetectVo, BindingResult bindingResult) {
        return etpCerService.liveDetect(liveDetectVo, bindingResult);
    }

    /**
     * 企业资质认证
     * @param etpCerAddVo 企业资质认证添加对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @PostMapping(value = "/etpCer")
    public ApiResponse enterpriseCer(@Valid @RequestBody EtpCerAddVo etpCerAddVo, BindingResult bindingResult) {
        try {
            String moible = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
            UserWeiXin userWeiXin = iUserService.findUserByMobile(moible);
            if (userWeiXin == null) {
                return ApiResponse.getInstances().error("401").setReason("该用户不存在");
            }
            etpCerAddVo.setUserId(userWeiXin.getId());
            return etpCerService.enterpriseCer(etpCerAddVo, bindingResult);
        } catch (Exception e) {
            return ApiResponse.getInstances().error("402").setReason("获取用户账号失败");
        }
    }

    /**
     *  查找单条企业资质认证
     * @param id id
     * @return ApiResponse
     */
    @GetMapping(value = "/etpCers/{id}")
    public ApiResponse findOneEtpCer(@PathVariable("id") String id) {
        return etpCerService.findOneEtpCer(id);
    }

    /**
     *  多条企业资质认证查询
     * @param status 状态
     * @return  ApiResponse
     */
    @GetMapping(value = "/etpCers")
    public ApiResponse findEtpCerList(String status) {
        try {
            String moible = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
            UserWeiXin userWeiXin = iUserService.findUserByMobile(moible);
            if (userWeiXin == null) {
                return ApiResponse.getInstances().error("401").setReason("该用户不存在");
            }
            return etpCerService.findEtpCerList(userWeiXin.getId(), status);
        } catch (Exception e) {
            return ApiResponse.getInstances().error("402").setReason("获取用户账号失败");
        }
    }
}
