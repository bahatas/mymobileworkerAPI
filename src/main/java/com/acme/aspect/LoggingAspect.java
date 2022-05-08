package com.acme.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Slf4j
@Configuration
public class LoggingAspect {

    @Pointcut("execution(* com.acme.controller.JobController.*(..)) || execution(* com.acme.controller.ClientController.*(..))")
    private void anyControllerOperation(){}

    @Before("anyControllerOperation()")
    public void anyBeforeController(JoinPoint joinPoint){
        log.info("Before(Method: {} - Parameter : {}",joinPoint.getSignature().toLongString(),joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "anyControllerOperation()",returning = "results")
    public void anyAfterReturningControllerOperationAdvice(JoinPoint joinPoint, Object results){
        log.info("AfterReturning( Method : {} - Results : {})",joinPoint.getSignature().toLongString(),results.toString());
    }

    @AfterThrowing(pointcut = "anyControllerOperation()",throwing = "runtimeException")
    public void anyAfterThrowingControllerOperationAdvice(JoinPoint joinPoint, RuntimeException runtimeException){

        log.info("After throwing (Method : {} - Exception : {})",joinPoint.getSignature().toLongString(),runtimeException.getLocalizedMessage());
    }
}
