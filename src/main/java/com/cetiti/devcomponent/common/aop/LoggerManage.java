package com.cetiti.devcomponent.common.aop;

import java.lang.annotation.*;

/**
 * 日志注解
 * @author zhouliyu
 * @version 1.0
 *
 * */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerManage {
    String description();
}
