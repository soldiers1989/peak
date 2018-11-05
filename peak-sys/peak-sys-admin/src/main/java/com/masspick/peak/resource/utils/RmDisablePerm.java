package com.masspick.peak.resource.utils;


import com.masspick.peak.resource.entity.SysPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * RmDisablePerm
 */
public class RmDisablePerm {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RmDisablePerm.class);

    /**
     *  移除禁用的权限
     * @param departmentShowVos departmentShowVos
     * @param status status
     * @return  List<SysPermission>
     */
    public List<SysPermission> handPermissionList(List<SysPermission> departmentShowVos, Integer status) {

        for (SysPermission departmentShowVo : departmentShowVos) {
            LOGGER.info("数据库中的数据: " + departmentShowVo.toString());
        }
        Map<String, String> idMap = getIdPidMap(departmentShowVos);
        List<String> rmList = getRmList(departmentShowVos, status);
        Map<String, String> handleMap = removeTreeNodes(idMap, rmList);
        List<SysPermission> handList = getListFromMap(handleMap, getIdPermissionMap(departmentShowVos));
        return handList;
    }

    /**
     * 将部门list转为Map<id,pid>
     *
     * @param departmentShowVos departmentShowVos
     * @return Map
     */
    public Map<String, String> getIdPidMap(List<SysPermission> departmentShowVos) {
        Map<String, String> partmentMap = new LinkedHashMap<>();

        for (SysPermission departmentShowVo : departmentShowVos) {
            partmentMap.put(departmentShowVo.getId(), departmentShowVo.getParentId());
        }
        return partmentMap;
    }


    /**
     * 将部门list转为Map<id, SysPermission>
     *
     * @param departmentShowVos departmentShowVos
     * @return Map
     */
    public Map<String, SysPermission> getIdPermissionMap(List<SysPermission> departmentShowVos) {
        Map<String, SysPermission> partmentMap = new LinkedHashMap<>();

        for (SysPermission departmentShowVo : departmentShowVos) {
            partmentMap.put(departmentShowVo.getId(), departmentShowVo);
        }
        return partmentMap;
    }

    /**
     *  获取需要移除的list
     * @param sysPermissions sysPermissions
     * @param status status
     * @return  List<String>
     */
    public List<String> getRmList(List<SysPermission> sysPermissions, Integer status) {
        List<String> rmList = new ArrayList<>();
        for (SysPermission departmentShowVo : sysPermissions) {
            if (departmentShowVo.getStatus() != status) {
                rmList.add(departmentShowVo.getId());
            }
        }
        return rmList;
    }

    /**
     * 递归删除所有禁用的节点和子节点
     *
     * @param permissionMap permissionMap
     * @param rmList        rmList
     * @return Map
     */
    public Map<String, String> removeTreeNodes(Map<String, String> permissionMap, List<String> rmList) {
        //所有需要删除的子节点
        List<String> temp = new ArrayList();
        //循环递归删除，所有以k为父节点的节点
        while (true) {
            for (String rmId : rmList) {
                Set<String> keys = permissionMap.keySet();
                Iterator<String> it = keys.iterator();
                while (it.hasNext()) {
                    String id = it.next();
                    //如果父节点（即Map的value）为需要删除的节点，则记录此节点，并在Map中删除
                    if (rmId.equals(permissionMap.get(id))) {
                        temp.add(id);
                        it.remove();
                        LOGGER.info("已经删除了ID=[" + id + "]的节点,其父节点为[" + rmId + "]");
                    }
                }
                //移除节点本身
                permissionMap.remove(rmId);
            }

            //如果此节点包含子节点，则将子节点赋值给sons;否则表示所有子节点已经删除，结束循环
            if (temp.size() > 0) {
                rmList = temp;
                temp = new CopyOnWriteArrayList();
            } else {
                break;
            }
        }
        return permissionMap;
    }

    /**
     * 通过map中的id获取排序的list
     *
     * @param handleMap   handleMap
     * @param idDepartMap idDepartMap
     * @return List
     */
    public List<SysPermission> getListFromMap(Map<String, String> handleMap, Map<String, SysPermission> idDepartMap) {
        List<SysPermission> handleList = new ArrayList<>();
        Set<String> keys = handleMap.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            handleList.add(idDepartMap.get(it.next()));
        }
        return handleList;
    }
}
