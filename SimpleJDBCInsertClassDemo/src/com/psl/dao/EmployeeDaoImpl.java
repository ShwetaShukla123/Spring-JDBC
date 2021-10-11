package com.psl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.psl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private JdbcTemplate jdbcTemplate;
	SimpleJdbcInsert jdbcInsert;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("Employee");
	}

	@Override
	public void create(String name, float salary) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", name);
		parameters.put("salary", salary);
		jdbcInsert.execute(parameters);
		System.out.println("record inserted");
	}

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select * from employee";
		List<Employee> empList = jdbcTemplate.query(sql, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int i) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				return emp;
			}
		});
		return empList;
	}
}
