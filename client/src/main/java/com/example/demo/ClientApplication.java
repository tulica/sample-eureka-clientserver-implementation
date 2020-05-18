package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;

import com.example.demo.controller.Umsproxy;

import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
//		Umsproxy callService = Feign.builder()
//		        .encoder((Encoder) new Jackson2JsonEncoder())
//		        .decoder((Decoder) new Jackson2JsonDecoder())
//		        
//		        .target(Umsproxy.class, "http://localhost:8082");
	}
	
}
