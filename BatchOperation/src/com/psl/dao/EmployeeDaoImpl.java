package com.psl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.psl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Employee> listAllEmployees() {
		String sql = "select * from employee";
		List<Employee> empList = jdbcTemplate.query(sql, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				return emp;
			}
			
		});
		return empList;
	}
	

	@Override
	public void batchUpdate(final List<Employee> employees) {
		String sql = "update employee set salary = ? where id = ?";
		int [] updateCount = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setFloat(1, employees.get(i).getSalary());
				ps.setInt(2, employees.get(i).getId());
			}
			
			@Override
			public int getBatchSize() {
				return employees.size();
			}
		});
		if(updateCount.length > 0) {
			System.out.println("   records updated");
		}
	}

}
