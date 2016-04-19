package objService.spring.cxf.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringCXFServer {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("objService/spring/cxf/server/beans-config.xml");
		
		ServerFactoryBean server = (ServerFactoryBean) cxt.getBean("serverBean");
				
				Map<String,Object> inProps = new HashMap<String,Object>();
		inProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		// Password type : plain text
		inProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		// for hashed password use:
		//properties.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
		// Callback used to retrieve password for given user.
		inProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, 
		    ServerPasswordHandler.class.getName());
//		 
		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
		server.getInInterceptors().add(wssIn);
		 
//		Map<String,Object> outProps = new HashMap<String,Object>();
//		 
//		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
//		server.getOutInterceptors().add(wssOut);
		
		
		
		
		ServerINMonitorIntercepter serverIn = new ServerINMonitorIntercepter();
		server.getInInterceptors().add(serverIn);
		
//		WSSserverInIntercepter wssIN = new WSSserverInIntercepter();
//		server.getInInterceptors().add(wssIN);
		
		server.create();

//		HelloWorld hello = (HelloWorldimpl)cxt.getBean("hello");
//		server.setServiceBean(hello);
//		server.create();
//		try {
//			System.in.read();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
	}

}
