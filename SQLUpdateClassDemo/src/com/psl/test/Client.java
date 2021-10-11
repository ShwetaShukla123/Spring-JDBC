package com.psl.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.psl.dao.EmployeeDao;
import com.psl.model.Employee;

public class Client {
	
	public static void main(String[] args) {
		
		ApplicationContext ap = new ClassPathXmlApplicationContext("com/psl/resources/spring.xml");
		
		EmployeeDao empdao = (EmployeeDao)ap.getBean("edao");
		System.out.println("Before update");
		Employee emp = empdao.getEmployee(2);
		System.out.println(emp.toString());
		empdao.updateEmployee(2, 30000.0f);
	}
}
