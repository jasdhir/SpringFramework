package com.jasdhir.jdbcdemo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee emp=new Employee();
        emp.setId(resultSet.getInt(1));
        emp.setName(resultSet.getString(2));
        emp.setSalary(resultSet.getFloat(3));
        return emp;
    }
}
