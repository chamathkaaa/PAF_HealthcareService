package model;

import java.sql.*;

public class Appointment {
	//A common method to connect to the DB  
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/healthcaredb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	//method to insert data
	public String insertDetails(int PatientID, String AppointmentSpecification, String DoctorName, String HospitalName, Date DueDate, Time DueTime, String Status) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database";
			}
			// create a prepared statement
			String query = " insert into appointment_doctor(`appointmentId`,`patientId`,`appointmentSpec`,`doctorName`,`hospitalName`,`dueDate`,`dueTime`,`status`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setInt(2, PatientID);
			preparedStmt.setString(3, AppointmentSpecification);
			preparedStmt.setString(4, DoctorName);
			preparedStmt.setString(5, HospitalName);
			preparedStmt.setDate(6, DueDate);
			preparedStmt.setTime(7, DueTime);
			preparedStmt.setString(8, Status);
			
			// execute the statement
			preparedStmt.execute();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	//method to read database
	public String readDetails() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Appointment ID</th>" + "<th>Patient ID</th>" + "<th>Appointment Specification</th>"
					+ "<th>Doctor's Name</th>" + "<th>Hospital Name</th>" + "<th>Date</th>" + "<th>Time</th>" + "<th>Status</th></tr>";
			String query = "select * from appointment_doctor";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String AppointmentID = Integer.toString(rs.getInt("appointmentId"));
				String PatientID = Integer.toString(rs.getInt("patientId"));
				String AppointmentSpecification = rs.getString("appointmentSpec");
				String DoctorName = rs.getString("doctorName");
				String HospitalName = rs.getString("hospitalName");
				String DueDate =rs.getString("dueDate");
				String DueTime =rs.getString("dueTime");
				String Status = rs.getString("status");
				
				// Add into the html table
				output += "<tr><td>" + AppointmentID + "</td>";
				output += "<td>" + PatientID + "</td>";
				output += "<td>" + AppointmentSpecification + "</td>";
				output += "<td>" + DoctorName + "</td>";
				output += "<td>" + HospitalName + "</td>";
				output += "<td>" + DueDate + "</td>";
				output += "<td>" + DueTime + "</td>";
				output += "<td>" + Status + "</td>";
				// buttons
				output += "<td><input name=\"btnUpdate\" " + " type=\"button\" value=\"Update\"></td>"
						+ "<td><form method=\"post\" action=\"items.jsp\">" + "<input name=\"btnRemove\" "
						+ " type=\"submit\" value=\"Remove\">" + "<input name=\"itemID\" type=\"hidden\" " + " value=\""
						+ AppointmentID + "\">" + "</form></td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//method to update details
	public String updateDetails(String AppointmentID, String PatientID, String AppointmentSpecification, String DoctorName, String HospitalName, String DueDate, String DueTime, String Status)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 String query = "UPDATE appointment_doctor SET patientId=?,appointmentSpec=?,doctorName=?,hospitalName=?,dueDate=?,dueTime=?,status=?WHERE appointmentId=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(PatientID));
	 preparedStmt.setString(2, AppointmentSpecification);
	 preparedStmt.setString(3, DoctorName);
	 preparedStmt.setString(4, HospitalName);
	 preparedStmt.setDate(5, Date.valueOf(DueDate));
	 preparedStmt.setTime(6, Time.valueOf(DueTime));
	 preparedStmt.setString(7, Status);
	 preparedStmt.setInt(8, Integer.parseInt(AppointmentID));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Updated successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while updating the details.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }

	//method to delete details
	public String deleteDetails(String AppointmentID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from appointment_doctor where AppointmentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(AppointmentID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the details.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	private void sysout() {
		// TODO Auto-generated method stub

	}
}
