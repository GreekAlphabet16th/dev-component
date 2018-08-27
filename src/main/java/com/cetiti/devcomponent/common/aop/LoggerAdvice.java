package com.cetiti.devcomponent.common.aop;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 日志管理切面
 * @author zhouliyu
 * @version 1.0
 * */
@Component
@Aspect
@Order(3)
public class LoggerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);

    @Pointcut("within(com.cetiti.owls..*)")
    public void logPointCut() {

    }

    /**
     * 前置通知
     *
     * @param joinPoint    目标类连接点对象
     * @param loggerManage 注解
     */
    @Before(value = "logPointCut()&& @annotation(loggerManage)")
    public void addBeforeLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
        String description = loggerManage.description();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String parameters = parseParames(joinPoint.getArgs());
        logger.info("[" + description + "] 执行方法 : " + className + "." + methodName + "(" + parameters + ")");
    }

    /**
     * 后置通知
     *
     * @param joinPoint    目标类连接点对象
     * @param loggerManage 注解
     */
    @AfterReturning(value = "logPointCut()&& @annotation(loggerManage)")
    public void addAfterReturningLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
        String description = loggerManage.description();
        logger.info("[" + description + "] 执行结束");
    }


    /**
     * 异常通知
     *
     * @param joinPoint 目标类连接点对象
     * @param exception 异常类
     */
    @AfterThrowing(value = "logPointCut()&& @annotation(loggerManage)", throwing = "exception")
    public void addAfterThrowingLogger(JoinPoint joinPoint, LoggerManage loggerManage, Exception exception) {
        String description = loggerManage.description();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String parameters = parseParames(joinPoint.getArgs());
        logger.warn("[" + description + "] 执行方法 : " + className + "." + methodName + "(" + parameters + "), 异常 : " + exception.getMessage());

    }

    private String parseParames(Object[] parameters) {
        if (null == parameters || parameters.length <= 0 || parameters.length > 1024) {
            return "";
        }
        StringBuffer param = new StringBuffer();
        for (Object obj : parameters) {
            param.append(ToStringBuilder.reflectionToString(obj)).append(" ");
        }
        return param.toString();
    }
}

