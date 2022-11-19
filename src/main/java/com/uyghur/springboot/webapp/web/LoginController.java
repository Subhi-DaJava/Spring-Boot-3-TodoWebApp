package com.uyghur.springboot.webapp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	// http:localhost:8080/login?name=name
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		logger.info("Get request");
		return "login";
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String goToWelcomePage(
			@RequestParam String name,
			@RequestParam String password,
			ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		
		logger.info("Post request");
		return "welcome";
	}
}
