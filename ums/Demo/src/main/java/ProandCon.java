import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ProandCon {

	public static void main(String[] args) throws Exception {
		
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("direct:start")
				.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						System.out.println("In processor");
						
						String mes = exchange.getIn().getBody(String.class);
						mes = mes + " dude";
						exchange.getOut().setBody(mes);
						
					}
				})
				.to("seda:end");
				
			}
		});
		
		context.start();
		
		ProducerTemplate pro = context.createProducerTemplate();
		pro.sendBody("direct:start", "Hello everyone");
		
		ConsumerTemplate con = context.createConsumerTemplate();
		String mes = con.receiveBody("seda:end", String.class);
		
		System.out.println(mes);
	}
}
