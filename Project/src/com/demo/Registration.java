package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {
	Connection connection=null;
	PreparedStatement ps=null;
	
	private void Insert(String fname,String lname,int mobile,String username,String password)throws SQLException {
		try {
			ConnectionTest connectionTest= new ConnectionTest();
			connection=connectionTest.getConnectionDetails();
			ps=connection.prepareStatement("insert into registration(firstname,lastname,mobile,username,password)values(?,?,?,?,?)");
			ps.setString(1,fname);
			ps.setString(2,lname);
			ps.setInt(3,mobile);
			ps.setString(4,username);
			ps.setString(5,password);
			int i=ps.executeUpdate();
			System.out.println("Registration done successfully..."+i);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			ps.close();
		}
	}

	public static void main(String[] args) throws SQLException{
		Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter FirstName:");
			String fname=sc.next();
			System.out.println("Enter LastName:");
			String lname=sc.next();
			System.out.println("Enter Mobile No:");
			int mobile=sc.nextInt();
			System.out.println("Enter username:");
			String username=sc.next();
			System.out.println("Enter Password:");
			String password=sc.next();
			
			Registration rs= new Registration();
			rs.Insert(fname,lname,mobile,username,password);
		
		sc.close();


	}

}
