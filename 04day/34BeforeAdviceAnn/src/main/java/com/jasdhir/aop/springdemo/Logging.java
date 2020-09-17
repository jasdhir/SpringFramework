package com.jasdhir.aop.springdemo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
public class Logging {

//Following is the definition for a PointCut .
     
/*    @Pointcut("execution(* com.jasdhir.aop.springdemo.Student.getName(..))")
    private void selectAll(){}*/

    //method to be executed before selected method execution
   @Before("execution(* com.jasdhir.aop.springdemo.Student.getName(..))")
      //@Before("selectAll())")
    public void beforeAdvice() {
        System.out.println("Going to setup student profile.");
    }

    //method to be executed after selected method execution
   @After("execution(* com.jasdhir.aop.springdemo.Student.getName(..))")
  // @After("selectAll()")
    public void afterAdvice() {
        System.out.println("Student profile setup complete.");
    }
}