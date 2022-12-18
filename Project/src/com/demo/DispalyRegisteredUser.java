package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DispalyRegisteredUser {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			ConnectionTest connectionTest= new ConnectionTest();
			connection=connectionTest.getConnectionDetails();
			ps=connection.prepareStatement("Select * from registration"); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			System.out.println("Id="+rs.getInt(1));
			System.out.println("FirstName="+rs.getString(2));
			System.out.println("LastName="+rs.getString(3));
			System.out.println("Mobile="+rs.getInt(4));
			System.out.println("Username="+rs.getString(5));
			System.out.println("Password="+rs.getString(6));
			}
			connection.close();
			ps.close();
			rs.close();
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
