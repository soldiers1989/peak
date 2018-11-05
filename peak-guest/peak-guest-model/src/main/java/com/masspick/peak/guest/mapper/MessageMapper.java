package com.masspick.peak.guest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.guest.model.Message;

/**
 * MessageMapper
 */
@Mapper
public interface MessageMapper {
    /**
     * 单条插入
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") Message pojo);

    /**
     * 批量插入
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<Message> pojo);

    /**
     * 单条更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") Message pojo);

    /**
     * 根据用户id获取消息
     * @param userId 用户id
     * @return List<Message>
     */
    List<Message> findList(@Param("userId") String userId);

    /**
     * 标记信息已读
     * @param id id
     * @return int
     */
    int readMessage(@Param("id") String id);

    /**
     * 删除消息
     * @param id id
     * @return int
     */
    int deleteById(@Param("id") String id);
}
