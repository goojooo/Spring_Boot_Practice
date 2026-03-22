package com.jdbc.rev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class loaded successfully...!");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "gojo");
		System.out.println("Connection Successfully...!");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter email : ");
		String email = sc.nextLine();
		
		System.out.println("Enter password : ");
		String pwd = sc.nextLine();
		
		System.out.println("Enter location : ");
		String loc = sc.nextLine();
		
		
		PreparedStatement ps = con.prepareStatement("insert into regi values (?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, pwd);
		ps.setString(4, loc);
		int i = ps.executeUpdate();
		if(i > 0)
		{
		System.out.println("Record added...");	
		} else
		{
			System.out.println("Failed");
		}
		
		con.close();
	}
}
