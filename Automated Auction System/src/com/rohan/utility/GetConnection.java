package com.rohan.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GetConnection {
	
	public static Connection get() {
		
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		String url = "jdbc:mysql://localhost:3306/auction_main";
		
		try {
			
			
			conn = DriverManager.getConnection(url , "root" , "rohan@2004");
			
			
		}
		catch(SQLException e) {
			
			System.out.println("ERROR 202 : Unable to Connect with server");
			
		}
		
		
		
		
		return conn;
	}
	
}
