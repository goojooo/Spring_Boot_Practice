package com.jdbc.rev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DeleteDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "gojo");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name want to delete : ");
		String name = sc.nextLine();
		PreparedStatement ps = con.prepareStatement("delete from regi where name=? ");
		ps.setString(1,name);
		int i = ps.executeUpdate();
		if(i>0)
		{
			System.out.println("Record deleted...");
		} else {
			System.out.println("Failed...");
		}
	}

}
