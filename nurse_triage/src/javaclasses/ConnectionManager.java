package javaclasses;

import java.sql.*; 
import java.util.*;

public class ConnectionManager {
	
	static Connection con;
	static String url;
	
	public static Connection getConnection() { 
		try { 
			String url = "jdbc:mysql://localhost:3306/activiti_standalone";
		// assuming "DataSource" is your DataSource name 
		Class.forName("com.mysql.jdbc.Driver");
		try { 
			//String url = "jdbc:mysql://localhost:3306/activiti";
			con = DriverManager.getConnection(url,"root","mysql");
		// assuming your SQL Server's username is "username" // and password is "password" }
		
		}
		 catch (SQLException ex) { 
			 ex.printStackTrace();
			 } 
		}
		
 catch(ClassNotFoundException e) { 
		System.out.println(e); 
		} 
		
	return con;
	}
}