package com.jasdhir.springdemo.serviceimpl;

import com.jasdhir.springdemo.dao.EmployeeDAO;
import com.jasdhir.springdemo.model.Employee;
import com.jasdhir.springdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO empDAO;


    public Employee getEmployee(int empId) {
        return empDAO.findEmployee(empId);
    }


    @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public void addEmployee(Employee emp) {
        empDAO.insertEmployee(emp);
    }
}