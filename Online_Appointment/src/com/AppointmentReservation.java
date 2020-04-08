package com;
import model.Appointment;

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
		return  appObj.readItems();
	}
}
