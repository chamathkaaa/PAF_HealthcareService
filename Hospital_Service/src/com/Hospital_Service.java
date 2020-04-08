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
	
	@PUT 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateHospitals(String HospitalsData) { 
		//Convert the input string to a JSON object  
		JsonObject hospitalObject = new JsonParser().parse(HospitalsData).getAsJsonObject(); 
		 
		 //Read the values from the JSON object  
		String Hospital_ID = hospitalObject.get("Hospital_ID").getAsString();  
		String Hospital_Name = hospitalObject.get("Hospital_Name").getAsString();  
		String Hospital_Address = hospitalObject.get("Hospital_Address").getAsString();  
		String Hospital_City = hospitalObject.get("Hospital_City").getAsString();  
		String Hospital_Phone = hospitalObject.get("Hospital_Phone").getAsString();
		String Hospital_Email = hospitalObject.get("Hospital_Email").getAsString();  
		String Hospital_Description = hospitalObject.get("Hospital_Description").getAsString();  
		String Open_Hours = hospitalObject.get("Open_Hours").getAsString(); 
		 
		String output = hospitalObj.updateHospitals(Hospital_ID, Hospital_Name, Hospital_Address, Hospital_City, Hospital_Phone, Hospital_Email, Hospital_Description, Open_Hours); 
		 
		return output; 
	}
	
	@DELETE 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteHospitals(String HospitalsData) {  
		//Convert the input string to an XML document  
		Document doc = Jsoup.parse(HospitalsData, "", Parser.xmlParser());     
		
		//Read the value from the element <itemID>  
		String Hospital_ID = doc.select("Hospital_ID").text(); 
		 
		 String output = hospitalObj.deleteHospitals(Hospital_ID); 
		 
		 return output; 
		 }
}