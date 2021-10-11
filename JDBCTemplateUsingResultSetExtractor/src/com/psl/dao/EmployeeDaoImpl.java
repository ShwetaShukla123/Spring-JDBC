package com.psl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.psl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private JdbcTemplate template;

	public void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}
	

	@Override
	public List<Employee> getAllEmployees() {
		return template.query("select * from Employee", new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> list = new ArrayList<>();
				while(rs.next()) {
					Employee e = new Employee();
					e.setId(rs.getInt(1));
					e.setName(rs.getNString(2));
					e.setSalary(rs.getFloat(3));
					
					list.add(e);
				}
				return list;
			}
		});
	}
}
