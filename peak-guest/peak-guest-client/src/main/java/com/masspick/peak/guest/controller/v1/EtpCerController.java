package com.masspick.peak.guest.controller.v1;


import com.masspick.peak.guest.controller.BaseController;
import com.masspick.peak.guest.controller.vo.EtpCerAddVo;
import com.masspick.peak.guest.controller.vo.LiveDetectVo;
import com.masspick.peak.guest.service.IEtpCerService;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 企业资质认证
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/app/pre")
public class EtpCerController extends BaseController {

    /**
     * etpCerService
     */
    @Autowired
    private IEtpCerService etpCerService;

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
        return etpCerService.enterpriseCer(etpCerAddVo, bindingResult);
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
     * @param userId 用户id
     * @param status 状态
     * @return  ApiResponse
     */
    @GetMapping(value = "/etpCers")
    public ApiResponse findEtpCerList(String userId, String status) {
        return etpCerService.findEtpCerList(userId, status);
    }

    /**
     * 分页显示巅峰人员拉取的公司
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return ApiResponse
     */
    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping(value = "/etpCer/invite")
    public ApiResponse findEtpByPage(@NotNull(message = "页码不能为空")
                                      @RequestParam(name = "pageNum") Integer pageNum,
                                     @NotNull(message = "页数不能为空")
                                      @RequestParam(name = "pageSize") Integer pageSize, HttpServletRequest request){
        String number = request.getHeader("number");
        //after page
        return etpCerService.findEtpByPage(pageNum,pageSize,number);
    }

}
