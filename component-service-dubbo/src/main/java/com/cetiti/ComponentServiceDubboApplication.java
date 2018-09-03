package com.cetiti;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.cetiti.service.impl")
public class ComponentServiceDubboApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComponentServiceDubboApplication.class, args);
    }
}
