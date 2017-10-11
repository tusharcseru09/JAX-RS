package com.cseru09.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class Service {
	
	//http://localhost:8989/JAX-RS/rest/test
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTestmessage(){
		
		return "Testing message!";
	}
}
