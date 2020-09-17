package springdemo.service;

import springdemo.model.Employee;

public interface EmployeeService {
    public Employee getEmployee(int empId);
    public void addEmployee(Employee emp);
}
