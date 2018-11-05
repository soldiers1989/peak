package com.masspick.peak.resource.controller;

import com.masspick.peak.resource.anno.Log;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysDepartment;
import com.masspick.peak.resource.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 部门管理
 */
@RestController
@RequestMapping("/v1/resource")
public class DepartmentController {

    /**
     * departmentService
     */
    @Autowired
    private IDepartmentService departmentService;

    /**
     * 部门获取
     *
     * @return ApiResponse
     */
    @GetMapping("/department")
    public ApiResponse findAllDepartment() {
        return departmentService.findAllDepartment();
    }

    /**
     *  添加部门获取部门列表
     * @return ApiResponse
     */
    @GetMapping("/department/status")
    public ApiResponse findAllAbleDepartment() {
        return departmentService.findAllAbleDepartment();
    }


    /**
     *  编辑部门获取所有部门
     * @param id id
     * @return ApiResponse
     */
    @GetMapping("/department/edit")
    public ApiResponse editFindAllDepartment(String id) {
        return departmentService.findAllDepartmentExceptSelf(id);
    }


    /**
     * 部门添加
     *
     * @param sysDepartment sysDepartment
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("添加部门")
    @PostMapping("/department")
    public ApiResponse addDepartment(@Valid @RequestBody SysDepartment sysDepartment, BindingResult bindingResult) {
        return departmentService.addDepartment(sysDepartment, bindingResult);
    }

    /**
     * 禁用或启用部门
     *
     * @param id            id
     * @param sysDepartment sysDepartment
     * @return ApiResponse
     */
    @Log("禁用或启用部门")
    @PatchMapping("/department/{id}")
    public ApiResponse addDepartment(@PathVariable("id") String id, @RequestBody SysDepartment sysDepartment) {
        return departmentService.modifyDepartStatus(id, sysDepartment.getStatus());
    }

    /**
     * 查看部门
     *
     * @param id id
     * @return ApiResponse
     */
    @GetMapping("/department/{id}")
    public ApiResponse findOneDepartment(@PathVariable("id") String id) {
        return departmentService.findOneDepartment(id);
    }

    /**
     * 修改部门
     *
     * @param id            id
     * @param sysDepartment sysDepartment
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("修改部门")
    @PutMapping("/department/{id}")
    public ApiResponse findOneDepartment(@PathVariable("id") String id, @Valid @RequestBody SysDepartment
            sysDepartment, BindingResult bindingResult) {
        return departmentService.modifyDepartment(id, sysDepartment, bindingResult);
    }
}
