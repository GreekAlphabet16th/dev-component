package com.cetiti;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.cetiti.service")
public class ComponentControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComponentControllerApplication.class, args);
    }
}
