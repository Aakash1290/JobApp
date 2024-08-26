package com.Aakash.jobAppRestController.spring.api.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    @Before("execution(* com.Aakash.jobAppRestController.spring.api.service.JobService.*(..))")
//    public void logMethodCall(JoinPoint jp){
//        LOGGER.info("Method Called "+ jp.getSignature().getName());
//    }

    @Before("execution(* com.Aakash.jobAppRestController.spring.api.service.JobService.getJob(..)) ||execution(* com.Aakash.jobAppRestController.spring.api.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called "+ jp.getSignature().getName());
    }
    @After("execution(* com.Aakash.jobAppRestController.spring.api.service.JobService.getJob(..)) ||execution(* com.Aakash.jobAppRestController.spring.api.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Called "+ jp.getSignature().getName());
    }
}
