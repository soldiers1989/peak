package com.masspick.peak;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * PeakInterfaceApplication
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = "com.masspick.peak")
@RestController
public class PeakInterfaceApplication {

    /**
     * @return RestTemplate
     */
    @Bean
    public RestTemplate getRestTempLate() {
        return new RestTemplate();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PeakInterfaceApplication.class, args);
    }
}
