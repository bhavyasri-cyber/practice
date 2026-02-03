package com.example.demo;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestBean {

	
	private String requestId;
	
	public RequestBean() {
		this.requestId= UUID.randomUUID().toString();
		System.out.println(" RequestBean Created :  "+this.hashCode());
	}
	
	public String getRequestId() {
		return requestId;
	}
}
