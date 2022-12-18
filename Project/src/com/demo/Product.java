package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Product {

	public static void main(String[] args) {
try {
			int j=0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			PreparedStatement stmt=con.prepareStatement("insert into product(description,price,name,quantity)values(?,?,?,?)"); 
			stmt.setString(1,"Product 2");
			stmt.setLong(2,900);
			stmt.setString(3,"Product 2");
			stmt.setInt(4,50);
			int i=stmt.executeUpdate();
			System.out.println("Insertion successful");
			con.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
