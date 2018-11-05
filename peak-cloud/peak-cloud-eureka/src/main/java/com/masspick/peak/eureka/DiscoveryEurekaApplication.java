package com.masspick.peak.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * DiscoveryEurekaApplication
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryEurekaApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryEurekaApplication.class, args);
    }
}
