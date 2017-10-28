package com.cseru09.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/secure")
public class SecureServiceExample {

	
	@GET
	@Path("/getmsg")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSecureMsg(){
		return "Secure Service by basic Auth";
	}
	
}
