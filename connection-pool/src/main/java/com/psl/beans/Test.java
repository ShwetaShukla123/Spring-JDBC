package com.psl.beans;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class Test {
	
	public static void main(String[] args) {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		bds.setUsername("sys as sysdba");
		bds.setPassword("123");
		bds.setMaxActive(15);
		bds.setMaxIdle(5);
		bds.setMaxWait(1000*5);
		
		for(int i=0;i<15;i++) {
			try {
				Connection con = bds.getConnection();
				System.out.println(con +" : " +i);
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
