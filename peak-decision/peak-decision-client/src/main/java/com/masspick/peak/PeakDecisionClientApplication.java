package com.masspick.peak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * PeakDecisionClientApplication
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.masspick.peak")
@MapperScan(basePackages = "com.masspick.peak.decision.mapper")
@EnableFeignClients(basePackages = "com.masspick.peak")
@EnableEurekaClient
public class PeakDecisionClientApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PeakDecisionClientApplication.class, args);
    }
}
