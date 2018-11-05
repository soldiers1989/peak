package com.masspick.peak.guest.service;

import com.masspick.peak.guest.controller.vo.BaseVo;
import com.masspick.peak.guest.controller.vo.LocationVo;
import com.masspick.peak.guest.controller.vo.PicInfoVo;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * IHomeService
 */
public interface IHomeService {

    /**
     * 获取微信信息
     * @param code code
     * @return ApiResponse
     */
    ApiResponse getUserWebChatInfo(String code);

    /**
     * 获取所在市
     * @param location 坐标
     * @return ApiResponse
     */
    ApiResponse findCityByLocation(LocationVo location, BindingResult bindingResult);

    /**
     * 文件上传
     * @param file 文件
     * @return ApiResponse
     */
    ApiResponse uploadPic(MultipartFile file);

    /**
     * 文件上传
     * @param file 文件
     * @return ApiResponse
     */
    ApiResponse uploadHtmlPic(String file);

    /**
     *  ocr识别
     * @param picInfoVo 图片信息
     * @return ApiResponse
     */
    ApiResponse getPictureInfo(PicInfoVo picInfoVo, BindingResult bindingResult);

    /**
     * 获取手机验证码
     * @param mobile 手机号
     * @return ApiResponse
     */
    ApiResponse getSmsCode(String mobile);

    /**
     *  校验手机号和验证码
     * @param mobile 手机号
     * @param smsCode 验证码
     * @return ApiResponse
     */
    ApiResponse verSmsCode(String mobile, String smsCode);

    /**
     * 查询消息
     * @param userId 用户id
     * @return ApiResponse
     */
    ApiResponse findMessagesByUserId(String userId);

    /**
     * 标记消息已读
     * @param id id
     * @return ApiResponse
     */
    ApiResponse readMessage(String id);

    /**
     *  删除消息
     * @param id 消息id
     * @return  ApiResponse
     */
    ApiResponse deleteMessage(String id);

    /**
     *  获取用户手机号
     * @param baseVo baseVo
     * @return ApiResponse
     */
    ApiResponse getUserMobile(BaseVo baseVo);

    /**
     * 下载图片
     * @param imageUrl imageUrl
     * @return String
     */
    String downloadImage(String imageUrl);

    /**
     * 文件压缩
     * @param zipFile zipFile
     * @return String
     */
    String uploadFile(File zipFile);

    /**
     *  获取所有可用的产品
     * @return  List<String>
     */
    List<String> findAllAbleProducts();

    /**
     *
     * @param productId 产品id
     * @param data 数据
     * @return
     */
    Map<String, String> getRateMap(String productId, Map<String, Object> data);
}
