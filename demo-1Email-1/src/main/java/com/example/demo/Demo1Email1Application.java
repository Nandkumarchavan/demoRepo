package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Email1Application {
	
	@Autowired
	private EmailService senderService;

	public static void main(String[] args) {
		SpringApplication.run(Demo1Email1Application.class, args);
	}
	
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
			
		senderService.sendEmailWithAttachment("madhavlonkar2@gmail.com", "this subject ", "hiii I am nandu....","C:\\Users\\Nandu\\Downloads\\cookies (2).json");
	}

}
