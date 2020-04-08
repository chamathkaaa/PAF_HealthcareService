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
	
	public String readItems() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Appointment ID</th>" + "<th>Patient ID</th><th>Appointment Specification</th>"
					+ "<th>Doctor's Name</th>" + "<th>Hospital Name</th><th>Date</th>  \"<th>Time</th><th>Status</th></tr>";
			String query = "select * from appointment_doctor";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String AppointmentID = Integer.toString(rs.getInt("appointmentId"));
				String PatientID = Integer.toString(rs.getInt("patientId"));
				String AppointmentSpecification = rs.getString("appointmentSpec");
				String DoctorName = rs.getString(rs.getString("doctorName"));
				String HospitalName = rs.getString(rs.getString("hospitalName"));
				Date DueDate =rs.getDate("dueDate");
				Time DueTime =rs.getTime("dueTime");
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
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}


}
