package com.nyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOperationController {

	// Handler Method
	@RequestMapping
	public String showControllerMethod() {

		System.out.println("CustomerOperationController.showControllerMethod()");
		
		// return Logical View Name
		return "welcome";
	}
	@RequestMapping("/report")
	public String showReport() {

		System.out.println("CustomerOperationController.showControllerMethod()");
		
		// return Logical View Name
		return "report";
	}
	
	
	@GetMapping("/report")
	public String showReport1() {
		System.out.println("CustomerOperationController.showReport1()");
		return "report";
	}
	@PostMapping("/report")
	public String showReport2() {
		System.out.println("CustomerOperationController.showReport2()");
		return "report2";
	}
	
	

}