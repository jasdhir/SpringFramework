package com.jasdhir.springdemo;


import com.jasdhir.springdemo.model.Address;
import com.jasdhir.springdemo.model.Employee;
import com.jasdhir.springdemo.service.EmployeeService;
import com.jasdhir.springdemo.serviceimpl.EmployeeServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");
        EmployeeService empService = context.getBean("employeeServiceImpl", EmployeeServiceImpl.class);
        empService.addEmployee(createEmployee());
        context.registerShutdownHook();
    }

    // Method to create Employee object
    private static Employee createEmployee() {
        Employee emp = new Employee();
        Address addr = new Address();
        emp.setEmpId(155);
        emp.setEmpName("Jasdhir");
        emp.setAge(40);
        // same as employee ID
        addr.setId(emp.getEmpId());
        addr.setAddrLine("Mall Road");
        addr.setCity("Bhopal eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        emp.setAddress(addr);
        return emp;
    }
}