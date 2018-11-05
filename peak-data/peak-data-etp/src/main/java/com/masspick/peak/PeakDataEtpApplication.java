package com.masspick.peak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * PeakDataEtpApplication
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.masspick.peak.etp.mapper")
@ComponentScan
@EnableFeignClients
public class PeakDataEtpApplication {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PeakDataEtpApplication.class, args);
    }
}
