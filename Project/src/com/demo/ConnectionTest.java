package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
    public Connection getConnectionDetails() {
    	Connection con=null;
    	try {
    		//load the driver
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		//Establish Connection 
    		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
    		
    		
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	
    	return con;
    }
}
