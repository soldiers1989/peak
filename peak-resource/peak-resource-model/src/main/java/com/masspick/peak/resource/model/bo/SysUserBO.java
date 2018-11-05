package com.masspick.peak.resource.model.bo;


import com.masspick.peak.resource.model.SysDepartment;
import com.masspick.peak.resource.model.SysUser;

/**
 * SysUserBO
 */
public class SysUserBO extends SysUser {

    /**
     * sysDepartment
     */
    private SysDepartment sysDepartment;

    /**
     * Gets sysDepartment
     * @return value of sysDepartment
     */
    public SysDepartment getSysDepartment() {
        return sysDepartment;
    }

    /**
     * @param sysDepartment sysDepartment
     */
    public void setSysDepartment(SysDepartment sysDepartment) {
        this.sysDepartment = sysDepartment;
    }
}
