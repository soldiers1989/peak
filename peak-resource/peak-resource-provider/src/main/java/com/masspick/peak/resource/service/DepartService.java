package com.masspick.peak.resource.service;


import com.masspick.peak.resource.model.SysDepartment;

/**
 * DepartService
 */
public interface DepartService {
    /**
     * @param userId
     * @return SysDepartment
     */
    SysDepartment findByUserId(String userId);

    /**
     * @param userName
     * @return SysDepartment
     */
    SysDepartment findByUserName(String userName);

}
