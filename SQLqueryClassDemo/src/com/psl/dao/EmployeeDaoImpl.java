package com.psl.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.SqlQuery;

import com.psl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private DataSource dataSource;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		
	}

	@Override
	public List<Employee> listAllEmployees() {
		String sql = "select * from employee";
		SqlQuery<Employee> sqlQuery = new SqlQuery<Employee>() {

			@Override
			protected RowMapper<Employee> newRowMapper(Object[] parameters, Map map) {
				
				return new EmployeeMapper();
			}
		};
		sqlQuery.setDataSource(dataSource);
		sqlQuery.setSql(sql);
		List<Employee> empList = sqlQuery.execute();
		
		return empList;
	}
}
