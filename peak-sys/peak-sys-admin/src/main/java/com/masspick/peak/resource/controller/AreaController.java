package com.masspick.peak.resource.controller;

import com.github.pagehelper.PageInfo;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.controller.vo.SysAreaVO;
import com.masspick.peak.resource.entity.SysArea;
import com.masspick.peak.resource.entity.bo.Node;
import com.masspick.peak.resource.service.IAreaService;
import com.masspick.peak.resource.utils.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by admin on 2018/7/31 0031.
 */
@RestController
@RequestMapping("/v1/resource")
public class AreaController {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AreaController.class);

    /**
     * iAreaService
     */
    @Autowired
    private IAreaService iAreaService;

    /**
     *
     * @param sysRegionVO sysRegionVO
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @GetMapping("/region")
    public ApiResponse dataGrid(@Valid SysAreaVO sysRegionVO, BindingResult bindingResult) {
        LOGGER.info("---->area dataGrid params code={} name={} cityCode={} zipCode={} pageNum={} pageSize={}<----",
                sysRegionVO.getCode(), sysRegionVO.getName(), sysRegionVO.getCityCode(), sysRegionVO.getZipCode(),
                sysRegionVO.getPageNum(), sysRegionVO.getPageSize());

        ApiResponse apiResponse = ApiResponse.getInstances();
        ResultEnum resultEnum;
        if (bindingResult.hasErrors()) {
            resultEnum = ResultEnum.PARAMS_ERROR;
            return apiResponse.error(resultEnum.getCode(), bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }


        //构建返回对象
        PageInfo<SysArea> pageInfo = iAreaService.dataGrid(sysRegionVO.getPageNum(), sysRegionVO
                .getPageSize(), sysRegionVO.getName(), sysRegionVO.getCode(), sysRegionVO.getCityCode(), sysRegionVO
                .getZipCode());

        return apiResponse.success(pageInfo);
    }

    /**
     *
     * @param userId userId
     * @return ApiResponse
     */
    /*@GetMapping("/region/{userId}/tree")
    public ApiResponse tree(@PathVariable("userId") String userId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<Node> nodes = iAreaService.findAll(userId);
        TreeUtil treeUtil = new TreeUtil();
        treeUtil.setNodeList(nodes);
        List<Object> list = treeUtil.child("100000");
        return apiResponse.success(list);
    }*/


    /**
     *
     * @param userId userId
     * @return ApiResponse
     */
    @GetMapping("/region/{userId}/tree")
    public ApiResponse tree(@PathVariable("userId") String userId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<Node> nodes = iAreaService.findAll(userId);
        return apiResponse.success(nodes);
    }

    /**
     *
     * @param userId userId
     * @param parentId parentId
     * @return ApiResponse
     */
    @GetMapping("/region/{userId}/{parentId}/tree")
    public ApiResponse asyncTree(@PathVariable("userId") String userId, @PathVariable("parentId") String parentId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<Node> nodes = iAreaService.findByParentId(userId, parentId);
        return apiResponse.success(nodes);
    }

}
