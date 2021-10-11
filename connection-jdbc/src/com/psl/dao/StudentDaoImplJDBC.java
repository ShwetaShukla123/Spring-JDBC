package com.psl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import com.psl.model.Student;

public class StudentDaoImplJDBC implements StudentDao {
	
	private DataSource ds;
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public int save(Student s) throws Exception {
		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
		ps.setInt(1, s.getId());
		ps.setString(2, s.getName());
		ps.setString(3, s.getEmail());
		ps.setString(4, s.getAddress());
		int i = ps.executeUpdate();
		con.close();
		return i;
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
