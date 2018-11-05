package com.masspick.peak.service.ext;

import org.flowable.engine.common.impl.interceptor.CommandContext;
import org.flowable.engine.common.impl.interceptor.Session;
import org.flowable.engine.common.impl.interceptor.SessionFactory;
import org.flowable.idm.engine.impl.persistence.entity.GroupEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * ActGroupEntityServiceFactory
 */
@Configuration
public class ActGroupEntityServiceFactory implements SessionFactory {


    /**
     * ActGroupEntityService
     */
    @Autowired
    private ActGroupEntityService actGroupEntityService;


    /**
     * @return Class
     */
    public Class<?> getSessionType() {
        return GroupEntityManager.class;
    }

    /**
     * @param commandContext
     * @return Session
     */
    public Session openSession(CommandContext commandContext) {
        return actGroupEntityService;
    }
}
