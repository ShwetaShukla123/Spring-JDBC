package com.psl.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.psl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private DataSource dataSource;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		
	}
	
	@Override
	public Employee getEmployee(Integer id) {
				
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
		SqlParameterSource in =  new MapSqlParameterSource().addValue("in_id", id);
		Map<String, Object> out = jdbcCall.execute(in);
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName((String)out.get("OUT_NAME"));
		emp.setSalary(((BigDecimal)out.get("OUT_SALARY")).floatValue());
		return emp;
	}
}