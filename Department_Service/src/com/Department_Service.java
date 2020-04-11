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
		 
		 //Read the values from the JSON object  
		String Department_ID = dep_Object.get("Department_ID").getAsString();  
		String Hospital_ID = dep_Object.get("Hospital_ID").getAsString();  
		String Department_Name = dep_Object.get("Department_Name").getAsString();  
		String Head = dep_Object.get("Head").getAsString();  
		String Staff_Vacancies = dep_Object.get("Staff_Vacancies").getAsString();
		 
		String output = departmentObj.updateDepartments(Department_ID, Hospital_ID, Department_Name, Head, Staff_Vacancies); 
		 
		return output; 
	}
	
	@DELETE 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteDepartments(String DepartmentsData) {  
		//Convert the input string to an XML document  
		Document doc = Jsoup.parse(DepartmentsData, "", Parser.xmlParser());     
		
		//Read the value from the elements  
		String Department_ID = doc.select("Department_ID").text();
		String Hospital_ID = doc.select("Hospital_ID").text();
		 
		String output = departmentObj.deleteDepartments(Department_ID,Hospital_ID); 
		 
		return output; 
		}
}
