package com.psl.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.psl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Override
	public int saveEmployee(Employee e) {
		String query = "insert into employee values(:id, :name, :salary)";
		
		Map<String, Object> emp = new HashMap<>();
		emp.put("id", e.getId());
		emp.put("name", e.getName());
		emp.put("salary", e.getSalary());
		
		return jdbcTemplate.execute(query, emp, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});
	}
}
