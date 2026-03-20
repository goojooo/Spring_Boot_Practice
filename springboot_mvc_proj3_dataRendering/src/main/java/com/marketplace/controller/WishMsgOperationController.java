package com.marketplace.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marketplace.service.IWishMsgService;

@Controller
public class WishMsgOperationController {

	@Autowired
	private IWishMsgService service;
	
	@RequestMapping("/")
	public String showHomePage()
	{
		System.out.println("WishMsgOperationController.showHomePage()");
		
		// return lvn
		
		return "welcome";
	}
	
	@RequestMapping("/season")
	public String showWishMessage(Map <String, Object> map)
	{
		// call service class method
		String msg = service.showWishMsg();
		//keep the result in shared memory as model attribute
		map.put("Result", msg);
		//return lvn
		
		map.put("name", "raja");

		map.put("age", 30);

		//add model attributes (collections)

		map.put("friends", List.of("raja", "suresh", "mahesh", "rakesh"));

		map.put("phones", Set.of(999999L, 888888L, 777777L));

		map.put("idDetails", Map.of("aadhar", 6656565, "voterid", 5656565, "panNo", 4665656));
		return "display";
	}
	
	
}
