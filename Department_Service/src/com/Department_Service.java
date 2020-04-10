package com;

import model.Department;

//For REST Service 
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON 
import com.google.gson.*; 

//For XML 
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Department") 
public class Department_Service {  
	Department departmentObj = new Department();
	
	@GET  
	@Path("/")  
	@Produces(MediaType.TEXT_HTML)  
	public String readDepartments()  {   
		return departmentObj.readDepartments();
	}
	
	@POST 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertDepartments(@FormParam("Hospital_ID") String Hospital_ID,
							@FormParam("Department_Name") String Department_Name,
							@FormParam("Head") String Head,    
							@FormParam("Staff_Vacancies") String Staff_Vacancies)
	{  
		String output = departmentObj.insertDepartments(Hospital_ID, Department_Name, Head, Staff_Vacancies);  
		return output; 
	}
	
	@PUT 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateDepartments(String DepartmentsData) { 
		//Convert the input string to a JSON object  
		JsonObject dep_Object = new JsonParser().parse(DepartmentsData).getAsJsonObject(); 
	}
}
