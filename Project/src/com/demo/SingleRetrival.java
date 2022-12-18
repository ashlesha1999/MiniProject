package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SingleRetrival {
 
	private int a;
	private String str1;
	private int b;
	private String str2;
	private int c;
	public static void main(String[] args) throws SQLException {
		int a,b,c;
		 String str1,str2;
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			ConnectionTest connectionTest= new ConnectionTest();
			connection=connectionTest.getConnectionDetails();
			ps=connection.prepareStatement("Select * from product where productid=1"); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			System.out.println("Id="+rs.getInt(1));
			System.out.println("Descrption="+rs.getString(2));
			System.out.println("Price="+rs.getInt(3));
			System.out.println("Name="+rs.getString(4));
			System.out.println("Qunatity="+rs.getInt(5));
			 a=rs.getInt(1);
		     str1=rs.getString(2);
			 b=rs.getInt(3);
			 str2=rs.getString(4);
			 c=rs.getInt(5);
			System.out.println(a);
			System.out.println(str1);
			System.out.println(b);
			System.out.println(str2);
			System.out.println(c);
			}
			connection.close();
			ps.close();
			rs.close();
		}catch(Exception e) {
			System.out.println(e);
		}
              SingleRetrival sr = new SingleRetrival();
		
		int productid=sr.a;
		String description=sr.str1;
		int price=sr.b;
		String name=sr.str2;
		int quantity=sr.c;
		sr.CartIns(productid,description,price,name,quantity);
	}
		private void CartIns(int productid,String description,int price,String name,int quantity)throws SQLException {
			Connection connection=null;
			PreparedStatement ps=null;
			try {
				ps=connection.prepareStatement("insert into cart(productid,description,price,name,quantity)values(?,?,?,?,?)");
				ps.setInt(1,productid);
				ps.setString(2,description);
				ps.setInt(3,price);
				ps.setString(4,name);
				ps.setInt(5,quantity);
				int i=ps.executeUpdate();
				System.out.println("Cart added successfully..."+i);
				
			}catch(Exception se) {
				se.printStackTrace();
			}finally {
				connection.close();
				ps.close();
			}
		}
		
		
		
		
	

}
