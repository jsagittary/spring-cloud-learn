package com.scl.feign.config;

import com.netflix.hystrix.HystrixCommand;
import feign.Feign;
import feign.hystrix.HystrixFeign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @program: spring-cloud-learn
 * @description:
 * @author: zhou jie
 * @create: 2020-05-18 15:10
 */
@Configuration
@ConditionalOnClass({ HystrixCommand.class, HystrixFeign.class})
public class HystrixFeignConfiguration {

    @Bean
    @Scope
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "feign.hystrix.enable", matchIfMissing = true)
    public Feign.Builder feignHystrixBuilder() {
        return HystrixFeign.builder();
    }
}