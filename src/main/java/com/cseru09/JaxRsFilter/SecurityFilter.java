package com.cseru09.JaxRsFilter;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHENTICATION_HEADER = "Authorization";
	private static final String AUTHENTICATION_HEADER_Prefix= "Basic ";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		List<String> basicAuthHeader = requestContext.getHeaders().get(AUTHENTICATION_HEADER);
		
		/*
		 * due to empty header basicAuthHeader may get null value.
		 * in that case we must have to check null value
		 * Ofcourse in if statement as like follow 
		 */
		
		// if(basicAuthHeader.size() > 0 && basicAuthHeader != null   )
		// will get null pointer exception because at first try to check size then checking emply or null
		
		if(basicAuthHeader != null  && basicAuthHeader.size() > 0){
			String authStr = basicAuthHeader.get(0);
			String replaceFirst = authStr.replaceFirst(AUTHENTICATION_HEADER_Prefix, "");
			String decodeAsString = Base64.decodeAsString(replaceFirst);
			
			System.out.println(authStr);
			System.out.println(replaceFirst);
			System.out.println(decodeAsString);
			if (decodeAsString.equals("user:password")){
				return;
			}
			
		}
		Response unAuthorizedStatus = Response
				.status(Response.Status.UNAUTHORIZED)
				.entity("Access Denied !")
				.build();
		
		requestContext.abortWith(unAuthorizedStatus);
		
	}//End method
	
	

}//End class
