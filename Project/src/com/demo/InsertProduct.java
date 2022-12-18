package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertProduct {
	Connection connection=null;
	PreparedStatement ps=null;
	//Design method to insert data
	private void InsertPr(String description,double price,String name,int quantity)throws SQLException {
		try {
			ConnectionTest connectionTest= new ConnectionTest();
			connection=connectionTest.getConnectionDetails();
			ps=connection.prepareStatement("insert into product(description,price,name,quantity)values(?,?,?,?)");
			ps.setString(1,description);
			ps.setDouble(2,price);
			ps.setString(3,name);
			ps.setInt(4,quantity);
			int i=ps.executeUpdate();
			System.out.println("Record inserted successfully..."+i);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			ps.close();
		}
	}

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++) {
			System.out.println("Enter Product Description:");
			String description=sc.next();
			System.out.println("Enter Product Price:");
			double price=sc.nextDouble();
			System.out.println("Enter Product Name:");
			String name=sc.next();
			System.out.println("Enter Product Quantity:");
			int quantity=sc.nextInt();
			
			InsertProduct ip= new InsertProduct();
			ip.InsertPr(description,price,name,quantity);
		}
		sc.close();

	}

}
