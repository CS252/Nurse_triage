package javaclasses;

import java.text.*; 
import java.util.*; 
import java.sql.*; 

public class PatientDAO {
	
	static Connection currentCon = null; 
	static ResultSet rs = null;
	
	public static int check_reg(String pid) {
		
		int v = 0;
		//preparing some objects for connection 
		Statement stmt = null; 
		String searchQuery = "select * from patients where patientID ='" + pid + "'";
		
		try { 
			//connect to DB 
			currentCon = ConnectionManager.getConnection(); 
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery); 
			boolean more = rs.next(); 
			// if user does not exist set the isValid variable to false 
			if (!more) { 
				v = 0; 
				}
			//if user exists set the isValid variable to true 
			else { 
				v =  1;
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
		return v;
		}
	}
