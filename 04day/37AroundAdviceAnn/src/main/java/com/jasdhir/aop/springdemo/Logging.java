package com.jasdhir.aop.springdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Logging {
	
	@Around("execution(* com.jasdhir.aop.springdemo.Student.setAge(..))")
	public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("Inside aroundAdvice() method...." + " Inserted before= " 
        					+ pjp.getSignature().getName() + " method");
       
       Object [] args=pjp.getArgs();
       System.out.println("Number of Arguments : " +args.length);
       Integer val=(Integer)args[0];
       System.out.println("Argument Value : "+val);
       if(val>=40)
       pjp.proceed();
        
        System.out.println("Inside aroundAdvice() method...." + " Inserted after= " 
        						+ pjp.getSignature().getName() + " method");
       
    }
}