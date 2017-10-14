package com.cseru09.Services;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("msgrw")
public class MsgBodyService {

	//http://localhost:8989/JAXRS/rest/msgrw
	@GET
	@Produces(value = {MediaType.TEXT_PLAIN,"date/shortdate"})
	public Date msgReaderWriterTest(){
		return Calendar.getInstance().getTime();
	}
	
}
