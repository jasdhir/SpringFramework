package com.jasdhir.springdemo;

import org.springframework.cache.annotation.Cacheable;

public class Employee  {

	private String emp_name = "";

	//This 'employeeCache' Is Declared In The 'ehcache.xml'
	@Cacheable(value="employeeCache") 
	public String getEmployeeName(int emp_id) {

		if(emp_id == 101) {
			emp_name = "Jasdhir Singh";
		} else {
			emp_name = "Jasdhir S";
		}
		System.out.println("Get Employee Method Called . . . . .");

		return emp_name;
	}
}