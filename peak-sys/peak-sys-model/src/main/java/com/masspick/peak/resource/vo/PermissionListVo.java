package com.masspick.peak.resource.vo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *  角色授权权限对象
 */
public class PermissionListVo {

    /**
     *  权限id
     */
    @NotNull
    private List<String> permissionId;


    /**
     * Gets permissionId
     *
     * @return value of permissionId
     */
    public List<String> getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId permissionId
     */
    public void setPermissionId(List<String> permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "PermissionListVo{"
                + "permissionId=" + permissionId
                + '}';
    }
}
