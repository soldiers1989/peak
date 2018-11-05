package com.masspick.peak.resource.service;


import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysDepartment;
import org.springframework.validation.BindingResult;

/**
 * IDepartmentService
 */
public interface IDepartmentService {
    /**
     * @return ApiResponse
     */
    ApiResponse findAllDepartment();

    /**
     *
     * @return ApiResponse
     */
    ApiResponse findAllAbleDepartment();

    /**
     * @param id id
     * @return ApiResponse
     */
    ApiResponse findAllDepartmentExceptSelf(String id);

    /**
     * @param sysDepartment sysDepartment
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    ApiResponse addDepartment(SysDepartment sysDepartment, BindingResult bindingResult);

    /**
     * @param id     id
     * @param status status
     * @return ApiResponse
     */
    ApiResponse modifyDepartStatus(String id, Integer status);

    /**
     * @param id id
     * @return ApiResponse
     */
    ApiResponse findOneDepartment(String id);

    /**
     * @param id            id
     * @param sysDepartment sysDepartment
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    ApiResponse modifyDepartment(String id, SysDepartment sysDepartment, BindingResult bindingResult);
}
