package com.psl.business;

import com.psl.model.Student;

public interface StudentBo {

	public int createStudent(Student s) throws Exception;
	public boolean updateStudent(Student s) throws Exception;
	public boolean deleteStudent(Student s) throws Exception;
	
	
}
