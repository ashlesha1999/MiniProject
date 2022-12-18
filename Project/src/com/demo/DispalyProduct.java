package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DispalyProduct {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			ConnectionTest connectionTest= new ConnectionTest();
			connection=connectionTest.getConnectionDetails();
			ps=connection.prepareStatement("Select * from product order by name ASC"); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			System.out.println("Id="+rs.getInt(1));
			System.out.println("Descrption="+rs.getString(2));
			System.out.println("Price="+rs.getInt(1));
			System.out.println("Name="+rs.getString(2));
			System.out.println("Qunatity="+rs.getInt(3));
			}
			connection.close();
			ps.close();
			rs.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
