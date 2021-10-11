package com.psl.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.psl.business.StudentBo;
import com.psl.model.Student;

public class Client {
	public static void main(String[] args) {
		ConfigurableApplicationContext ap = new ClassPathXmlApplicationContext("com/psl/resources/test.xml");
		StudentBo sbo = (StudentBo)ap.getBean("bo");
		try {
			int i = sbo.createStudent(new Student(101, "aaa", "aas@gmail.com", "knp"));
			System.out.println(i);
			ap.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
