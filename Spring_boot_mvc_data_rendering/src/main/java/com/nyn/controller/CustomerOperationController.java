package com.nyn.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOperationController {

	// Handler Method
	@RequestMapping("/forward")
	public String showControllerMethod(BindingAwareModelMap map) {

		System.out.println("CustomerOperationController.showControllerMethod()");
		
		map.addAttribute("sysDate", new Date());
		map.addAttribute("age", new Random().nextInt(40));
		// return Logical View Name
		return "welcome";
	}
	
	@RequestMapping("/report")
	public String showReport() {
		
		System.out.println("CustomerOperationController.showReport()");
	

		// return Logical View Name
		return "report";
	}
	
	

}