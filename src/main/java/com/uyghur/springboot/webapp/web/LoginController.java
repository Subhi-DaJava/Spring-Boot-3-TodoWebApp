package com.uyghur.springboot.webapp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uyghur.springboot.webapp.service.AuthenticationService;

@Controller
public class LoginController {
	@Autowired
	private AuthenticationService authenticationService; 
	
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
		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
			model.put("password", password);
			
			logger.info("Post request");
			return "welcome";
		}
		
		else {
			model.put("errorMessage", "Invalid Credentials!");
			return "login";
		}
	}
}
