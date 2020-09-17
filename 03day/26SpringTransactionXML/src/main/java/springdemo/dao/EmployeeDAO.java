package springdemo.dao;

import springdemo.model.Employee;

public interface EmployeeDAO {
    public Employee findEmployee(int empId);
    public void insertEmployee(Employee emp);
}
