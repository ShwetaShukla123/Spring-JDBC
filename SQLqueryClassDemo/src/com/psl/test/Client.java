package com.psl.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.psl.dao.EmployeeDao;
import com.psl.model.Employee;

public class Client {
	
	public static void main(String[] args) {
		
		ApplicationContext ap = new ClassPathXmlApplicationContext("com/psl/resources/spring.xml");
		
		EmployeeDao empdao = (EmployeeDao)ap.getBean("edao");
		List<Employee> empList = empdao.listAllEmployees();
		for(Employee e : empList) {
			System.out.println(e.toString());
		}
	}

}
