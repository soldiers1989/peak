package com.masspick.peak.resource.service;


import com.masspick.peak.resource.entity.SysIns;
import com.masspick.peak.resource.entity.SysInsStaff;
import com.masspick.peak.resource.vo.InsDataGridFindVo;
import com.masspick.peak.resource.vo.StaffDataGridFindVo;
import com.masspick.peak.resource.vo.StaffPageShowVo;

import java.util.List;

/**
 *  机构
 */
public interface IInsService {
    /**
     *
     * @param insDataGridFindVo insDataGridFindVo
     * @return List<SysIns>
     */
    List<SysIns> findInsByPage(InsDataGridFindVo insDataGridFindVo);

    /**
     *
     * @return List<SysIns>
     */
    List<SysIns> findAll();

    /**
     * @return List<SysIns>
     */
    List<SysIns> findAllAble();

    /**
     *
     * @param sysIns sysIns
     * @return SysIns
     */
    SysIns addSysIns(SysIns sysIns);

    /**
     *
     * @param sysIns sysIns
     * @return SysIns
     */
    SysIns modifyInsStatus(SysIns sysIns);

    /**
     *
     * @param id id
     * @return SysIns
     */
    SysIns findOneIns(String id);

    /**
     *
     * @param sysIns sysIns
     * @return Boolean
     */
    Boolean checkUniqueCode(SysIns sysIns);

    /**
     *
     * @param sysIns sysIns
     * @return SysIns
     */
    SysIns modifyIns(SysIns sysIns);

    /**
     *
     * @param sysInsStaff sysInsStaff
     * @return SysInsStaff
     */
    SysInsStaff addInsStaff(SysInsStaff sysInsStaff);

    /**
     *
     * @param sysInsStaff sysInsStaff
     * @return SysInsStaff
     */
    SysInsStaff findByMobile(SysInsStaff sysInsStaff);

    /**
     *
     * @param staffDataGridFindVo staffDataGridFindVo
     * @return List<StaffPageShowVo>
     */
    List<StaffPageShowVo> findByPage(StaffDataGridFindVo staffDataGridFindVo);

    /**
     *
     * @param sysInsStaff sysInsStaff
     * @return StaffPageShowVo
     */
    StaffPageShowVo modifyStaffStatus(SysInsStaff sysInsStaff);

    /**
     *
     * @param id id
     * @return StaffPageShowVo
     */
    StaffPageShowVo findOneStaff(String id);

    /**
     *
     * @param mobile
     * @return StaffPageShowVo
     */
    StaffPageShowVo findOneSraffByMobile(String mobile);

    /**
     *
     * @param sysInsStaff sysInsStaff
     * @return StaffPageShowVo
     */
    StaffPageShowVo modifyStaff(SysInsStaff sysInsStaff);

    /**
     * @param sysInsStaff 机构id
     * @return Boolean
     */
    Boolean checkInsStatus(SysInsStaff sysInsStaff);

    /**
     *
     * @param list list
     * @return List
     */
    List<SysInsStaff> inIdS(List<String> list);
}
