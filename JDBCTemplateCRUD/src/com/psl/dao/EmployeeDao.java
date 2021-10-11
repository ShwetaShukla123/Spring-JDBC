package com.psl.dao;

import com.psl.model.Employee;

public interface EmployeeDao {
	
	public int saveEmployee(Employee e);
	public int updateEmployee(Employee e);
	public int deleteEmployee(Employee e);
	
}
