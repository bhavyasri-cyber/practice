package com.example.demo;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionBean {

	private final String sessonId;

	public SessionBean() {
		this.sessonId = UUID.randomUUID().toString();
		System.out.println("SessionBean Cretd " + sessonId);
	}
	
	public String getSessionId() {
		return sessonId;
	}
}
