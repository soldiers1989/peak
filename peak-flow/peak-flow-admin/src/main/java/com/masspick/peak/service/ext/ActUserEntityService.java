package com.masspick.peak.service.ext;

import com.masspick.peak.service.IDictionaryFeignApi;
import com.masspick.peak.service.IUserFeignApi;
import com.masspick.peak.service.dto.SysDictionaryDTO;
import com.masspick.peak.utils.ActUtils;
import org.flowable.engine.common.impl.interceptor.Session;
import org.flowable.idm.api.PasswordEncoder;
import org.flowable.idm.api.PasswordSalt;
import org.flowable.idm.api.Picture;
import org.flowable.idm.api.User;
import org.flowable.idm.api.UserQuery;
import org.flowable.idm.engine.impl.UserQueryImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntity;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * ActUserEntityService
 */
@Service
public class ActUserEntityService implements UserEntityManager, Session {


    /**
     * userFeignApi
     */
    @Resource
    private IUserFeignApi userFeignApi;

    /**
     * dictionaryFeignApi
     */
    @Resource
    private IDictionaryFeignApi dictionaryFeignApi;

    /**
     * @return UserEntity
     */
    public UserEntity create() {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param id
     * @return UserEntity
     */
    public UserEntity findById(String id) {
        //id即为用户名
        try {
            return ActUtils.toActivitiUser(userFeignApi.findByName(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param type
     * @return List
     * @throws Exception 异常
     */
    public List<SysDictionaryDTO> findDictByType(String type) throws Exception {
        return dictionaryFeignApi.getDictionaryItem(type);
    }

    /**
     * @param type
     * @param key
     * @return String
     * @throws Exception 异常
     */
    public String findDictNameByTypeAndKey(String type, String key) throws Exception {
        return dictionaryFeignApi.findDictNameByTypeAndKey(type, key);
    }

    /**
     * @param entity
     */
    public void insert(UserEntity entity) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param entity
     * @param b
     */
    public void insert(UserEntity entity, boolean b) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param entity
     * @return UserEntity
     */
    public UserEntity update(UserEntity entity) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param entity
     * @param b
     * @return UserEntity
     */
    public UserEntity update(UserEntity entity, boolean b) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param s
     */
    public void delete(String s) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param entity
     */
    public void delete(UserEntity entity) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param entity
     * @param b
     */
    public void delete(UserEntity entity, boolean b) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param id
     * @return User
     */
    public User createNewUser(String id) {
        UserEntityImpl userEntity = new UserEntityImpl();
        userEntity.setId(id);
        return userEntity;
    }

    /**
     * @param user
     */
    public void updateUser(User user) {
        throw new RuntimeException("not implement method.");
    }

    /**
     * @param userQuery
     * @return List
     */
    public List<User> findUserByQueryCriteria(UserQueryImpl userQuery) {
        return null;
    }

    /**
     * @param userQuery
     * @return long
     */
    public long findUserCountByQueryCriteria(UserQueryImpl userQuery) {
        return 0;
    }

    /**
     * @return UserQuery
     */
    public UserQuery createNewUserQuery() {
        return null;
    }

    /**
     * @param s
     * @param s1
     * @param passwordEncoder
     * @param passwordSalt
     * @return Boolean
     */
    public Boolean checkPassword(String s, String s1, PasswordEncoder passwordEncoder, PasswordSalt passwordSalt) {
        return null;
    }

    /**
     * @param map
     * @return List
     */
    public List<User> findUsersByNativeQuery(Map<String, Object> map) {
        return null;
    }

    /**
     * @param map
     * @return long
     */
    public long findUserCountByNativeQuery(Map<String, Object> map) {
        return 0;
    }

    /**
     * @param user
     * @return boolean
     */
    public boolean isNewUser(User user) {
        return false;
    }

    /**
     * @param user
     * @return Picture
     */
    public Picture getUserPicture(User user) {
        return null;
    }

    /**
     * @param user
     * @param picture
     */
    public void setUserPicture(User user, Picture picture) {

    }

    /**
     * @param user
     */
    public void deletePicture(User user) {

    }

    /**
     * @param s
     * @return List
     */
    public List<User> findUsersByPrivilegeId(String s) {
        return null;
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
