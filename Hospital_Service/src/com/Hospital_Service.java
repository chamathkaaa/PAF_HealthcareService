package com;

import model.Hospital;

//For REST Service 
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON 
import com.google.gson.*; 

//For XML 
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Hospital") 
public class Hospital_Service {  
	Hospital hospitalObj = new Hospital();
	
	@GET  
	@Path("/")  
	@Produces(MediaType.TEXT_HTML)  
	public String readHospitals()  {   
		return hospitalObj.readHospitals();
	}
	
	@POST 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertHospitals(@FormParam("Hospital_Name") String Hospital_Name,
							@FormParam("Hospital_Address") String Hospital_Address,    
							@FormParam("Hospital_City") String Hospital_City,       
							@FormParam("Hospital_Phone") String Hospital_Phone,
							@FormParam("Hospital_Email") String Hospital_Email,       
							@FormParam("Hospital_Description") String Hospital_Description,
							@FormParam("Open_Hours") String Open_Hours) 
	{  
		String output = hospitalObj.insertHospitals(Hospital_Name, Hospital_Address, Hospital_City, Hospital_Phone, Hospital_Email, Hospital_Description, Open_Hours);  
		return output; 
	}
}