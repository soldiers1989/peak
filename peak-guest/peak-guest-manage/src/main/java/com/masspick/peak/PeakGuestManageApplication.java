package com.masspick.peak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * PeakGuestManageApplication
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.masspick.peak")
@MapperScan(basePackages = "com.masspick.peak.guest.mapper")
@EnableFeignClients(basePackages = "com.masspick.peak")
@EnableEurekaClient
@EnableTransactionManagement
public class PeakGuestManageApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PeakGuestManageApplication.class, args);
    }
}