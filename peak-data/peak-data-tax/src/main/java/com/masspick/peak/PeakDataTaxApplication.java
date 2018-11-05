package com.masspick.peak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * PeakDataTaxApplication
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class PeakDataTaxApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PeakDataTaxApplication.class, args);
    }
}
