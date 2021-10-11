package com.psl.dao;

import java.util.List;

import javax.sql.DataSource;

import com.psl.model.Employee;

public interface EmployeeDao {
	
	public void setDataSource(DataSource ds);
	
	public List<Employee> listAllEmployees();
	
}