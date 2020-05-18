package com.scl.feign.schedual;

import org.springframework.stereotype.Component;

/**
 * @program: spring-cloud-learn
 * @description:
 * @author: zhou jie
 * @create: 2020-05-18 15:05
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}