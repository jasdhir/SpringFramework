package springdemo;


import springdemo.model.Address;
import springdemo.model.Employee;
import springdemo.service.EmployeeService;
import springdemo.serviceimpl.EmployeeServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");
        EmployeeService empService = context.getBean("employeeServiceImpl", EmployeeService.class);
        empService.addEmployee(createEmployee());
        context.registerShutdownHook();
    }

    // Method to create Employee object
    private static Employee createEmployee() {
        Employee emp = new Employee();
        Address addr = new Address();
        emp.setEmpId(158);
        emp.setEmpName("Ravi");
        emp.setAge(25);
        // same as employee ID
        addr.setId(emp.getEmpId());
        addr.setAddrLine("Mall Road");
        addr.setCity("Bhopal jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        emp.setAddress(addr);
        return emp;
    }
}