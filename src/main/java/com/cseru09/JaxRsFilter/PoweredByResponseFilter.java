package com.cseru09.JaxRsFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		
		 //* Note: Don't use space in Header Key
		 
		responseContext.getHeaders().add("Powered-By1", "BDSchools Org1");
		responseContext.getHeaders().add("Powered-By2", "BDSchools Org2");
		responseContext.getHeaders().add("Powered-By3", "BDSchools Org3");
		responseContext.getHeaders().add("Powered-By4", "BDSchools Org4");
		
		System.out.println(responseContext.getHeaders());
		System.out.println("-------------------------------------------");
		
		MultivaluedMap<String, Object> headers = responseContext.getHeaders();
		
		Set<String> keySet = headers.keySet();
		
		for  (String string : keySet) {
			System.out.println("Headers["+string + "]:"+headers.getFirst(string));
		}


	}

}
