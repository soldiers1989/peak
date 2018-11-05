package com.masspick.peak.guest.controller.v1;

import com.masspick.peak.guest.controller.vo.BaseVo;
import com.masspick.peak.guest.controller.vo.LocationVo;
import com.masspick.peak.guest.controller.vo.PicInfoVo;
import com.masspick.peak.guest.service.IHomeService;
import com.masspick.peak.guest.vo.ApiResponse;
import com.masspick.peak.service.IProductFeignApi;
import com.masspick.peak.service.dto.SysProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * 首页和消息接口
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/app/pre")
public class HomeController {

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
     * 查询基本信息
     * @param code code
     * @return ApiResponse
     */
    @GetMapping(value = "/{code}/info")
    public ApiResponse getUserWebChatInfo(@PathVariable("code") String code) {
        return homeService.getUserWebChatInfo(code);
    }


    /**
     * 获取用户手机号
     * @param baseVo baseVo
     * @return ApiResponse
     */
    @PostMapping(value = "/mobile")
    public ApiResponse getUserMobile(@RequestBody BaseVo baseVo) {
        return homeService.getUserMobile(baseVo);
    }

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
     * 上传图片
     * @param file 文件
     * @return ApiResponse
     */
    @PostMapping(value = "/upload")
    public ApiResponse uploadPic(@RequestParam("file") MultipartFile file) {
        return homeService.uploadPic(file);
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
     * @param userId 用户id
     * @return ApiResponse
     */
    @GetMapping(value = "/messages")
    public ApiResponse findMessagesByUserId(String userId) {
        return homeService.findMessagesByUserId(userId);
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
            List<SysProductDTO> productDTOList = productFeignApi.findByIdList(idList);
            return apiResponse.success().setResult(productDTOList);
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponse.error("400").setReason("获取产品信息失败");
        }
    }

}
