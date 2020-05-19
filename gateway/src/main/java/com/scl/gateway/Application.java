package com.scl.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @program: spring-cloud-learn
 * @description:
 * @author: zhou jie
 * @create: 2020-05-19 17:22
 */
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouteLocator myRoute(RouteLocatorBuilder builder) {
        String httpUrl = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                        // 判断请求路径
                        .path("/get")
                        // 添加请求头
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        // 请求转发
                        .uri(httpUrl))
                .route(p -> p
                        // 判断host
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        // 配置名称
                                        .setName("mycmd")
                                        // 指向性fallBack的逻辑地址
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUrl))
                .build();
    }


    /**
     * Mono是一个Reactive stream
     * @return Mono
     */
    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

}