package com.psl.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.psl.dao.EmployeeDao;
import com.psl.model.Employee;

public class Client {
	
	public static void main(String[] args) {
		
		ApplicationContext ap = new ClassPathXmlApplicationContext("com/psl/resources/spring.xml");
		
		EmployeeDao empdao = (EmployeeDao)ap.getBean("edao");
		System.out.println("Initial Employees : ");
		List<Employee> initialList = empdao.listAllEmployees();
		for(Employee e : initialList) {
			System.out.println(e.toString());
		}
		List<Employee> emplist = new ArrayList<Employee>();
		Employee e1 = new Employee();
		e1.setId(102);
		e1.setSalary(30000);
		emplist.add(e1);
		
		Employee e2 = new Employee();
		e2.setId(101);
		e2.setSalary(35000);
		emplist.add(e2);
		empdao.batchUpdate(emplist);
		
		System.out.println("After batch update Employees: ");
		List<Employee> updatedList = empdao.listAllEmployees();
		for(Employee e : updatedList) {
			System.out.println(e.toString());
		}
	}

}
