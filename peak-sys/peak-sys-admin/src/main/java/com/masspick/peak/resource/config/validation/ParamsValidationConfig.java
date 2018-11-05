package com.masspick.peak.resource.config.validation;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * ParamsValidationConfig
 */
@Configuration
@EnableAutoConfiguration
public class ParamsValidationConfig {

    /**
     *MethodValidationPostProcessor
     * @return MethodValidationPostProcessor
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
