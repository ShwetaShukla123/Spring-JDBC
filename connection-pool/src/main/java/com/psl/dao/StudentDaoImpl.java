package com.psl.dao;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import com.psl.model.Student;

public class StudentDaoImpl implements StudentDao {
	
	private DataSource ds;
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public int save(Student s) throws Exception {
		Connection con = ds.getConnection();
		con.close();
		return 0;
	}

	public boolean update(Student s) throws Exception {
		Connection con = ds.getConnection();
		con.close();
		return false;
	}

	public boolean delete(Student s) throws Exception {
		Connection con = ds.getConnection();
		con.close();
		return false;
	}

	public Student findById(int id) throws Exception {
		Connection con = ds.getConnection();
		con.close();
		return null;
	}

	public Student findByName(String name) throws Exception {
		Connection con = ds.getConnection();
		con.close();
		return null;
	}

	public Student findByEmail(String email) throws Exception {
		Connection con = ds.getConnection();
		con.close();
		return null;
	}

	public Student findByAddress(String address) throws Exception {
		Connection con = ds.getConnection();
		con.close();
		return null;
	}

	public List<Student> findAll() throws Exception {
		Connection con = ds.getConnection();
		con.close();
		return null;
	}

	
}
