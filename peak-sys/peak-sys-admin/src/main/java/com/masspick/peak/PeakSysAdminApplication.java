package com.masspick.peak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * PeakSysAdminApplication
 */
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.masspick.peak.resource"})
@MapperScan(basePackages = "com.masspick.peak.resource.mapper")
@ComponentScan(basePackages = "com.masspick.peak")
@EnableEurekaClient
@EnableFeignClients
public class PeakSysAdminApplication {
    protected PeakSysAdminApplication() {
    }

    /**
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(PeakSysAdminApplication.class, args);
    }
}
