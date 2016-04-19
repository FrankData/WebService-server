package objService.spring.cxf.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

public class WSSserverInIntercepter extends AbstractPhaseInterceptor<SoapMessage> {

	   public WSSserverInIntercepter() {
	        super(Phase.PRE_PROTOCOL);
	    }
	    public WSSserverInIntercepter(String s) {
	        super(Phase.PRE_PROTOCOL);
	    }
		public void handleMessage(SoapMessage message) throws Fault {
			// TODO Auto-generated method stub
			
			 Map props = new HashMap();
		        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		        props.put(WSHandlerConstants.PW_CALLBACK_REF, new PasswordHandler());
		 
		        WSS4JInInterceptor wss4jInHandler = new WSS4JInInterceptor(props);
		        ValidateUserTokenInterceptor userTokenInterceptor = new ValidateUserTokenInterceptor(Phase.POST_PROTOCOL);
		 
		        message.getInterceptorChain().add(wss4jInHandler);
		        message.getInterceptorChain().add(new SAAJInInterceptor());
		        message.getInterceptorChain().add(userTokenInterceptor);
			
		}

}
