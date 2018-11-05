package com.masspick.peak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/7/4 0004.
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.allpick.peak.resource.model")
@EnableFeignClients
@ComponentScan
@RestController
public class PeakResourceProviderApplication {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PeakResourceProviderApplication.class, args);
    }

    /**
     * @return String
     */
    @GetMapping("/test")
    public String test() {
        return "success";
    }
}
