package com.psl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.psl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private JdbcTemplate template;

	public void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}
	

	@Override
	public List<Employee> getAllEmployees() {
		return template.query("select * from Employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				return emp;
			}
			
		});
	}
}
