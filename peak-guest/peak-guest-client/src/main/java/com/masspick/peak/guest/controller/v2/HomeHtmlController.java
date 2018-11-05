package com.masspick.peak.guest.controller.v2;

import com.masspick.peak.common.util.HeaderUtil;
import com.masspick.peak.guest.common.constant.CommonConstant;
import com.masspick.peak.guest.controller.vo.LocationVo;
import com.masspick.peak.guest.controller.vo.PicInfoVo;
import com.masspick.peak.guest.model.UserWeiXin;
import com.masspick.peak.guest.service.IHomeService;
import com.masspick.peak.guest.service.IUserService;
import com.masspick.peak.guest.vo.ApiResponse;
import com.masspick.peak.service.IProductFeignApi;
import com.masspick.peak.service.dto.SysProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 首页和消息接口
 */
@CrossOrigin
@RestController
@RequestMapping("/v2/app/pre")
public class HomeHtmlController {

    /**
     * IHomeService
     */
    @Autowired
    private IHomeService homeService;
    /**
     * productFeignApi
     */
    @Autowired
    private IProductFeignApi productFeignApi;
    /**
     * httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;
    /**
     *  iUserService
     */
    @Autowired
    private IUserService iUserService;

    /**
     * 通过经纬度获取城市信息
     * @param location 经纬度对象
     * @return ApiResponse
     */
    @GetMapping(value = "/city")
    public ApiResponse findCityByLocation(@Valid LocationVo location, BindingResult bindingResult) {
        return homeService.findCityByLocation(location, bindingResult);
    }


    /**
     * 上传上传视频
     * @param file 文件
     * @return ApiResponse
     */
    @PostMapping(value = "/uploadFile")
    public ApiResponse uploadPic(@RequestParam("file") MultipartFile file) {
        return homeService.uploadPic(file);
    }

    /**
     *  上传图片
     * @param params params
     * @return ApiResponse
     */
    @PostMapping(value = "/upload")
    public ApiResponse uploadPic(@RequestBody Map<String, String> params) {
        return homeService.uploadHtmlPic(params.get("file"));
    }


    /**
     * 识别图片信息 ocr 营业执照 身份证 名片
     * @param picInfoVo 图片信息
     * @return ApiResponse
     */
    @PostMapping(value = "/info")
    public ApiResponse pictureInfo(@Valid @RequestBody PicInfoVo picInfoVo, BindingResult bindingResult) {
        return homeService.getPictureInfo(picInfoVo, bindingResult);
    }


    /**
     * 获取手机验证码
     * @param mobile 手机号
     * @return ApiResponse
     */
    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping(value = "/smsCode")
    public ApiResponse getSmsCode(String mobile) {
        return homeService.getSmsCode(mobile);
    }

    /**
     *  校验验证码是否正确
     * @param mobile 手机号
     * @param smsCode 手机验证码
     * @return ApiResponse
     */
    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping(value = "/verSmsCode")
    public ApiResponse verSmsCode(String mobile, String smsCode) {
        return homeService.verSmsCode(mobile, smsCode);
    }


    /**
     * 查询消息
     * @return ApiResponse
     */
    @GetMapping(value = "/messages")
    public ApiResponse findMessagesByUserId() {
        ApiResponse apiResponse = ApiResponse.getInstances();
        try {
            String moible = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
            UserWeiXin userWeiXin = iUserService.findUserByMobile(moible);
            if (userWeiXin == null) {
                return apiResponse.error("401").setReason("该用户不存在");
            }
            return homeService.findMessagesByUserId(userWeiXin.getId());
        } catch (Exception e) {
            return apiResponse.error("402").setReason("获取用户账号失败");
        }
    }

    /**
     *  标记信息已读
     * @param id id
     * @return ApiResponse
     */
    @PutMapping(value = "/messages/{id}")
    public ApiResponse readMessage(@PathVariable("id") String id) {
        return homeService.readMessage(id);
    }

    /**
     *  删除信息
     * @param id id
     * @return ApiResponse
     */
    @DeleteMapping(value = "/messages/{id}")
    public ApiResponse deleteMessage(@PathVariable("id") String id) {
        return homeService.deleteMessage(id);
    }

    /**
     * 获取所有启用的的产品
     * @return ApiResponse
     */
    @GetMapping(value = "/products")
    public ApiResponse findAllAbleProducts() {
        ApiResponse apiResponse = ApiResponse.getInstances();
        try {
            List<String> idList = homeService.findAllAbleProducts();
            List<SysProductDTO> productAllList = productFeignApi.findByIdList(idList);
            List<SysProductDTO> productAbleList = new ArrayList<>();
            for (int i = 0;i < productAllList.size();i++) {
                if (productAllList.get(i).getStatus() == CommonConstant.ABLE_STATUS) {
                    productAbleList.add(productAllList.get(i));
                }
            }
            return apiResponse.success().setResult(productAbleList);
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponse.error("400").setReason("获取产品信息失败");
        }
    }
}
