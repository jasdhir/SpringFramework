package com.jasdhir.aop.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MyApp {
    public static void main(String[] args) {
		  ApplicationContext context = new
		 ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = (Student) context.getBean("student",Student.class);
        
        student.setAge(41);
        student.getName();
        student.getAge();
        
    }
}
