package com.psl.dao;

import javax.sql.DataSource;

import com.psl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private DataSource dataSource;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Employee getEmployee(Integer id) {
		
		EmployeeProcedure empProc = new EmployeeProcedure(dataSource, "getRecord");
		return empProc.execute(id);
		
	}
	
}
