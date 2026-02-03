package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private final SessionBean sessionBean;
	
	public TestController(SessionBean sessionBean)
	{
		this.sessionBean=sessionBean;
	}
	@GetMapping("/session-test")
	public String sessiontTest() {
        return "Session ID: " + sessionBean.getSessionId()
        + " | Bean hashCode: " + sessionBean.hashCode();

	}
}
