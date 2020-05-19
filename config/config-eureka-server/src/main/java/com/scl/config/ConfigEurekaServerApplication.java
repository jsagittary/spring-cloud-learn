package com.scl.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: spring-cloud-learn
 * @description:
 * @author: zhou jie
 * @create: 2020-05-19 15:03
 */
@SpringBootApplication
@EnableEurekaServer
public class ConfigEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaServerApplication.class, args);
    }
}