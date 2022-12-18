package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Cart {

	public void CartIns(int productid,String description,int price,String name,int quantity)throws SQLException {
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			ConnectionTest connectionTest= new ConnectionTest();
			connection=connectionTest.getConnectionDetails();
			ps=connection.prepareStatement("insert into cart(productid,description,price,name,quantity)values(?,?,?,?,?)");
			ps.setInt(1,productid);
			ps.setString(2,description);
			ps.setInt(3,price);
			ps.setString(4,name);
			ps.setInt(5,quantity);
			int i=ps.executeUpdate();
			System.out.println("Cart added successfully..."+i);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			ps.close();
		}
	}
public static void main(String[] args) throws SQLException{
	Scanner sc = new Scanner(System.in);
	SingleRetrival sr = new SingleRetrival();
	
	//int productid=sr.a;
	//String description=sr.str1;
	//int price=sr.b;
	//String name=sr.str2;
	//int quantity=sr.c;
	
	Cart rs= new Cart();
	//rs.CartIns(productid,description,price,name,quantity);

sc.close();



}	

}
