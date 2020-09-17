package com.jasdhir.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	static int emp_id;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext  contextObj = new AnnotationConfigApplicationContext ();
		contextObj.register(SpringConfig.class);
		contextObj.refresh();

		Employee empObj = (Employee) contextObj.getBean(Employee.class);


		emp_id = 101;
		System.out.println("Fetching Employee Name With Id?= " + emp_id);
		System.out.println("Name?= " + empObj.getEmployeeName(emp_id));

		emp_id = 102;
		System.out.println("\n!--- Again Fetching Employee Name With Id?= " + emp_id);
		System.out.println("Name?= " + empObj.getEmployeeName(emp_id));

		// Calling 'getEmployeeName' Method For The Third Time With A Different Value.
		emp_id = 101;
		System.out.println("\nFetching Employee Name With Id?= " + emp_id);
		System.out.println("Name?= " + empObj.getEmployeeName(emp_id));



		// Closing The Spring Context.
		contextObj.close();
	}
}