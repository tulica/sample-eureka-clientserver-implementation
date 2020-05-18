import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class actmq {

	public static void main(String[] args) throws Exception{
		
		CamelContext context = new DefaultCamelContext();
		ConnectionFactory connection = new ActiveMQConnectionFactory();
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connection));
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("file:input_box?noop=true")
				.to("activemq:queue:my_queue");
				
			}
		});
		
		while(true)
			context.start();
	}
}
