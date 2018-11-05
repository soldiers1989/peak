package com.masspick.peak;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * PeakDataCreditApplication
 */
@SpringBootApplication
@EnableEurekaClient
public class PeakDataCreditApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PeakDataCreditApplication.class, args);
    }
}
