package com.psl.dao;

import javax.sql.DataSource;

import com.psl.model.Employee;

public interface EmployeeDao {
	
	public void setDataSource(DataSource ds);
	
	public Employee getEmployee(Integer id);
	
}