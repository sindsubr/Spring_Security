package org.sindu.springsecurity.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {

	@GetMapping("/")
	public String getMain() {
		return "main";
	}
	
	@GetMapping("/showLoginForm")
	public String showLoginForm() {
		return "fancy-bootstrap-login";
	}
	
}
