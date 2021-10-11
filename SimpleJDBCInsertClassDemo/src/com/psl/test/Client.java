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
		empdao.create("Ram", 30000);
		empdao.create("Shyam", 40000);
		List<Employee> empList = empdao.getAllEmployees();
		for(Employee e : empList) {
			System.out.println(e.toString());
		}
	}

}
