package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Department {
	//A common method to connect to the DB 
	private Connection connect() {
		Connection con = null;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
					 
			//Provide the correct details: DBServer/DBName, username, password 
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcaredb", "root", "");

			//For testing          
			System.out.print("Successfully connected");
					 
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		return con; 
		}
	
	public String insertDepartments(String hos_id, String dep_name, String head, String staff_vacon) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement   
			String query = " insert into departments (`Department_ID`,`Hospital_ID`,`Department_Name`,`Head`,`Staff_Vacancies`)"+" values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values 
			preparedStmt.setInt(1, 0);   
			preparedStmt.setInt(2, Integer.parseInt(hos_id));
			preparedStmt.setString(3, dep_name);    
			preparedStmt.setString(4, head);
			preparedStmt.setInt(5, Integer.parseInt(staff_vacon));  

			//execute the statement   
			preparedStmt.execute();   
			con.close(); 

			output = "Inserted successfully";
		}
		catch (Exception e) {   
			output = "Error while inserting Departments to the hospitals.";   
			System.err.println(e.getMessage());  
		} 

		 return output; 
	}
	
	public String readDepartments() {  
		String output = "";  


		try {  
			Connection con = connect();  
			if (con == null)  {   
				return "Error while connecting to the database for reading.";  
			} 

		// Prepare the html table to be displayed   
		output = "<table border=\"1\"><tr><th>Department Name</th>"    +""
				+ "<th>Hospital Name</th><th>Head of Department</th>"    + ""
				+ "<th>Number of Staff Vaconcies</th>"    + ""
						+ "<th>Update</th><th>Remove</th></tr>"; 

		  String query1 = "select d.Department_ID,d.Department_Name,h.Hospital_Name,d.Head,d.Staff_Vacancies from departments d,hospitals h where d.Hospital_ID = h.Hospital_ID";
		  Statement stmt = con.createStatement();   
		  ResultSet rs1 = stmt.executeQuery(query1); 
		  
		  // iterate through the rows in the result set   
		  while (rs1.next())   {
			  String Department_ID = Integer.toString(rs1.getInt("Department_ID"));   
			  String Department_Name = rs1.getString("Department_Name");
			  String Hospital_Name = rs1.getString("Hospital_Name");
			  String Head = rs1.getString("Head");
			  String Staff_Vacancies = Integer.toString(rs1.getInt("Staff_Vacancies"));  

		   // Add into the html table    
		  output += "<tr><td>" + Department_Name + "</td>";    
		  output += "<td>" + Hospital_Name + "</td>";
		  output += "<td>" + Head + "</td>";
		  output += "<td>" + Staff_Vacancies + "</td>";
		   

		   // buttons    
		  output += "<td><input name=\"btnUpdate\" "     + " "
		  		+ "type=\"button\" value=\"Update\"></td>"     + ""
		  				+ "<td><form method=\"post\" action=\"departments.jsp\">"     + ""
		  						+ "<input name=\"btnRemove\" "     + " "
		  								+ "type=\"submit\" value=\"Remove\">"     + ""
		  										+ "<input name=\"Department_ID\" type=\"hidden\" "     + " "
		  												+ "value=\"" + 
		  												Department_ID + "\">" + "</form></td></tr>";   
		  } 

		  con.close(); 

		  // Complete the html table   
		  output += "</table>"; 
		}
		catch (Exception e) {  
			output = "Error while reading the Department data.";  
			System.err.println(e.getMessage()); 
		}

		return output;
	}
	
	public String updateDepartments(String dep_id, String hos_id, String dep_name, String head, String staff_vacon)  {   
		String output = ""; 
	 
	  try   {   
		  Connection con = connect(); 
	 
		  if (con == null)    {
			  return "Error while connecting to the database for updating."; 
		  } 
	 
	   // create a prepared statement    
	   String query = "UPDATE departments SET Hospital_ID=?,Department_Name=?,Head=?,Staff_Vacancies=?      "
	   		+ "			WHERE Department_ID=?"; 
	 
	   PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	   // binding values    
	   preparedStmt.setInt(1, Integer.parseInt(hos_id));
	   preparedStmt.setString(2, dep_name);    
	   preparedStmt.setString(3, head);
	   preparedStmt.setInt(4, Integer.parseInt(staff_vacon));
	   preparedStmt.setInt(5, Integer.parseInt(dep_id));
	 
	   // execute the statement    
	   preparedStmt.execute();    
	   con.close(); 
	 
	   output = "Updated successfully";   
	   }   catch (Exception e)   {    
		   output = "Error while updating the Departments Details.";    
		   System.err.println(e.getMessage());   
	   } 
	 
	  return output;  
	  }
}
