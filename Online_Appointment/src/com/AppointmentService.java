package com;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Schedule;

@Path("/Appoinments")
public class AppointmentService {

	Schedule aObj = new Schedule();

//	// get all types
//	@GET
//	@Path("/appointment-type")
//	@Produces(MediaType.TEXT_HTML)
//	public String readAllTypes() {
//		return aObj.viewAppointmentTypes();
//	}

	// get all Schedules
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readAllSchedules() {
		return aObj.viewAllSchedule();
	}

//	//add types
//	@POST
//	@Path("/appointment-type")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String enterType(
//			@FormParam("appointment_Type") String app_type,
//			@FormParam("appointment_Name") String app_name,
//			@FormParam("appointment_Desc") String app_desc) {
//
//		String output = aObj.addAppointmentType(app_type, app_name, app_desc);
//		return output;
//	}

//	//add Schedules
//	@POST
//	@Path("/appointment-schedule")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String enterSchedule(
//			@FormParam("Date") Date date,
//			@FormParam("Start_Time") Time stratTime,
//			@FormParam("End_Time") Time endTime,
//			@FormParam("D_id") int dId,
//			@FormParam("H_id") int hId,
//			@FormParam("App_id") int appId) {
//
//		String output = aObj.makeAppoinment(date, stratTime, endTime, dId, hId, appId);
//		return output;
//	}

//	// add types
//	@POST
//	@Path("/appointment-type")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String enterType(String TypeData) {
//		// Convert the input string to a JSON object
//		JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
//
//		// Read the values from the JSON object
//		String appType = djosnObj.get("appointment_Type").getAsString();
//		String appName = djosnObj.get("appointment_Name").getAsString();
//		String appDesc = djosnObj.get("appointment_Desc").getAsString();
//
//		String output = aObj.addAppointmentType(appType, appName, appDesc);
//		return output;
//
//	}

	// add schedule
//	@POST
//	@Path("/")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String enterSchedule(String scheduleData) {
//		String result = null;
//		// Convert the input string to a JSON object
//		JsonObject djosnObj = new JsonParser().parse(scheduleData).getAsJsonObject();
//
//		String appdate = djosnObj.get("Date").getAsString();
//		Double appstart = djosnObj.get("Start_Time").getAsDouble();
//		Double append = djosnObj.get("End_Time").getAsDouble();
//		int dId = djosnObj.get("D_Id").getAsInt();
//		int hId = djosnObj.get("H_Id").getAsInt();
//		int appId = djosnObj.get("App_id").getAsInt();
//		String apptype = djosnObj.get("App_type").getAsString();
//		String output = aObj.makeAppoinment(appdate, appstart, append, dId, hId, appId, apptype);
//
////		// ==================convert util time to sql time=====================
////		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
////
////		DateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
////
////		try {
////			java.util.Date date = (java.util.Date) format.parse(appdate);
////			java.sql.Date sDate = convertUtilToSql(date);
////
////			java.util.Date stime = (java.util.Date) formatTime.parse(appstart);
////			java.sql.Time startTime = convertUtilToSqlTime(stime);
////
////			java.util.Date etime = (java.util.Date) formatTime.parse(append);
////			java.sql.Time endTime = convertUtilToSqlTime(etime);
////
////			String output = aObj.makeAppoinment(sDate, startTime, endTime, dId, hId, appId);
////			result = output;
////
////		} catch (ParseException e) {
////			e.printStackTrace();
////			result = e.toString();
////		}
//		return result;
//
//	}
//
//	// update Types
////	@PUT
////	@Path("/appointment-type")
////	@Consumes(MediaType.APPLICATION_JSON)
////	@Produces(MediaType.TEXT_PLAIN)
////	public String updateAppType(String TypeData) {
////
////		// Convert the input string to a JSON object
////		JsonObject djosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
////
////		// Read the values from the JSON object
////		int appId = djosnObj.get("appointment_Id").getAsInt();
////		String appType = djosnObj.get("appointment_Type").getAsString();
////		String appName = djosnObj.get("appointment_Name").getAsString();
////		String appDesc = djosnObj.get("appointment_Desc").getAsString();
////
////		String output = aObj.updateAppointmentType(appId, appType, appName, appDesc);
////		return output;
////	}
//
//	// update Schedules
//	@PUT
//	@Path("/")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String updateAppschedule(String TypeData) {
//		String result = null;
//		// Convert the input string to a JSON object
//		JsonObject sjosnObj = new JsonParser().parse(TypeData).getAsJsonObject();
//
//		// Read the values from the JSON object
//		String sId = sjosnObj.get("schedule_id").getAsString();
//		String appdate = sjosnObj.get("Date").getAsString();
//		String appstart = sjosnObj.get("Start_Time").getAsString();
//		String append = sjosnObj.get("End_Time").getAsString();
//		String dId = sjosnObj.get("D_Name").getAsString();
//		String hId = sjosnObj.get("H_Name").getAsString();
//		int appId = sjosnObj.get("App_id").getAsInt();
//		String appType = sjosnObj.get("App_type").getAsString();
//
////		// ==================convert util time to sql time=====================
////		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
////
////		DateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
////
////		try {
////			java.util.Date date = (java.util.Date) format.parse(appdate);
////			java.sql.Date sDate = convertUtilToSql(date);
////
////			java.util.Date stime = (java.util.Date) formatTime.parse(appstart);
////			java.sql.Time startTime = convertUtilToSqlTime(stime);
////
////			java.util.Date etime = (java.util.Date) formatTime.parse(append);
////			java.sql.Time endTime = convertUtilToSqlTime(etime);
////
////			String output = aObj.updateAppointmentType(Integer.parseInt(sId), sDate, startTime, endTime, dId, hId,
////					appId);
////			result = output;
////
////		} catch (ParseException e) {
////			e.printStackTrace();
////			result = e.toString();
////		}
//		return result;
//
//	}
//
////	// =========************* return sql date and time*********==========
////	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
////		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
////		return sDate;
////	}
////
////	private static java.sql.Time convertUtilToSqlTime(java.util.Date uDate) {
////		java.sql.Time sTime = new java.sql.Time(uDate.getTime());
////		return sTime;
////	}
//
////	// delete Types
////	@DELETE
////	@Path("/appointment-type")
////	@Consumes(MediaType.APPLICATION_JSON)
////	@Produces(MediaType.TEXT_PLAIN)
////	public String deleteDoctor(String TypeData) {
////		// Convert the input string to a JSON object
////		JsonObject doc = new JsonParser().parse(TypeData).getAsJsonObject();
////
////		// Read the value from the element <ID>
////		String id = doc.get("appointment_Id").getAsString();
////		String output = aObj.deleteAppointmentTypes(id);
////		return output;
////	}
//
//	// delete Schedules
//	@DELETE
//	@Path("/")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String deleteAppointmentSchedule(String scheduleData) {
//		// Convert the input string to a JSON object
//		JsonObject doc = new JsonParser().parse(scheduleData).getAsJsonObject();
//
//		// Read the value from the element <ID>
//		String id = doc.get("schedule_id").getAsString();
//		String output = aObj.deleteAppointmentSchedule(id);
//		return output;
//	}
}
