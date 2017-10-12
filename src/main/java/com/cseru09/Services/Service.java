package com.cseru09.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{varPathParam}/test")
public class Service {
	
	@PathParam("varPathParam") private String pathParamValue;
	@QueryParam("varQuery01") private String qurey01;
	@QueryParam("varQuery02") private String qurey02;
	

	
	//http://localhost:8989/JAX-RS/rest/jklsiddiab/test?varQuery01=Abu&varQuery02=Siddique
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTestmessage(){
		String req = 	"Path Param: "	 +
						pathParamValue	+ "\n"	+
						"Query 01: " 	+
						qurey01	+	"\n"	+
						"Query 02: " 	+
						qurey02;
		return "Testing message!\n"+req;
	}
}