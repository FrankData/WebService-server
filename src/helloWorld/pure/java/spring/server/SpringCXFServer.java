package helloWorld.pure.java.spring.server;

import java.io.IOException;

import org.apache.cxf.frontend.ServerFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import helloWorld.pure.java.server.HelloWorld;
import helloWorld.pure.java.server.HelloWorldimpl;

public class SpringCXFServer {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("pure/java/spring/server/beans-config.xml");
//		ServerFactoryBean server = (ServerFactoryBean) cxt.getBean("serverBean");
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
