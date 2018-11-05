package com.masspick.peak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FlowAdminApplication
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.masspick.peak.*"})
@MapperScan(basePackages = "com.masspick.peak.mapper.*")
@RestController
public class FlowAdminApplication {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(FlowAdminApplication.class, args);
    }


    /**
     * @return String
     */
    @RequestMapping("/hello")
    public String test() {
        return "hello world!";
    }
}
