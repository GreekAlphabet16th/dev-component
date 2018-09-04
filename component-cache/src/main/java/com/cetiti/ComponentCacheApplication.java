package com.cetiti;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.cetiti.cache.core.impl")
public class ComponentCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentCacheApplication.class, args);
	}
}
