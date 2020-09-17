package com.jasdhir.aop.springdemo;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logging {

    //method to be executed before selected method execution
    public void beforeAdvice() {
        System.out.println("Going to setup student profile.");
    }

    //method to be executed after selected method execution
    public void afterAdvice() {
        System.out.println("Student profile setup complete.");
    }

    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("Inside aroundAdvice() method...." + " Inserted before= "+ pjp.getSignature() + " method");

        Object [] args=pjp.getArgs();
        System.out.println("Number of Arguments : " +args.length);
        Integer val=(Integer)args[0];
        System.out.println("Argument Value : "+val);
        if(val>=40)
            pjp.proceed();  // EXECUTE setAge

        System.out.println("Inside aroundAdvice() method...." + " Inserted after= "
                + pjp.getSignature().getName() + " method");
       
    }
}





