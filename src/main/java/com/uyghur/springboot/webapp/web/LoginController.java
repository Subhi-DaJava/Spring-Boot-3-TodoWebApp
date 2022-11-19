package com.uyghur.springboot.webapp.web;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	// http:localhost:8080/login?name=name
	// Model
	@RequestMapping("/login")
	public String login(
			@RequestParam(defaultValue="firstname: default name") String name,
			ModelMap model) {
		model.put("name", name);
		
		logger.debug("This login form LoginController does not work well, the request param is {}", name); // level debug
		logger.info("This login form LoginController works well, the request param is {}", name); // level min info
		//System.out.println("Request param is " + name);
		
		return "login";
	}
}
