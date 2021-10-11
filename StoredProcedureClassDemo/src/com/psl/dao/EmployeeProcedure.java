package com.psl.dao;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.psl.model.Employee;

public class EmployeeProcedure extends StoredProcedure {
	
	public EmployeeProcedure(DataSource dataSource, String procedureName) {
		super(dataSource, procedureName);
		declareParameter(new SqlParameter("in_id", Types.INTEGER));
		declareParameter(new SqlOutParameter("out_name", Types.VARCHAR));
		declareParameter(new SqlOutParameter("out_salary", Types.FLOAT));
		compile();
	}

	public Employee execute(Integer id) {
		Map<String, Object> out = super.execute(id);
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName((String)out.get("out_name"));
		emp.setSalary(((Double)out.get("out_salary")).floatValue());
		return emp;
	}
}
