package springdemo.serviceimpl;

import springdemo.dao.EmployeeDAO;
import springdemo.model.Employee;
import springdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO empDAO;

    public void setEmpDAO(EmployeeDAO empDAO) {
        this.empDAO = empDAO;
    }

    public Employee getEmployee(int empId) {
        return empDAO.findEmployee(empId);
    }


   // @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
    public void addEmployee(Employee emp) {
        empDAO.insertEmployee(emp);
    }
}