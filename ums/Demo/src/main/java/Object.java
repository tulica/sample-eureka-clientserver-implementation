import java.util.Date;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class Object {

	public static void main(String[] args) throws Exception {
		
		CamelContext context = new  DefaultCamelContext();
		
		ConnectionFactory connection = new ActiveMQConnectionFactory();
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connection));
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("direct:start")
				.to("activemq:queue:my_queue");
			}
		});
		
		context.start();
		
		ProducerTemplate pro = context.createProducerTemplate();
		pro.sendBody("direct:start", new Date());
	}
}
