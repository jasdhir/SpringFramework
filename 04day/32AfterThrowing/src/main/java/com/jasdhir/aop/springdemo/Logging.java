package com.jasdhir.aop.springdemo;

public class Logging {

    //method to be executed before selected method execution
    public void beforeAdvice() {
        System.out.println("Going to setup student profile.");
    }

    //method to be executed after selected method execution
    public void afterAdvice() {
        System.out.println("Student profile setup complete.");
    }

    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }
}