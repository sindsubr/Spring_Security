package org.sindu.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {

	@GetMapping("/")
	public String companyIndex() {
		return "main";
	}
	
	@GetMapping("/showLoginForm")
	public String login() {
		return "fancy-bootstrap-login";
	}
}
