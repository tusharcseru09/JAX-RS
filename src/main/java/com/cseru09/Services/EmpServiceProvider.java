package com.cseru09.Services;


import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.cseru09.Repository.Employee;
import com.cseru09.Repository.EmployeeImp;

@Path("/employee")
public class EmpServiceProvider {
	
	private int Count;
	
	//http://localhost:8989/JAXRS/rest/employee
	@GET
	@Produces
	public String getMessage(){
		Count = Count + 1;
		return "Plain text. Requested by " + Count + " time(s).";
	}
	
	//http://localhost:8989/JAXRS/rest/employee/employeelist
	@GET
	@Path("/employeelist")
	@Produces({MediaType.APPLICATION_XML})
	public List<Employee> employeeList() {
		
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			empList = new EmployeeImp().getAllEmployee();
		} catch (Exception e) {
			System.out.println("Exception occure in service method.");
			e.printStackTrace();
		}
		
		return empList;
	}
	
}

