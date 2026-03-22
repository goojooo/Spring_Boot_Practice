package com.jdbc.rev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","gojo");
		PreparedStatement ps = con.prepareStatement("select * from regi");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			String name = rs.getString("Name");
			String email = rs.getString("Email");
			String pwd = rs.getString("Password");
			String loc = rs.getString("Location");
			
			System.out.println("Users data : " + name + " " + email + " " + pwd + " " + loc);
		}
		
		con.close();
		
		System.out.println("Data retrive successfully...");
	}

}
