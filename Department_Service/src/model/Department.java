package model;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
