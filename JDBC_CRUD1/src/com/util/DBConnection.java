package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
	private static final String userName = "root";
	private static final String password = "gojo";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url,userName,password);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
