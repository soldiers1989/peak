package com.masspick.peak.resource.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.model.ErrorCode;
import com.masspick.peak.common.util.HeaderUtil;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.anno.Log;
import com.masspick.peak.resource.config.SystemConfig;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysIns;
import com.masspick.peak.resource.entity.SysInsStaff;
import com.masspick.peak.resource.service.IInsService;
import com.masspick.peak.resource.utils.ZipUtils;
import com.masspick.peak.resource.vo.InsDataGridFindVo;
import com.masspick.peak.resource.vo.StaffDataGridFindVo;
import com.masspick.peak.resource.vo.StaffPageShowVo;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import static com.masspick.peak.common.model.ErrorCode.ERROR_404;

/**
 * 合作机构和机构人员
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/resource")
public class InsController {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IndustryController.class);
    /**
     * insService
     */
    @Autowired
    private IInsService insService;

    /**
     * systemConfig
     */
    @Autowired
    private SystemConfig systemConfig;

    /**
     * 分页查询合作机构
     *
     * @param insDataGridFindVo 分页查询对象
     * @param bindingResult     参数校验结果
     * @return ApiResponse
     */
    @GetMapping("institutions/dataGrid")
    ApiResponse findInsByPage(@Valid InsDataGridFindVo insDataGridFindVo, BindingResult bindingResult) {
        LOGGER.info("come in findInsByPage, request params = " + insDataGridFindVo.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        PageHelper.startPage(insDataGridFindVo.getPageNum(), insDataGridFindVo.getPageSize());
        List<SysIns> sysInsList = insService.findInsByPage(insDataGridFindVo);
        apiResponse.success().setResult(new PageInfo<>(sysInsList));
        LOGGER.info("end in findInsByPage, result = " + sysInsList.toString());
        return apiResponse;
    }

    /**
     * 添加查询所有机构
     *
     * @return ApiResponse
     */
    @GetMapping("/institutions/status")
    ApiResponse findAllIns() {
        LOGGER.info("come in findAllIns");
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<SysIns> sysInsList = insService.findAllAble();
        apiResponse.success().setResult(sysInsList);
        LOGGER.info("end in findAllIns, result = " + sysInsList.toString());
        return apiResponse;
    }

    /**
     * 编辑查询所有机构
     *
     * @return ApiResponse
     */
    @GetMapping("/institutions")
    ApiResponse findAllAbleIns() {
        LOGGER.info("come in findAllAbleIns");
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<SysIns> sysInsList = insService.findAll();
        apiResponse.success().setResult(sysInsList);
        LOGGER.info("end in findAllAbleIns, result = " + sysInsList.toString());
        return apiResponse;
    }


    /**
     * 添加合作机构
     *
     * @param sysIns        sysIns
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("添加合作机构")
    @PostMapping("/institution")
    ApiResponse addIns(@Valid @RequestBody SysIns sysIns, BindingResult bindingResult) {
        LOGGER.info("come in addIns, request params = " + sysIns.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        //参数校验
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        if (!insService.checkUniqueCode(sysIns)) {
            return apiResponse.error("401").setReason("机构编码已存在，请重新输入");
        }
        sysIns = insService.addSysIns(sysIns);
        apiResponse.success().setResult(sysIns);
        LOGGER.info("end in addIns, result = " + sysIns.toString());
        return apiResponse;
    }

    /**
     * 启用或禁用机构
     *
     * @param id     id
     * @param sysIns sysIns
     * @return ApiResponse
     */
    @Log("启用或禁用机构")
    @PatchMapping("/institutions/{id}")
    ApiResponse modifyInsStatus(@PathVariable("id") String id, @RequestBody SysIns sysIns) {
        LOGGER.info("come in modifyInsStatus, request params :  id = " + id);
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (sysIns == null || sysIns.getStatus() == null) {
            return apiResponse.error("400").setReason("状态不能为空");
        }

        sysIns.setId(id);
        sysIns = insService.modifyInsStatus(sysIns);
        apiResponse.success().setResult(sysIns);
        LOGGER.info("end in modifyInsStatus, result = " + sysIns.toString());
        return apiResponse;
    }


    /**
     * 查看单个合作机构
     *
     * @param id id
     * @return ApiResponse
     */
    @GetMapping("/institutions/{id}")
    ApiResponse findOneIns(@PathVariable("id") String id) {
        LOGGER.info("come in findOneIns, request id = " + id);
        ApiResponse apiResponse = ApiResponse.getInstances();
        SysIns sysIns = insService.findOneIns(id);
        apiResponse.success().setResult(sysIns);
        LOGGER.info("end in findOneIns, result = " + sysIns);
        return apiResponse;
    }

    /**
     * 更新合作机构
     *
     * @param id            id
     * @param sysIns        sysIns
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("更新合作机构")
    @PutMapping("/institutions/{id}")
    ApiResponse modifyIns(@PathVariable("id") String id, @Valid @RequestBody SysIns sysIns, BindingResult
            bindingResult) {
        LOGGER.info("come in modifyIns, request prams : id = " + id + ", sysIns = " + sysIns.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        if (!insService.checkUniqueCode(sysIns)) {
            return apiResponse.error("401").setReason("机构编码已存在，请重新输入");
        }
        sysIns.setId(id);
        sysIns = insService.modifyIns(sysIns);
        apiResponse.success().setResult(sysIns);
        return apiResponse;
    }

    /**
     * 分页查询机构人员
     *
     * @param staffDataGridFindVo 员工分页查询对象
     * @param bindingResult       bindingResult
     * @return ApiResponse
     */
    @GetMapping("/staffs")
    ApiResponse findStaffByPage(@Valid StaffDataGridFindVo staffDataGridFindVo, BindingResult bindingResult) {
        LOGGER.info("come in findStaffByPage, request params = " + staffDataGridFindVo);
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        PageHelper.startPage(staffDataGridFindVo.getPageNum(), staffDataGridFindVo.getPageSize());
        List<StaffPageShowVo> staffPageShowVos = insService.findByPage(staffDataGridFindVo);
        apiResponse.success().setResult(new PageInfo<>(staffPageShowVos));
        LOGGER.info("end in findStaffByPage, result = " + staffPageShowVos.toString());
        return apiResponse;
    }

    /**
     * 添加机构人员
     *
     * @param sysInsStaff   sysInsStaff
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("添加机构人员")
    @PostMapping("/staff")
    ApiResponse addInsStaff(@Valid @RequestBody SysInsStaff sysInsStaff, BindingResult bindingResult) {
        LOGGER.info("come in addInsStaff, requst sysInsStaff = " + sysInsStaff);
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        if (insService.findByMobile(sysInsStaff) != null) {
            return apiResponse.error("401").setReason("该手机号已被注册，请重新输入!");
        }
        sysInsStaff = insService.addInsStaff(sysInsStaff);
        apiResponse.success().setResult(sysInsStaff);
        LOGGER.info("end in addInsStaff, result = " + sysInsStaff);
        return apiResponse;
    }

    /**
     * 修改机构人员状态
     *
     * @param id          id
     * @param sysInsStaff sysInsStaff
     * @return ApiResponse
     */
    @Log("修改机构人员状态")
    @PatchMapping("/staffs/{id}")
    ApiResponse modifyStaffStatus(@PathVariable("id") String id, @RequestBody SysInsStaff sysInsStaff) {
        LOGGER.info("come in modifyStaffStatus, id = " + id);
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (sysInsStaff == null || sysInsStaff.getStatus() == null) {
            return apiResponse.error("400").setReason("状态不能为空");
        }
        sysInsStaff.setId(id);
        StaffPageShowVo staffPageShowVo = insService.modifyStaffStatus(sysInsStaff);
        apiResponse.success().setResult(staffPageShowVo);
        LOGGER.info("end in modifyStaffStatus, result = " + staffPageShowVo);
        return apiResponse;
    }

    /**
     * 查看单个机构人员
     *
     * @param id id
     * @return ApiResponse
     */
    @GetMapping("/staffs/{id}")
    ApiResponse findOneStaff(@PathVariable("id") String id) {
        LOGGER.info("come in findOneStaff, id = " + id);
        ApiResponse apiResponse = ApiResponse.getInstances();
        StaffPageShowVo staffPageShowVo = insService.findOneStaff(id);
        apiResponse.success().setResult(staffPageShowVo);
        LOGGER.info("end in findOneStaff, result = " + staffPageShowVo);
        return apiResponse;
    }

    /**
     * 通过手机号查询机构人员
     * @return
     */
    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping("/staff")
    ApiResponse findOneStaffByMobile(HttpServletRequest request) {
        String mobile = request.getHeader(HeaderUtil.AUTH_USER);
        LOGGER.info("come in findOneStaff, mobile = " + mobile);
        ApiResponse apiResponse = ApiResponse.getInstances();
        StaffPageShowVo staffPageShowVo = insService.findOneSraffByMobile(mobile);
        if(staffPageShowVo != null){
            apiResponse.success().setResult(staffPageShowVo);
        }else{
            apiResponse.error(ERROR_404.getCode()).setReason("不存在此用户");
        }

        LOGGER.info("end in findOneStaff, result = " + staffPageShowVo);
        return apiResponse;
    }


    /**
     * 修改机构人员
     *
     * @param id            id
     * @param sysInsStaff   sysInsStaff
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("修改机构人员")
    @PutMapping("/staffs/{id}")
    ApiResponse modifyStaff(@PathVariable("id") String id, @Valid @RequestBody SysInsStaff sysInsStaff, BindingResult
            bindingResult) {
        LOGGER.info("come in modifyStaff, request params , id = " + id + ", sysInsStaff = " + sysInsStaff);
        ApiResponse apiResponse = ApiResponse.getInstances();
        sysInsStaff.setId(id);
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        if (!StringUtils.isEmpty(sysInsStaff.getInstitutionId()) && !insService.checkInsStatus(sysInsStaff)) {
            return apiResponse.error("401").setReason("机构已被禁用，请重新选择");
        }
        StaffPageShowVo staffPageShowVo = insService.modifyStaff(sysInsStaff);
        apiResponse.success().setResult(staffPageShowVo);
        LOGGER.info("end in modifyStaff, result = " + staffPageShowVo);
        return apiResponse;
    }

    /**
     * @param list
     * @return ApiResponse
     * @throws Exception Exception
     */
    @PostMapping("/staffs/download")
    public ApiResponse downLoadZip(@RequestBody List<String> list) throws Exception {
        File fileDir = new File(systemConfig.getFileDir());
        if (!fileDir.exists()) {
            fileDir.mkdir();
        } else {
            FileUtils.deleteDirectory(fileDir);
            fileDir.mkdir();
        }

        File zipDir = new File(systemConfig.getZipDir());
        if (!zipDir.exists()) {
            zipDir.mkdir();
        } else {
            FileUtils.deleteDirectory(zipDir);
            zipDir.mkdir();
        }

        List<SysInsStaff> sysInsStaffs = insService.inIdS(list);
        RestTemplate restTemplate = new RestTemplate();
        for (SysInsStaff sysInsStaff : sysInsStaffs) {
            File file = new File(systemConfig.getFileDir() + sysInsStaff.getName() + sysInsStaff.getNumber() + ".png");
            ResponseEntity<byte[]> response = restTemplate.getForEntity(sysInsStaff.getDownloadUrl(), byte[].class);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(response.getBody());
            fos.flush();
            fos.close();
        }
        ZipUtils.doCompress(systemConfig.getFileDir(), systemConfig.getZipDir() + "staff.zip");

        File zipFile = new File(systemConfig.getZipDir() + "staff.zip");
        InputStream inputStream = new FileInputStream(zipFile);
        return null;
    }



}
