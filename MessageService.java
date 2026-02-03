package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	public  MessageService() {
		System.out.println("MessageService Constructor Called : Bean Created");
	}
	
	public String getMessage() {
		return  "Hello From MessagService class :Singleton Bean";
	}
}
