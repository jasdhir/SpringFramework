package springdemo.daoimpl;

import springdemo.dao.EmployeeDAO;
import springdemo.model.Address;
import springdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeDAOImpl implements EmployeeDAO {


    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //@Override
    public Employee findEmployee(int empId) {
        final String SELECT_BY_ID_QUERY = "select emp.id, name, age, address, city from employee emp, address adr "
                + "where emp.id = adr.id and emp.id = ?";
        return this.jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new EmployeeMapper(), empId);
    }

    private static final class EmployeeMapper implements RowMapper<Employee> {
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee emp = new Employee();
            Address addr = new Address();
            emp.setEmpId(rs.getInt("id"));
            emp.setEmpName(rs.getString("name"));
            emp.setAge(rs.getInt("age"));
            addr.setAddrLine("address");
            addr.setCity("city");
            emp.setAddress(addr);
            return emp;
        }
    }



   // @Override
    public void insertEmployee(Employee emp) {
        final String INSERT_EMP_QUERY = "insert into employee (id, name, age) values (?, ?, ?)";
        final String INSERT_ADDR_QUERY = "insert into address (id, address, city) values (?, ?, ?)";

        jdbcTemplate.update(INSERT_EMP_QUERY, emp.getEmpId(), emp.getEmpName(), emp.getAge());
        System.out.println("Employee record inserted");
        jdbcTemplate.update(INSERT_ADDR_QUERY, emp.getEmpId(), emp.getAddress().getAddrLine(), emp.getAddress().getCity());
        System.out.println("Employee address record inserted");

    }
}
