package com.masspick.peak.service.ext;

import com.google.common.collect.Lists;
import com.masspick.peak.service.RoleFeignApi;
import com.masspick.peak.service.dto.SysRoleDTO;
import com.masspick.peak.utils.ActUtils;
import org.flowable.engine.common.impl.interceptor.Session;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.GroupQuery;
import org.flowable.idm.engine.impl.GroupQueryImpl;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntity;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityImpl;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityManager;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * ActGroupEntityService
 */
@Service
public class ActGroupEntityService implements GroupEntityManager, Session {

    /**
     * roleFeignApi
     */
    @Resource
    private RoleFeignApi roleFeignApi;

    /**
     * @param s
     * @return Group
     */
    public Group createNewGroup(String s) {
        GroupEntityImpl groupEntity = new GroupEntityImpl();
        groupEntity.setId(s);
        return groupEntity;
    }

    /**
     * @return GroupQuery
     */
    public GroupQuery createNewGroupQuery() {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param groupQuery
     * @return List<Group>
     */
    public List<Group> findGroupByQueryCriteria(GroupQueryImpl groupQuery) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param groupQuery
     * @return long
     */
    public long findGroupCountByQueryCriteria(GroupQueryImpl groupQuery) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param userName
     * @return List<Group>
     */
    public List<Group> findGroupsByUser(String userName) {
        List<Group> list = Lists.newArrayList();
        List<SysRoleDTO> roles = null;
        try {
            roles = roleFeignApi.findRoleListByAccount(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!CollectionUtils.isEmpty(roles)) {
            for (SysRoleDTO role : roles) {
                list.add(ActUtils.toActivitiGroup(role));
            }
        }
        return list;
    }


    /**
     * @param userName
     * @return List<String>
     * @throws Exception 异常
     */
    public List<String> findGroupStringByUser(String userName) throws Exception {
        List<String> list = Lists.newArrayList();
        List<SysRoleDTO> roles = roleFeignApi.findRoleListByAccount(userName);
        if (!CollectionUtils.isEmpty(roles)) {
            for (SysRoleDTO role : roles) {
                list.add(role.getName());
            }
        }
        return list;
    }


    /**
     * @param map
     * @return List<Group>
     */
    public List<Group> findGroupsByNativeQuery(Map<String, Object> map) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param map
     * @return long
     */
    public long findGroupCountByNativeQuery(Map<String, Object> map) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param group
     * @return boolean
     */
    public boolean isNewGroup(Group group) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param s
     * @return List<Group>
     */
    public List<Group> findGroupsByPrivilegeId(String s) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @return GroupEntity
     */
    public GroupEntity create() {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param s
     * @return GroupEntity
     */
    public GroupEntity findById(String s) {
        throw new RuntimeException("not implement method.");
    }


    /**
     * @param entity
     */
    public void insert(GroupEntity entity) {

    }

    /**
     * @param entity
     * @param b
     */
    public void insert(GroupEntity entity, boolean b) {

    }

    /**
     * @param entity
     * @return GroupEntity
     */
    public GroupEntity update(GroupEntity entity) {
        return null;
    }

    /**
     * @param entity
     * @param b
     * @return GroupEntity
     */
    public GroupEntity update(GroupEntity entity, boolean b) {
        return null;
    }

    /**
     * @param s
     */
    public void delete(String s) {

    }

    /**
     * @param entity
     */
    public void delete(GroupEntity entity) {

    }

    /**
     * @param entity
     * @param b
     */
    public void delete(GroupEntity entity, boolean b) {

    }


    /**
     *
     */
    public void flush() {
    }

    /**
     *
     */
    public void close() {
    }
}
