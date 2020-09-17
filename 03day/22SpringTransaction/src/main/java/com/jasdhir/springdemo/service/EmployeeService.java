package com.jasdhir.springdemo.service;

import com.jasdhir.springdemo.model.Employee;

public interface EmployeeService {
    public Employee getEmployee(int empId);
    public void addEmployee(Employee emp);
}
