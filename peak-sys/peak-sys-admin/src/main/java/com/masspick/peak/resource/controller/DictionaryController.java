package com.masspick.peak.resource.controller;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.anno.Log;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.controller.vo.SysDictionaryVO;
import com.masspick.peak.resource.entity.SysDictionary;
import com.masspick.peak.resource.service.IDictionaryService;
import com.masspick.peak.resource.utils.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018/7/31 0031.
 * <p>
 * 字典控制层
 */
@RestController
@RequestMapping("/v1/resource")
@Validated
public class DictionaryController {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryController.class);

    /***
     * iDictionaryService
     */
    @Autowired
    private IDictionaryService iDictionaryService;


    /**
     * 查询字典 分页
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @param name     name
     * @param status   status
     * @param code     code
     * @return ApiResponse
     */
    @GetMapping("/dictionary")
    public ApiResponse dataGrid(
            @NotNull(message = "页码不能为空")
            @RequestParam(name = "pageNum", required = true) Integer pageNum,
            @NotNull(message = "页数不能为空")
            @RequestParam(name = "pageSize", required = true) Integer pageSize,
            String name, Integer status, String code) {
        LOGGER.info("---->dictionary dataGrid params name={} status={} pageNum={} pageSize={} <----",
                name, status, pageNum, pageSize);

        ApiResponse apiResponse = ApiResponse.getInstances();
        return apiResponse.success(iDictionaryService.dataGrid(pageNum, pageSize, name, status, code));
    }

    /**
     * 插入字典
     *
     * @param sysDictionaryVO sysDictionaryVO
     * @param bindingResult   bindingResult
     * @return ApiResponse
     */
    @Log("添加字典/字典项")
    @PostMapping("/dictionary")
    public ApiResponse create(@Valid @RequestBody SysDictionaryVO sysDictionaryVO, BindingResult bindingResult) {
        LOGGER.info("---->dictionary create params code={} name={} parentId={} remark={} status={} sort={}<----",
                sysDictionaryVO.getCode(), sysDictionaryVO.getName(), sysDictionaryVO.getParentId(),
                sysDictionaryVO.getRemark(), sysDictionaryVO.getStatus(), sysDictionaryVO.getSort());

        ResultEnum resultEnum;
        ApiResponse apiResponse = ApiResponse.getInstances();

        //校验参数必填
        if (bindingResult.hasErrors()) {
            resultEnum = ResultEnum.PARAMS_ERROR;
            return apiResponse.error(resultEnum.getCode(), bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        //校验code 是否唯一
        SysDictionary dbSysDictionary = null;

        //parentId 为空时
        if (StringUtils.isEmpty(sysDictionaryVO.getParentId())) {
            dbSysDictionary = iDictionaryService.findByCode(sysDictionaryVO.getCode(), sysDictionaryVO.getName());
            if (dbSysDictionary != null) {
                resultEnum = ResultEnum.PARAM_EXIST;
                return apiResponse.setCode(resultEnum.getCode()).setReason("字典编码或名称已存在!!!");
            }
            //parentId 不为空时
        } else {
            List<SysDictionary> dbSysDictionaryList  = iDictionaryService.findByCodeAndParentId(sysDictionaryVO.getCode(), sysDictionaryVO
                    .getName(), sysDictionaryVO.getParentId(), null);
            if (!CollectionUtils.isEmpty(dbSysDictionaryList)) {
                resultEnum = ResultEnum.PARAM_EXIST;
                return apiResponse.setCode(resultEnum.getCode()).setReason("当前字典项中编码或名称已存在!!!");
            }
        }

        //转换参数
        SysDictionary sysDictionary = JacksonUtils.copyProperties(sysDictionaryVO, SysDictionary.class);
        iDictionaryService.create(sysDictionary);
        return apiResponse.success(sysDictionary);
    }

    /**
     * 修改字典
     *
     * @param id              id
     * @param sysDictionaryVO sysDictionaryVO
     * @param bindingResult   bindingResult
     * @return ApiResponse
     */
    @Log("修改字典/字典项")
    @PutMapping("/dictionary/{id}")
    public ApiResponse update(@PathVariable("id") String id, @Valid @RequestBody SysDictionaryVO sysDictionaryVO,
                              BindingResult bindingResult) {
        LOGGER.info("---->dictionary update params id={} code={} name={} remark={} status={} sort={}<----", id,
                sysDictionaryVO.getCode(), sysDictionaryVO.getName(), sysDictionaryVO.getRemark(), sysDictionaryVO
                        .getStatus(), sysDictionaryVO.getSort());
        ApiResponse apiResponse = ApiResponse.getInstances();
        ResultEnum resultEnum;

        //校验参数必填
        if (bindingResult.hasErrors()) {
            resultEnum = ResultEnum.PARAMS_ERROR;
            return apiResponse.error(resultEnum.getCode(), bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        //根据id查询数据
        SysDictionary sysDictionary = iDictionaryService.findById(id);
        if (sysDictionary == null) {
            resultEnum = ResultEnum.ID_IS_NOT_EXIST;
            return apiResponse.setCode(resultEnum.getCode()).setReason(resultEnum.getReason());
        }


        //校验code 是否唯一
        SysDictionary dbSysDictionary = null;

        //parentId 为空时
        if (StringUtils.isEmpty(sysDictionaryVO.getParentId())) {
            dbSysDictionary = iDictionaryService.findByCode(sysDictionaryVO.getCode(), sysDictionaryVO.getName());
            if (dbSysDictionary != null && !dbSysDictionary.getId().equals(id)) {
                resultEnum = ResultEnum.PARAM_EXIST;
                return apiResponse.setCode(resultEnum.getCode()).setReason("字典编码或名称已存在!!!");
            }
            //parentId 不为空时
        } else {
            List<SysDictionary> dbSysDictionaryList = iDictionaryService.findByCodeAndParentId(sysDictionaryVO.getCode(), sysDictionaryVO
                    .getName(), sysDictionaryVO.getParentId(), id);
            if (!CollectionUtils.isEmpty(dbSysDictionaryList)) {
                resultEnum = ResultEnum.PARAM_EXIST;
                return apiResponse.setCode(resultEnum.getCode()).setReason("当前字典项中编码或名称已存在!!!");
            }
        }


        //修改属性
        sysDictionary.setCode(sysDictionaryVO.getCode());
        sysDictionary.setName(sysDictionaryVO.getName());
        sysDictionary.setRemark(sysDictionaryVO.getRemark());
        sysDictionary.setSort(sysDictionaryVO.getSort());
        sysDictionary.setStatus(sysDictionaryVO.getStatus());
        sysDictionary.setUpdateDate(new Date());
        iDictionaryService.update(sysDictionary);
        return apiResponse.success(sysDictionary);
    }

    /**
     * 更改字典状态
     *
     * @param id            id
     * @param sysDictionary sysDictionary
     * @return ApiResponse
     */
    @Log("更新字典/字典项")
    @PatchMapping("/dictionary/{id}")
    public ApiResponse patch(@PathVariable("id") String id, @RequestBody SysDictionary sysDictionary) {
        LOGGER.info("---->dictionary patch params id={} status={}<----", id, sysDictionary.getStatus());

        ApiResponse apiResponse = ApiResponse.getInstances();
        ResultEnum resultEnum;

        //根据id查询数据
        SysDictionary dbSysDictionary = iDictionaryService.findById(id);
        if (dbSysDictionary == null) {
            resultEnum = ResultEnum.ID_IS_NOT_EXIST;
            return apiResponse.setCode(resultEnum.getCode()).setReason(resultEnum.getReason());
        }
        dbSysDictionary.setCode(StringUtils.isEmpty(sysDictionary.getCode()) ? dbSysDictionary.getCode()
                : sysDictionary.getCode());
        dbSysDictionary.setName(StringUtils.isEmpty(sysDictionary.getName()) ? dbSysDictionary.getName()
                : sysDictionary.getName());
        dbSysDictionary.setRemark(StringUtils.isEmpty(sysDictionary.getRemark()) ? dbSysDictionary.getRemark()
                : sysDictionary.getRemark());
        dbSysDictionary.setSort(sysDictionary.getSort() == null ? dbSysDictionary.getSort()
                : sysDictionary.getSort());
        dbSysDictionary.setStatus(sysDictionary.getStatus() == null ? dbSysDictionary.getStatus() : sysDictionary
                .getStatus());
        dbSysDictionary.setUpdateDate(new Date());
        iDictionaryService.update(dbSysDictionary);
        return apiResponse.success(dbSysDictionary);
    }

    /**
     * 查询字典项
     *
     * @param id id
     * @return ApiResponse
     */
    @GetMapping("/dictionary/{id}")
    public ApiResponse getDictionary(@PathVariable("id") String id) {
        LOGGER.info("---->dictionary getDictionary params id={} <----", id);
        return ApiResponse.getInstances().success(iDictionaryService.findById(id));
    }

    /**
     * 查询字典项
     *
     * @param parentId parentId
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @param name     name
     * @param status   status
     * @return ApiResponse
     */
    @GetMapping("/dictionary/item/{parentId}")
    public ApiResponse itemList(
            @PathVariable("parentId") String parentId,
            @NotNull(message = "页码不能为空")
            @RequestParam(name = "pageNum", required = true) Integer pageNum,
            @NotNull(message = "页数不能为空")
            @RequestParam(name = "pageSize", required = true) Integer pageSize,
            String name, Integer status) {
        LOGGER.info("---->dictionary dataGrid params parentId={} name={} status={} pageNum={} pageSize={} <----",
                parentId, name, status, pageNum, pageSize);

        ApiResponse apiResponse = ApiResponse.getInstances();
        return apiResponse.success(iDictionaryService.findByParentCode(parentId, pageNum, pageSize, name, status));
    }
}
