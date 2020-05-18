package com.apachecamel;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.Registry;
import org.apache.camel.support.SimpleRegistry;


public class Classcomp {

	public static void main(String[] args) throws Exception {
		
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("direct:start")
				.bean(new MyService(),"doSomething");
				
			}
		});
		
		context.start();
		ProducerTemplate pro = context.createProducerTemplate();
		pro.sendBody("direct:start", "hello");
		
	}
}
