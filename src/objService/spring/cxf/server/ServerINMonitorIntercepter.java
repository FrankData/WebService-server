package objService.spring.cxf.server;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;

import output.GenerateReport;

public class ServerINMonitorIntercepter extends LoggingInInterceptor {
    @Override
    protected String formatLoggingMessage(LoggingMessage loggingMessage) {
        String soapXmlPayload = loggingMessage.getPayload() != null ? loggingMessage.getPayload().toString() : null;

        // do what you want with the payload... in my case, I stuck it in a JMS Queue
  
//        System.out.println(super.formatLoggingMessage(loggingMessage));
        GenerateReport.report(super.formatLoggingMessage(loggingMessage),"serverINfromClient");
        return super.formatLoggingMessage(loggingMessage);
    }
}
