package com;
import model.Appointment;

import java.sql.Date;
import java.sql.Time;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

//for json
import com.google.gson.*;
@Path("/Appointment")
public class AppointmentReservation {
	Appointment appObj = new Appointment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return  appObj.readDetails();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDetails(@FormParam("patientId") int PatientID,
	 @FormParam("appointmentSpec") String AppointmentSpecification,
	 @FormParam("doctorName") String DoctorName,
	 @FormParam("hospitalName") String HospitalName,
	 @FormParam("dueDate") String DueDate,
	 @FormParam("dueTime") Double DueTime,
	 @FormParam("status") String Status)
	{
	 String output = appObj.insertDetails(PatientID, AppointmentSpecification, DoctorName, HospitalName, DueDate, DueTime, Status);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDetails(String details)
	{
	//Convert the input string to a JSON object
	 JsonObject detailsObject = new JsonParser().parse(details).getAsJsonObject();
	//Read the values from the JSON object
	 String AppointmentID = detailsObject.get("AppointmentID").getAsString();
	 String PatientID = detailsObject.get("PatientID").getAsString();
	 String AppointmentSpecification = detailsObject.get("AppointmentSpecification").getAsString();
	 String DoctorName = detailsObject.get("DoctorName").getAsString();
	 String HospitalName = detailsObject.get("HospitalName").getAsString();
	 String DueDate = detailsObject.get("DueDate").getAsString();
	 String DueTime = detailsObject.get("DueTime").getAsString();
	 String Status = detailsObject.get("Status").getAsString();
	 String output = appObj.updateDetails(AppointmentID, PatientID, AppointmentSpecification, DoctorName, HospitalName, DueDate, DueTime, Status);
	return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDetails(String details)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(details, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String AppointmentID = doc.select("appointmentId").text();
	 String output = appObj.deleteDetails(AppointmentID);
	return output;
	}
}
