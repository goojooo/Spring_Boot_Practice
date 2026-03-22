package com.jdbc.rev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "gojo");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter city want to update : ");
		String city = sc.nextLine();
		System.out.println("Enter email where to update : ");
		String email = sc.nextLine();
		PreparedStatement ps = con.prepareStatement("update regi set Location=? where email=? ");
		ps.setString(1,city);
		ps.setString(2,email);
		int i = ps.executeUpdate();
		if(i > 0 )
		{
			System.out.println("Record updated...");
		} else {
			System.out.println("Failed...");
		}
	}

}
