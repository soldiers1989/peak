package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysDepartment;
import com.masspick.peak.resource.vo.DepartmentShowVo;
import com.masspick.peak.resource.vo.ModifyChildVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysDepartmentMapper
 */
@Mapper
public interface SysDepartmentMapper {

    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysDepartment pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysDepartment pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysDepartment> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysDepartment pojo);

    /**
     * @param parentId parentId
     * @param id       id
     * @return int
     */
    int updateParentId(@Param("parentId") String parentId, @Param("id") String id);

    /**
     * @return List
     */
    List<SysDepartment> findList();

    /**
     * @return List
     */
    List<DepartmentShowVo> findShowList();

    /**
     * 编辑部门移除自己以及自己的子集
     *
     * @param id id
     * @return List
     */
    List<DepartmentShowVo> editDep(@Param("id") String id);

    /**
     * @param id id
     * @return List
     */
    List<DepartmentShowVo> findChildrenById(String id);

    /**
     * @param id id
     * @return SysDepartment
     */
    SysDepartment findOne(@Param("id") String id);

    /**
     * @param code code
     * @return SysDepartment
     */
    SysDepartment findByCode(@Param("code") String code);

    /**
     * @param id   id
     * @param code code
     * @return int
     */
    int modifyDepartStatus(@Param("id") String id, @Param("code") String code);

    /**
     * @param pojo pojo
     * @return int
     */
    int updateChildrenCode(@Param("pojo") ModifyChildVo pojo);


    /**
     * @return int
     */
    int updateChildrenLevel();

    /**
     * @param parentCode  parentCode
     * @param formerLevel formerLevel
     * @param id          id
     * @return int
     */
    int updateChildren(@Param("parentCode") String parentCode, @Param("formerLevel") Integer formerLevel, @Param
            ("id") String id);

    /**
     * @param id id
     * @return int
     */
    int findUnableParentCount(@Param("id") String id);
}
