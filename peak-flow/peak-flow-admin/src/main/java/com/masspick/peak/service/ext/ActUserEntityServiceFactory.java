package com.masspick.peak.service.ext;

import org.flowable.engine.common.impl.interceptor.CommandContext;
import org.flowable.engine.common.impl.interceptor.Session;
import org.flowable.engine.common.impl.interceptor.SessionFactory;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


/**
 * ActUserEntityServiceFactory
 */
@Configuration
public class ActUserEntityServiceFactory implements SessionFactory {

    /**
     * ActUserEntityService
     */
    @Autowired
    private ActUserEntityService actUserEntityService;


    /**
     * @return Class
     */
     public Class<?> getSessionType() {
        // 返回原始的UserIdentityManager类型
         return UserEntityManager.class;
     }

    /**
     * @param commandContext
     * @return Session
     */
     public Session openSession(CommandContext commandContext)  {
         return actUserEntityService;
     }
}
