package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

public class Schedule{
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/healthcaredb?useTimezone=true&serverTimezone=UTC",
					"root", "");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	

	//===================== View Appointment Types ==========================
	
//	public String viewAppointmentTypes() {
//
//		String output = "";
//		try {
//			Connection con = connect();
//			if (con == null) {
//				return "Error while connecting to the database for reading.";
//			}
//			// Prepare the html table to be displayed
//			output = "<table border=\"1\"><tr><th>Appointment ID</th>"
//					+ "<th>Appointment Type</th><th>Appointment Name</th>" + "<th>Appointment Desc</th></tr>";
//
//			String query = "select * from appointment_type";
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//
//			// iterate through the rows in the result set
//			while (rs.next()) {
//				String app_id = rs.getString("appointment_Id");
//				String app_type = rs.getString("Appointment_Type");
//				String app_name = rs.getString("Appointment_Name");
//				String app_desc = rs.getString("Appointment_Desc");
//
//				// Add into the html table
//				output += "<tr><td>" + app_id + "</td>";
//				output += "<td>" + app_type + "</td>";
//				output += "<td>" + app_name + "</td>";
//				output += "<td>" + app_desc + "</td>";
//
//			}
//
//			con.close();
//			// Complete the html table
//			output += "</table>";
//
//		} catch (Exception e) {
//			output = "Error while reading the Doctors Details.";
//			System.err.println(e.getMessage());
//		}
//
//		return output;
//	}
//	
//	//========================= View All Schedule ==========================
	public int d_id;
	
	public String viewAllSchedule() {

		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Schedule Id</th>"
					+ "<th>Date</th>" 
					+ "<th>Start Time</th>" 
					+ "<th>End Time</th>"
					+ "<th>Doctor Id</th>"
					+ "<th>Hostpital Id</th>"
					+ "<th>Appointment Id</th>"
					+ "<th>Appointment Type</th></tr>";

			String query = "select * from appointment_scheduling";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String schedule_id = rs.getString("Schedule_id");
				String date = rs.getString("Date");
				String start_time = rs.getString("Start_Time");
				String end_time = rs.getString("End_Time");
				String d_id = rs.getString("D_Id");
				String h_id = rs.getString("H_Id");
				String app_id = rs.getString("App_id");
				String app_type = rs.getString("App_type");

				// Add into the html table
				output += "<tr><td>" + schedule_id + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + start_time + "</td>";
				output += "<td>" + end_time + "</td>";
				output += "<td>" + d_id + "</td>";
				output += "<td>" + h_id + "</td>";
				output += "<td>" + app_id + "</td>";
				output += "<td>" + app_type+ "</td></tr>";

			}

			con.close();
			// Complete the html table
			output += "</tr></table>";

		} catch (Exception e) {
			output = "Error while reading the Doctors Details.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	
	//====================== Add In To Appointment Scheduling ========================
//	
//	public String makeAppoinment(String date, double start_time, double end_time, int d_id, int h_id, int app_id, String app_type) {
//
//		String output = "";
//		try {
//
//			Connection con = connect();
//
//			if (con == null) {
//				return "Error while connecting to the database";
//			}
//
//			// create a prepared statement
//			String query = " INSERT INTO appointment_scheduling (Date, Start_Time, End_Time, D_Id, H_Id, App_id, App_type) VALUES (?, ?, ?, ?, ?,?,?)";
//			PreparedStatement preparedStmt = con.prepareStatement(query);
//
//			// binding values
//			preparedStmt.setString(1, date);
//			preparedStmt.setDouble(2, start_time);
//			preparedStmt.setDouble(3, end_time);
//			preparedStmt.setInt(4, d_id);
//			preparedStmt.setInt(5, h_id);
//			preparedStmt.setInt(6, app_id);
//			preparedStmt.setString(7, app_type);
//
//			// execute the statement
//			preparedStmt.execute();
//			con.close();
//			output = "Inserted successfully";
//
//		} catch (Exception e) {
//			output = "Error while inserting";
//			System.err.println(e.getMessage());
//		}
//
//		return output;
//	}
//	
//	//========================== Add In To Appointment Types =========================
//	
////	public String addAppointmentType(String appointment_type, String appointment_name, String appointment_desc) {
////
////		String output = "";
////		try {
////
////			Connection con = connect();
////
////			if (con == null) {
////				return "Error while connecting to the database";
////			}
////
////			// create a prepared statement
////			String query = " INSERT INTO appointment_type (Appointment_Type, Appointment_Name, Appointment_Desc) VALUES (?, ?, ?)";
////			PreparedStatement preparedStmt = con.prepareStatement(query);
////
////			// binding values
////			preparedStmt.setString(1, appointment_type);
////			preparedStmt.setString(2, appointment_name);
////			preparedStmt.setString(3, appointment_desc);
////
////			// execute the statement
////			preparedStmt.execute();
////			con.close();
////			output = "Inserted successfully";
////
////		} catch (Exception e) {
////			output = "Error while inserting";
////			System.err.println(e.getMessage());
////		}
////
////		return output;
////	}
////	
////	//============================= Update Appointment Type ==============================
////	
////	public String updateAppointmentType(int appointment_id, String appointment_type, String appointment_name, String appointment_desc) {
////
////		String output = "";
////
////		try {
////			Connection con = connect();
////			if (con == null) {
////				return "Error while connecting to the database for updating.";
////			}
////			// create a prepared statement
////			String query = "UPDATE appointment_type SET Appointment_Type=?,Appointment_Name=?,Appointment_Desc=? WHERE appointment_Id =?";
////			PreparedStatement preparedStmt = con.prepareStatement(query);
////
////			// binding values
////
////			preparedStmt.setString(1, appointment_type);
////			preparedStmt.setString(2, appointment_name);
////			preparedStmt.setString(3, appointment_desc);
////			preparedStmt.setInt(4, appointment_id);
////			// execute the statement
////			preparedStmt.execute();
////			con.close();
////			output = "Updated successfully [ ID : "+appointment_id+" ]";
////		} catch (Exception e) {
////			output = "Error while updating the Doctor " + appointment_id;
////			System.err.println(e.getMessage());
////		}
////		return output;
////	}
//
//	//============================= Update Appointment Scheduling ==============================
//	
//	public String updateAppointmentType(int schedule_id , String date, double startTime, double endTime, String d_name, String h_name, int app_id, String app_type) {
//
//		String output = "";
//
//		try {
//			Connection con = connect();
//			if (con == null) {
//				return "Error while connecting to the database for updating.";
//			}
//			// create a prepared statement
//			String query = "UPDATE appointment_scheduling SET Date =?,Start_Time =?,End_Time =?,D_Name =?,H_Name =?,App_id =?,App_type=? WHERE Schedule_id =?";
//			PreparedStatement preparedStmt = con.prepareStatement(query);
//
//			// binding values
//
//			preparedStmt.setString(1, date);
//			preparedStmt.setDouble(2, startTime);
//			preparedStmt.setDouble(3, endTime);
//			preparedStmt.setString(4, d_name);
//			preparedStmt.setString(5, h_name);
//			preparedStmt.setInt(6, app_id);
//			preparedStmt.setString(7, app_type);
//			preparedStmt.setInt(8, schedule_id);
//			// execute the statement
//			preparedStmt.execute();
//			con.close();
//			output = "Updated successfully [ ID : "+schedule_id+" ]";
//		} catch (Exception e) {
//			output = "Error while updating the Doctor " + schedule_id;
//			System.err.println(e.getMessage());
//		}
//		return output;
//	}
//	
//
////	//============================= Delete Appointment Type ==============================	
////	
////	public String deleteAppointmentTypes(String app_id) {
////		String output = "";
////		try {
////
////			Connection con = connect();
////			if (con == null) {
////				return "Error while connecting to the database for deleting.";
////			}
////
////			// create a prepared statement
////			String query = "DELETE FROM appointment_type WHERE appointment_Id=?";
////			PreparedStatement preparedStmt = con.prepareStatement(query);
////
////			// binding values
////			preparedStmt.setString(1, app_id);
////
////			// execute the statement
////			preparedStmt.execute();
////			con.close();
////			output = "Deleted successfully [ Appointment Id : "+app_id +" ]";
////
////		} catch (Exception e) {
////
////			output = "Error while deleting the Doctor" + app_id;
////			System.err.println(e.getMessage());
////		}
////
////		return output;
////	}
//	
//	//============================= Delete Appointment Schedule ==============================	
//	
//	public String deleteAppointmentSchedule(String s_id) {
//		String output = "";
//		try {
//
//			Connection con = connect();
//			if (con == null) {
//				return "Error while connecting to the database for deleting.";
//			}
//
//			// create a prepared statement
//			String query = "DELETE FROM appointment_scheduling WHERE Schedule_id=?";
//			PreparedStatement preparedStmt = con.prepareStatement(query);
//
//			// binding values
//			preparedStmt.setString(1, s_id);
//
//			// execute the statement
//			preparedStmt.execute();
//			con.close();
//			output = "Deleted successfully [ Appointment Id : "+s_id +" ]";
//
//		} catch (Exception e) {
//
//			output = "Error while deleting the Doctor" + s_id;
//			System.err.println(e.getMessage());
//		}
//
//		return output;
//	}
}
