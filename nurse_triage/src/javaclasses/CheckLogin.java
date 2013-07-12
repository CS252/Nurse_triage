package javaclasses;

import java.sql.*; 
import java.util.*;

public class CheckLogin {
	
	static Connection currentCon = null; 
	static ResultSet rs = null;
	
public static String checklogin(LoginPojo mypojo) {
		
		String groupId = null;
		//preparing some objects for connection 
		Statement stmt = null; 
		String searchQuery = "select * from ACT_ID_USER where ID_ ='" + mypojo.getUsername() + 
				              "'and PWD_ = '" + mypojo.getPassword() + "'";
		  
		System.out.println("Query: "+searchQuery); 
		try { 
			//connect to DB 
			currentCon = ConnectionManager.getConnection(); 
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			
			boolean more = rs.next(); 
			// if user does not exist set the isValid variable to false 
			if (!more) { 
				System.out.println("Sorry, you are not a registered user! Please sign up first"); 
				 
				}
			//if user exists set the isValid variable to true 
			else { 
				String searchQuery2 = "select * from ACT_ID_MEMBERSHIP where USER_ID_ ='" + mypojo.getUsername() +  "'";
				rs = stmt.executeQuery(searchQuery2);
				if (rs.next())
				{
				 groupId = rs.getString("GROUP_ID_");
				}		
			}
			} 
		catch (Exception ex) { 
			System.out.println("Log In failed: An Exception has occurred! " + ex); 
			} 
		//some exception handling 
		finally { 
			if (rs != null) { 
				try {
			rs.close(); 
			} 
				
				catch (Exception e) {} 
				rs = null; 
			} 
			if (stmt != null) { 
				try { 
					stmt.close(); 
					} 
				catch (Exception e) {} 
				stmt = null; 
				} 
			if (currentCon != null) { 
				try { 
					currentCon.close(); 
				} 
				catch (Exception e) { } 
				currentCon = null; 
				} 
			}
		return groupId;
		}
	}
	



	
	
	
