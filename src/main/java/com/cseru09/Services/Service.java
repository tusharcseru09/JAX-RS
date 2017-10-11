package com.cseru09.Services;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
@Singleton
public class Service {
	
	private int Count;
	
	//http://localhost:8989/JAX-RS/rest/test
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTestmessage(){
		Count = Count + 1;
		return "Testing message! Requested "+Count+ " time(s).";
	}
}
