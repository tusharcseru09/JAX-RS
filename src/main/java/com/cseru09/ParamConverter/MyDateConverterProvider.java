package com.cseru09.ParamConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider{

	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
		
		//Trigger the ParamConverterProvider to check my custom class MyDate.
		if (rawType.getName().equals(MyDate.class.getName())){
			
			System.out.println(MyDate.class.getName());
			
			//ParamConverter is an interface. So we need to implement it's method 
			//Value holds the path param string value, which we wish to convert to our desired class
			return new ParamConverter<T>(){ 
				
				//Described in pic ParamConverter-01.png
				public T fromString(String value) {
					
					Calendar reqDate = Calendar.getInstance();
					System.out.println(reqDate.toString());
					
                    if("tomorrow".equalsIgnoreCase(value)){
                        reqDate.add(Calendar.DATE, 1);
                    }
                    else if("yesterday".equalsIgnoreCase(value)){
                        reqDate.add(Calendar.DATE, -1);
                    }
                    
                    MyDate mydate = new MyDate();
                    mydate.setDate(reqDate.get(Calendar.DATE));
                    mydate.setMonth(reqDate.get(Calendar.MONTH));
                    mydate.setYear(reqDate.get(Calendar.YEAR));
                    
                    return rawType.cast(mydate);
				}

				public String toString(T myBean) {
					if(myBean == null){
                        return null;
                    }
                    return myBean.toString();
				}
				
			};
		}
		
		
		return null;
		
	}// End getConverter

	

}
