package com.Aakash.jobAppRestController.spring.api.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@Aspect
public class ValidationAspect {

    private  static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.Aakash.jobAppRestController.spring.api.service.JobService.getJob(..)) && args(postId)")
    public Object ValidationAndUpdate(ProceedingJoinPoint jp,int postId) throws Throwable {
        if(postId<0){
            LOGGER.info("postid is negative updating it");
            postId = -postId;
            LOGGER.info("new value"+ postId);
        }
        Object obj = jp.proceed(new Object[]{postId});
        return obj;
    }

}
