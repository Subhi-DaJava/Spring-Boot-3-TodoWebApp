package com.uyghur.springboot.webapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {
	
	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "What are you learning today?";
	}

}
