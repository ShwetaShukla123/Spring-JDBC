package com.psl.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.psl.dao.EmployeeDao;

public class Client {
	
	public static void main(String[] args) {
		
		ApplicationContext ap = new ClassPathXmlApplicationContext("com/psl/resources/spring.xml");
		
		EmployeeDao empdao = (EmployeeDao)ap.getBean("edao");
		System.out.println(empdao.getEmployee(2).toString());
	}

}
