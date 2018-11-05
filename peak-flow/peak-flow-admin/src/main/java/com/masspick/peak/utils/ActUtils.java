package com.masspick.peak.utils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.masspick.peak.common.FieldName;
import com.masspick.peak.service.dto.SysRoleDTO;
import com.masspick.peak.service.dto.SysUserDTO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * ActUtils
 */
public class ActUtils {
    /**
     * 定义流程定义KEY，必须以“PD_”开头
     */
    public static final String[] PD_LEAVE = new String[]{"leave", "oa_leave"};

    /**
     * 组成结构：string[]{"流程标识","业务主表表名"}
     */
    public static final String[] PD_TEST_AUDIT = new String[]{"test_audit", "oa_test_audit"};


    /**
     * @param entity
     * @param spiltType
     * @return Map
     */
    @SuppressWarnings({"unused"})
    public static Map<String, Object> getMobileEntity(Object entity, String spiltType) {
        if (spiltType == null) {
            spiltType = "@";
        }
        Map<String, Object> map = Maps.newHashMap();

        List<String> field = Lists.newArrayList();
        List<String> value = Lists.newArrayList();
        List<String> chinesName = Lists.newArrayList();

        try {
            for (Method m : entity.getClass().getMethods()) {
                if (m.getAnnotation(JsonIgnore.class) == null && m.getAnnotation(JsonBackReference.class) == null && m.getName().startsWith("get")) {
                    if (m.isAnnotationPresent(FieldName.class)) {
                        Annotation p = m.getAnnotation(FieldName.class);
                        FieldName fieldName = (FieldName) p;
                        chinesName.add(fieldName.value());
                    } else {
                        chinesName.add("");
                    }
                    if (m.getName().equals("getAct")) {
                        Object act = m.invoke(entity, new Object[]{});
                        Method actMet = act.getClass().getMethod("getTaskId");
                        map.put("taskId", ObjectUtils.identityToString(m.invoke(act, new Object[]{})));
                    } else {
                        field.add(StringUtils.uncapitalize(m.getName().substring(3)));
                        value.add(ObjectUtils.identityToString(m.invoke(entity, new Object[]{})));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("beanTitles", StringUtils.join(field, spiltType));
        map.put("beanInfos", StringUtils.join(value, spiltType));
        map.put("chineseNames", StringUtils.join(chinesName, spiltType));

        return map;
    }


    /**
     * @param user
     * @return UserEntityImpl
     */
    public static UserEntityImpl toActivitiUser(SysUserDTO user) {
        if (user == null) {
            return null;
        }
        UserEntityImpl userEntity = new UserEntityImpl();
        userEntity.setId(user.getAccount());
        userEntity.setFirstName(user.getName());
        userEntity.setLastName(StringUtils.EMPTY);
        //userEntity.setPassword(user.get);
        // userEntity.setEmail(user.get);
        userEntity.setRevision(1);
        return userEntity;
    }

    /**
     * @param role
     * @return GroupEntityImpl
     */
    public static GroupEntityImpl toActivitiGroup(SysRoleDTO role) {
        if (role == null) {
            return null;
        }
        GroupEntityImpl groupEntity = new GroupEntityImpl();
        groupEntity.setId(role.getName());
        groupEntity.setName(role.getName());
        groupEntity.setType(role.getRemark());
        groupEntity.setRevision(1);
        return groupEntity;
    }
}
