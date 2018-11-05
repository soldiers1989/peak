package com.masspick.peak.resource.config.constant;

/**
 * PermissionConstant
 */
public class PermissionConstant {

    protected PermissionConstant() {
    }

    /**
     * DIRECTORY_TYPE
     */
    public static final  Integer DIRECTORY_TYPE = 1;

    /**
     * MENU_TYPE
     */
    public static final  Integer MENU_TYPE = 2;

    /**
     * FUNCTION_TYPE
     */
    public static final  Integer FUNCTION_TYPE = 3;

    /**
     * URL_EMPTY_ERROR
     */
    public static final String URL_EMPTY_ERROR = " 权限类型为菜单时，菜单url不能为空";

    /**
     * RESOURCE_NAME_EMPTY_ERROR
     */
    public static final String RESOURCE_NAME_EMPTY_ERROR = "权限类型为功能时，资源名称不能为空";

    /**
     * REPEAT_CODE
     */
    public static final String REPEAT_CODE = "排序已存在，请重新输入";

    /**
     * PARENT_DISABLE
     */
    public static final String PARENT_DISABLE = "所选权限已被禁用，请重新选择";

    /**
     * PARENT_DISABLE
     */
    public static final String SUPERIOR_DISABLE = "所选权限的上级权限已被禁用，请重新选择";

    /**
     * MODIFY_NOT_EXIST
     */
    public static final String MODIFY_NOT_EXIST = "id对应权限不存在，无法修改";
}
