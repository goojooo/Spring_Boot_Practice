package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con;
	
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
	private static final String userName = "root";
	private static final String password = "gojo";
	
	public static Connection getConnection() throws SQLException {
		
		if(con == null)
		{
		con = DriverManager.getConnection(url,userName,password);
		}
	
		return con;
	}
	
}
