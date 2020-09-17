package com.jasdhir.aop.springdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;


@Aspect
public class Logging {

    @AfterReturning(pointcut = "execution(* com.jasdhir.aop.springdemo.Student.*(..))",returning = "retVal")
    public void afterReturningAdvice( Object retVal){

        System.out.println("Returning:" + retVal.toString() );
    }
}