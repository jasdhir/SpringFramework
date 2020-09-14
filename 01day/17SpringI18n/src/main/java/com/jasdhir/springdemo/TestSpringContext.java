package com.jasdhir.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class TestSpringContext {
    public static void main(String[] args) throws Exception
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        String message = context.getMessage("msg.text", null, Locale.FRANCE);

        System.out.println("Message from French Resource Bundle : "+message);

        String messageEN = context.getMessage("msg.text", null, Locale.US);

        System.out.println("Message from US Resource Bundle : "+messageEN);

        String messageIT = context.getMessage("msg.text", null, Locale.ITALIAN);

        System.out.println("Message from Italian Resource Bundle : "+messageIT);
    }
}
