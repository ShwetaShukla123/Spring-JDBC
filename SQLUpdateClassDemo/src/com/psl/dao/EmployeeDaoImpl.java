package com.psl.dao;

import java.sql.Types;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import com.psl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Employee getEmployee(Integer id) {
		String sql = "Select * from Employee where id = ?";
		Employee emp = jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeMapper());
		return emp;
	}

	@Override
	public void updateEmployee(Integer id, Float salary) {
		
		String sql = "Update Employee set salary = ? where id = ?";
		
		SqlUpdate sqlUpdate = new SqlUpdate(dataSource, sql);
		sqlUpdate.declareParameter(new SqlParameter("salary", Types.FLOAT));
		sqlUpdate.declareParameter(new SqlParameter("id", Types.INTEGER));
		sqlUpdate.compile();
		
		sqlUpdate.update(salary.floatValue(), id.intValue());
		System.out.println("Record Updated");
	}	
}
