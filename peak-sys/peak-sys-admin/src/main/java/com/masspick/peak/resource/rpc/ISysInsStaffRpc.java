package com.masspick.peak.resource.rpc;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.resource.entity.SysIns;
import com.masspick.peak.resource.entity.SysInsStaff;
import com.masspick.peak.resource.mapper.SysInsMapper;
import com.masspick.peak.resource.mapper.SysInsStaffMapper;
import com.masspick.peak.service.ISysInsStaffFeignApi;
import com.masspick.peak.service.dto.SysInsStaffDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/9/20 0020.
 */
@RestController
public class ISysInsStaffRpc implements ISysInsStaffFeignApi {

    /**
     * sysInsStaffMapper
     */
    @Autowired
    private SysInsStaffMapper sysInsStaffMapper;

    /**
     *  sysInsMapper
     */
    @Autowired
    private SysInsMapper sysInsMapper;

    @Override
    public SysInsStaffDTO finByNumber(@PathVariable("number") String number) throws Exception {
        SysInsStaff sysInsStaff = sysInsStaffMapper.findByNumber(number);
        SysIns sysIns = sysInsMapper.findById(sysInsStaff.getInstitutionId());
        SysInsStaffDTO sysInsStaffDTO = JacksonUtils.copyProperties(sysInsStaffMapper.findByNumber(number),
                SysInsStaffDTO.class);
        sysInsStaffDTO.setInstitutionName(sysIns.getName());
        return sysInsStaffDTO;
    }
}
