import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class FromActivemq {

	public static void main(String[] args) throws Exception {
		
		CamelContext context = new DefaultCamelContext();
		
		ConnectionFactory connection = new ActiveMQConnectionFactory();
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connection));
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("activemq:queue:my_queue")
				.to("seda:end");
				
			}
		});
		 
		context.start();
		ConsumerTemplate con = context.createConsumerTemplate();
		String message = con.receiveBody("seda:end", String.class);
		System.out.println(message);
	}
}
