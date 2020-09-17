package com.jasdhir.aop.springdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Logging {
    @AfterThrowing(pointcut = "execution(* com.jasdhir.aop.springdemo.Student.*(..))",
            throwing = "error")
    public void afterThrowingAdvice(JoinPoint jp, Throwable error){
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Exception: "+error);
    }
}