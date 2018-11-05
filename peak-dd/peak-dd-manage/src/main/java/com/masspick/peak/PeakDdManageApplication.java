package com.masspick.peak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * PeakDdManageApplication
 */
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = "com.masspick.peak.dd.mapper")
@ComponentScan("com.masspick.peak")
public class PeakDdManageApplication {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PeakDdManageApplication.class, args);
    }
}
