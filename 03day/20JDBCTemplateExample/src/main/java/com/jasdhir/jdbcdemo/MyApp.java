package com.jasdhir.jdbcdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");
        //dao.createTable();
        int status;
     //  status=dao.saveEmployee(new Employee(214,"Sam",30000));
        //System.out.println(status);

 //  status=dao.updateEmployee(new Employee(212,"Jasdhir Singh",15000));
   // System.out.println(status);

/*    Employee e=new Employee();
        e.setId(212);
        status=dao.deleteEmployee(e);
    System.out.println(status);*/

        //dao.saveEmployeeByPreparedStatement(new Employee(108,"Jasdhir Singh",35000));

        List<Employee> list = dao.getAllEmployees();

        for (Employee e1 : list)
            System.out.println(e1);


        List<Employee> listRM = dao.getAllEmployeesRowMapper();

        for (Employee emp : listRM)
            System.out.println(emp);

        Employee emp1=dao.findByEmployeeId(212);
        System.out.println("Single Row : " +emp1);
        ctx.close();

    }

}