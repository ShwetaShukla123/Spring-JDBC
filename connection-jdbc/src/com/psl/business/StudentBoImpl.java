package com.psl.business;

import com.psl.dao.StudentDao;
import com.psl.model.Student;

public class StudentBoImpl implements StudentBo {
	
	private StudentDao studentDao; 
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public int createStudent(Student s) throws Exception {
		
		return studentDao.save(s);
	}

	@Override
	public boolean updateStudent(Student s) throws Exception {
		
		return studentDao.update(s);
	}

	@Override
	public boolean deleteStudent(Student s) throws Exception {
		
		return studentDao.delete(s);
	}

	
}
