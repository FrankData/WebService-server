package helloWorld.pure.java.server;

import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;



//@WebService(
//	    serviceName="SportsService",
//	    endpointInterface="ca.utoronto.sis.cxfapp.SportsService")
//	@InInterceptors(interceptors={
//	        "com.arsenalist.cxfapp.WSSecurityInterceptor"
//	})

//@WebService(
//	    serviceName="helloworld",
//	    endpointInterface="pure.java.server.HelloWorld")
public class HelloWorldimpl implements HelloWorld {
	
	/* (non-Javadoc)
	 * @see pure.java.server.HelloWorld#sayHi(java.lang.String)
	 */
	public String sayHi(String name){
		return " hello " + name;
		
	}

}
