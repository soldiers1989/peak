package com.masspick.peak.resource.service.impl;

import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.config.constant.CommonConstant;
import com.masspick.peak.resource.config.constant.TreeConstant;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysDepartment;
import com.masspick.peak.resource.mapper.SysDepartmentMapper;
import com.masspick.peak.resource.service.IDepartmentService;
import com.masspick.peak.resource.utils.RmDisableDepartment;
import com.masspick.peak.resource.vo.DepartmentShowVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.Date;
import java.util.List;

/**
 * DepartmentServiceImpl
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    /**
     * sysDepartmentMapper
     */
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    /**
     * @return
     */
    @Override
    public ApiResponse findAllDepartment() {
        LOGGER.info("com in findDepartment");
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<SysDepartment> sysDepartmentList = sysDepartmentMapper.findList();
        apiResponse.success().setResult(sysDepartmentList);
        LOGGER.info("findAllDepartment result, departmentList : " + sysDepartmentList.toString());
        LOGGER.info("end in findDepartment");
        return apiResponse;
    }

    /**
     * @return
     */
    @Override
    public ApiResponse findAllAbleDepartment() {
        LOGGER.info("com in findAllAbleDepartment");
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<DepartmentShowVo> sysDepartmentList = sysDepartmentMapper.findShowList();
        LOGGER.info("findAllAbleDepartment result, allDepartmentList : " + sysDepartmentList.toString());
        //移除禁用的部门
        List<DepartmentShowVo> handleList = new RmDisableDepartment().handDepartmentList(sysDepartmentList,
                CommonConstant.ABLE_STATUS);
        LOGGER.info("rmDisableDepartment result, ableDepartmentList : " + sysDepartmentList.toString());

        apiResponse.success().setResult(handleList);
        LOGGER.info("end in findAllAbleDepartment");
        return apiResponse;
    }

    /**
     * @param id id
     * @return
     */
    @Override
    public ApiResponse findAllDepartmentExceptSelf(String id) {
        LOGGER.info("com in findAllDepartmentExceptSelf");
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<DepartmentShowVo> sysDepartmentList = sysDepartmentMapper.editDep(id);
        //移除当前部门和子级部门
        /*List<DepartmentShowVo> currentList = sysDepartmentMapper.findChildrenById(id);
        LOGGER.info("currentList = " + currentList.toString());
        for (DepartmentShowVo departmentShowVo : currentList) {
            sysDepartmentList.remove(departmentShowVo);
        }
        LOGGER.info("rm currentList result = " + sysDepartmentList.toString());*/
        apiResponse.success().setResult(sysDepartmentList);
        LOGGER.info("end in findAllDepartmentExceptSelf");
        return apiResponse;
    }

    /**
     * @param sysDepartment sysDepartment
     * @param bindingResult bindingResult
     * @return
     */
    @Override
    public ApiResponse addDepartment(SysDepartment sysDepartment, BindingResult bindingResult) {
        LOGGER.info("com in addDepartment, request params = " + sysDepartment.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        //获取排序编码
        String parentId = sysDepartment.getParentId();
        String parentCode;
        //为空则为顶级部门
        if (StringUtils.isEmpty(parentId.trim())) {
            parentCode = "";
        } else {
            SysDepartment parentDepartment = sysDepartmentMapper.findOne(parentId);
            parentCode = parentDepartment.getCode();
        }
        String code = getCode(parentCode, sysDepartment.getSort());
        SysDepartment codeDepartment = sysDepartmentMapper.findByCode(code);
        //排序唯一性约束
        if (codeDepartment != null) {
            LOGGER.info("sort is exist already");
            return apiResponse.error("401").setReason("排序已存在，请重新输入");
        }
        if (StringUtils.isEmpty(parentId.trim())) {
            sysDepartment.setParentId(null);
        }

        Integer level = getLevel(code);
        sysDepartment.preInsert();
        sysDepartment.setCode(code);
        sysDepartment.setLevel(level);
        LOGGER.info("insert params, params = " + sysDepartment.toString());
        sysDepartmentMapper.insert(sysDepartment);

        LOGGER.info("end in addDepartment");
        return apiResponse.success().setResult(sysDepartment);
    }

    /**
     * Integer
     *
     * @param code parentCode
     * @return Integer
     */
    public Integer getLevel(String code) {
        return (code.length() / TreeConstant.CHILD_CODE_LENGTH);
    }

    /**
     * @param parentCode parentCode
     * @param sort       sort
     * @return String
     */
    public String getCode(String parentCode, Integer sort) {
        return parentCode + String.format(TreeConstant.SUB_FORMAT_PATTERN, sort);
    }

    /**
     * @param id     id
     * @param status status
     * @return
     */
    @Override
    public ApiResponse modifyDepartStatus(String id, Integer status) {
        LOGGER.info("com in modifyDepartStatus , requestParams : id = " + id + ", status = " + status);
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (status == null) {
            return apiResponse.error("401").setReason("应用状态不能为空");
        }
        SysDepartment sysDepartment = sysDepartmentMapper.findOne(id);
        if (sysDepartment == null) {
            LOGGER.info("sysDepartment is not exist");
            apiResponse.error("401").setReason("应用不存在");
        } else {
            sysDepartment.setStatus(status);
            sysDepartment.setUpdateDate(new Date());
            LOGGER.info("insert params, params = " + sysDepartment.toString());
            sysDepartmentMapper.update(sysDepartment);
            sysDepartment = sysDepartmentMapper.findOne(id);
            apiResponse.success().setResult(sysDepartment);
        }
        LOGGER.info("end in modifyDepartStatus");
        return apiResponse;
    }

    /**
     * @param id id
     * @return
     */
    @Override
    public ApiResponse findOneDepartment(String id) {
        LOGGER.info("com in findOneDepartment , requestParams : id = " + id);
        ApiResponse apiResponse = ApiResponse.getInstances();
        SysDepartment sysDepartment = sysDepartmentMapper.findOne(id);
        LOGGER.info("findOneDepartment result : " + sysDepartment.toString());
        LOGGER.info("end in findOneDepartment");
        return apiResponse.success().setResult(sysDepartment);
    }

    /**
     * @param id            id
     * @param sysDepartment sysDepartment
     * @param bindingResult bindingResult
     * @return
     */
    @Override
    @Transactional
    public ApiResponse modifyDepartment(String id, SysDepartment sysDepartment, BindingResult bindingResult) {
        LOGGER.info("com in modifyDepartment, request params = " + sysDepartment.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        SysDepartment department = sysDepartmentMapper.findOne(id);
        if (department == null) {
            LOGGER.error("department is not exist");
            return apiResponse.error("401").setReason("部门不存在");
        }

        String parentId = sysDepartment.getParentId();
        SysDepartment parentDepartment = null;
        String parentCode = "";
        if (!StringUtils.isEmpty(parentId.trim())) {
            parentDepartment = sysDepartmentMapper.findOne(parentId);
            if (parentDepartment == null) {
                LOGGER.info("department is not exist");
                return apiResponse.error("401").setReason("选择的父级部门不存在，请重新选择");
            }
            if (parentDepartment.getStatus() == CommonConstant.DISABLE_STATUS && !parentId.equals(department
                    .getParentId())) {
                LOGGER.info("department is not able");
                return apiResponse.error("401").setReason("所选部门已被禁用，请重新选择");
            }

            if (!(parentId.equals(department.getParentId())) && sysDepartmentMapper.findUnableParentCount(parentDepartment.getParentId()) > 0) {
                LOGGER.info("department's parent is not able");
                return apiResponse.error("401").setReason("所选部门的上级部门已被禁用，请重新选择");
            }
            parentId = parentDepartment.getId();
            parentCode = parentDepartment.getCode();
        } else {
            parentId = null;
        }

        String code = getCode(parentCode, sysDepartment.getSort());
        SysDepartment codeDepartment = sysDepartmentMapper.findByCode(code);
        if (codeDepartment != null && !codeDepartment.getId().equals(id)) {
            return apiResponse.error("401").setReason("排序已存在，请重新输入");
        }
        SysDepartment dbSysDepartment = sysDepartmentMapper.findOne(id);
        //修改子级与自己的code，level
        sysDepartmentMapper.updateChildren(code, dbSysDepartment.getLevel(), id);
        SysDepartment changeDbSysDepartment = sysDepartmentMapper.findOne(id);
        sysDepartment.setCode(changeDbSysDepartment.getCode());
        sysDepartment.setLevel(changeDbSysDepartment.getLevel());
        sysDepartment.setParentId(parentId);
        sysDepartment.setUpdateDate(new Date());
        sysDepartmentMapper.update(sysDepartment);
        LOGGER.info("end in modifyDepartment");
        return apiResponse.success().setResult(sysDepartment);
    }

}
