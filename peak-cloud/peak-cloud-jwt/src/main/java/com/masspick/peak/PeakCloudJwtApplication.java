package com.masspick.peak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * PeakCloudJwtApplication
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.masspick.peak.resource")
@RestController
public class PeakCloudJwtApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PeakCloudJwtApplication.class, args);
    }
}
