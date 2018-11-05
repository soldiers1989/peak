package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.vo.StaffDataGridFindVo;
import com.masspick.peak.resource.vo.StaffPageShowVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.resource.entity.SysInsStaff;

/**
 * SysInsStaffMapper
 */
@Mapper
public interface SysInsStaffMapper {
    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysInsStaff pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysInsStaff pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysInsStaff> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysInsStaff pojo);

    /**
     * @param pojo pojo
     * @return List<StaffPageShowVo>
     */
    List<StaffPageShowVo>  findByPage(@Param("pojo") StaffDataGridFindVo pojo);

    /**
     * @param id id
     * @return StaffPageShowVo
     */
    StaffPageShowVo findById(@Param("id") String id);

    /**
     *
     * @param mobile mobile
     * @return StaffPageShowVo
     */
    StaffPageShowVo findByMobile(@Param("mobile") String mobile);

    /**
     *
     * @param ids ids
     * @return List
     */
    List<SysInsStaff> findByIds(@Param("ids")List<String> ids);

    /**
     *
     * @param number number
     * @return List
     */
    SysInsStaff findByNumber(@Param("number")String number);

    /**
     *
     * @param mobile 手机号
     * @return SysInsStaff
     */
    SysInsStaff findByInsMobile(@Param("mobile")String mobile);
}
