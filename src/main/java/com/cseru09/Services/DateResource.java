package com.cseru09.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cseru09.ParamConverter.MyDate;

@Path("date/{dateString}")
public class DateResource {

	
	//http://localhost:8989/JAXRS/rest/date/yesterday
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDateString(@PathParam("dateString") MyDate dateStr){
		
		return dateStr.toString();
	}
	
}
