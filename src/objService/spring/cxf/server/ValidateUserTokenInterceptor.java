package objService.spring.cxf.server;

import java.util.List;
import java.util.Vector;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.wss4j.dom.engine.WSSecurityEngineResult;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.wss4j.dom.handler.WSHandlerResult;

public class ValidateUserTokenInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	public ValidateUserTokenInterceptor(String phase) {
		super(phase);
		// TODO Auto-generated constructor stub
	}

	public void handleMessage(SoapMessage message) throws Fault {
		 boolean userTokenValidated = false;
	        List result =  (List) message.getContextualProperty(WSHandlerConstants.RECV_RESULTS);
	        for (int i = 0; i < result.size(); i++) {
	            WSHandlerResult res = (WSHandlerResult) result.get(i);
	            for (int j = 0; j< res.getResults().size(); j++) {
	                   WSSecurityEngineResult secRes = (WSSecurityEngineResult) res.getResults().get(j);
//	                    WSUsernameTokenPrincipal principal = (WSUsernameTokenPrincipal) secRes
//	                            .getPrincipal();
	
	                   
//	                    if (!principal.isPasswordDigest() ||
//	                            principal.getNonce() == null ||
//	                            principal.getPassword() == null ||
//	                            principal.getCreatedTime() == null) {
//	                        throw new RuntimeException("Invalid Security Header");
//	                    } else {
//	                        userTokenValidated = true;
//	                    }
	                }
	            }
	        if (!userTokenValidated) {
	            throw new RuntimeException("Security processing failed");
	        }
	    }
}
