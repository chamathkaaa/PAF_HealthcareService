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
		
	}
}
