package objService.spring.cxf.server;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import objService.pure.cxf.server.ServerPasswordHandler;

import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;


public class Server {

	public static void main(String[] args) {
		HelloWorld hello = new HelloWorldimpl();
		ServerFactoryBean factory = new ServerFactoryBean();
		factory.setAddress("http://localhost:8089/helloworld");
		factory.setServiceBean(hello);
		factory.setServiceClass(HelloWorld.class);
		factory.create();
//		Map<String,Object> inProps = new HashMap<String,Object>();
//		inProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
//		// Password type : plain text
//		inProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
//		// for hashed password use:
//		//properties.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
//		// Callback used to retrieve password for given user.
//		inProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, 
//		    ServerPasswordHandler.class.getName());
//		 
//		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
//		factory.getInInterceptors().add(wssIn);
//		 
//		Map<String,Object> outProps = new HashMap<String,Object>();
//		 
//		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
//		factory.getOutInterceptors().add(wssOut);
	}

}
