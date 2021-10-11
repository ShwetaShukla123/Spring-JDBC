package com.psl.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.psl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
//	
//	@Override
//	public int saveEmployee(Employee e) {
//		String query = "insert into employee values('"+e.getId()+"', '"+e.getName()+"', '"+e.getSalary()+"')";
//		return jdbcTemplate.update(query);
//	}
	
	@Override
	public int saveEmployee(Employee e) {
		String query = "insert into employee values(?,?,?)";
		return jdbcTemplate.update(query, e.getId(), e.getName(), e.getSalary());
	}

	@Override
	public int updateEmployee(Employee e) {
		String query="update employee set name = '"+e.getName()+"', salary='"+e.getSalary()+"' where id = '"+e.getId()+"' ";  
		return jdbcTemplate.update(query);  
	}

	@Override
	public int deleteEmployee(Employee e) {
		 String query="delete from employee where id='"+e.getId()+"' ";
		return jdbcTemplate.update(query);
	}

	

}
