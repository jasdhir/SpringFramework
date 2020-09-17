package com.jasdhir.springdemo.dao;

import com.jasdhir.springdemo.model.Employee;

public interface EmployeeDAO {
    public Employee findEmployee(int empId);
    public void insertEmployee(Employee emp);
}
