package com.jasdhir.jdbcdemo;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable(){
        jdbcTemplate.execute("create table myemployee (id int, name varchar(25),salary float);");
        System.out.println("Table created");
    }
    public void dropTable(){
        jdbcTemplate.execute("drop table myemployee;");
        System.out.println("Table dropped");
    }
    public int saveEmployee(Employee e){
        String query="insert into myemployee values('"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";
        return jdbcTemplate.update(query);
    }
    public int updateEmployee(Employee e){
        String query="update myemployee set name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);
    }
    public int deleteEmployee(Employee e){
        String query="delete from myemployee where id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);
    }
    public Boolean saveEmployeeByPreparedStatement(final Employee e){
        String query="insert into myemployee values(?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,e.getId());
                ps.setString(2,e.getName());
                ps.setFloat(3,e.getSalary());

                return ps.execute();

            }
        });
    }

    public List<Employee> getAllEmployees(){
        return jdbcTemplate.query("select * from myemployee",new ResultSetExtractor<List<Employee>>(){
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {

                List<Employee> list=new ArrayList<Employee>();
                while(rs.next()){
                    Employee e=new Employee();
                    e.setId(rs.getInt(1));
                    e.setName(rs.getString(2));
                    e.setSalary(rs.getFloat(3));
                    list.add(e);
                }
                return list;
            }
        });
    }

    public List<Employee> getAllEmployeesRowMapper(){
        return jdbcTemplate.query("select * from myemployee",new RowMapper<Employee>(){
            @Override
            public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
                Employee e=new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setSalary(rs.getFloat(3));
                return e;
            }
        });
    }
    public Employee findByEmployeeId(int empId){

        String sql = "SELECT * FROM myemployee WHERE ID = ?";

        Employee employee = (Employee) jdbcTemplate.queryForObject(sql,  new EmployeeRowMapper(), empId);

        return employee;
    }

}
