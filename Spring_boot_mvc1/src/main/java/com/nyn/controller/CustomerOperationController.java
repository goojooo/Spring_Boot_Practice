package com.nyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOperationController {

	// Handler Method
	@RequestMapping("/home")
	public String showControllerMethod() {

		System.out.println("CustomerOperationController.showControllerMethod()");
		
		// return Logical View Name
		return "welcome";
	}

}