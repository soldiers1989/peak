package com.masspick.peak.resource.controller.vo;

import com.masspick.peak.resource.entity.bo.PermissionNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/8/9 0009.
 */
public class PermissionNodeTreeVO {

    /**
     * permissionNodeList
     */
    private List<PermissionNode> permissionNodeList;

    /**
     * 转换
     *
     * @param id id
     * @return List<PermissionNode>
     */
    public List<PermissionNode> permissionNodes(String id) {
        List<PermissionNode> permissionNodes = new ArrayList<>();
        for (PermissionNode permissionNode : permissionNodeList) {
            if (permissionNode.getParentId().equals(id) && permissionNode.getStatus() == 1) {
                permissionNode.setChildren(CollectionUtils.isEmpty(permissionNodes(permissionNode.getId())) ? null
                        : permissionNodes(permissionNode.getId()));
                permissionNodes.add(permissionNode);
            }
        }
        return permissionNodes;
    }

    /**
     * Gets permissionNodeList
     *
     * @return value of permissionNodeList
     */
    public List<PermissionNode> getPermissionNodeList() {
        return permissionNodeList;
    }

    /**
     * @param permissionNodeList permissionNodeList
     */
    public void setPermissionNodeList(List<PermissionNode> permissionNodeList) {
        this.permissionNodeList = permissionNodeList;
    }
}
