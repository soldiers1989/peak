package com.masspick.peak.service.impl;

import com.masspick.peak.mapper.ActPushMsgMapper;
import com.masspick.peak.model.ActPushMsg;
import com.masspick.peak.service.ActPushMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ActPushMsgServiceImpl
 */
@Service
public class ActPushMsgServiceImpl implements ActPushMsgService {

    /**
     * ActPushMsgMapper
     */
    @Autowired
    private ActPushMsgMapper actPushMsgMapper;

    /**
     * @param actPushMsg
     * @return int
     */
    @Override
    public int insert(ActPushMsg actPushMsg) {
        return actPushMsgMapper.insert(actPushMsg);
    }
}
