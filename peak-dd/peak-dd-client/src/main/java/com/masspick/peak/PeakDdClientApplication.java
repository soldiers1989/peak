package com.masspick.peak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

/**
 * PeakDdClientApplication
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.masspick.peak")
@MapperScan(basePackages = "com.masspick.peak.dd.mapper")
@ComponentScan(basePackages = "com.masspick.peak")
@RestController
public class PeakDdClientApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PeakDdClientApplication.class, args);
    }
}
