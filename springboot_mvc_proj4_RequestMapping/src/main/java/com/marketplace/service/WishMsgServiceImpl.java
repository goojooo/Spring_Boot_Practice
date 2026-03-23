package com.marketplace.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class WishMsgServiceImpl implements IWishMsgService {

	@Override
	public String showWishMsg() {
		// get current hour of the day

		LocalTime time = LocalTime.now();
		int hour = time.getHour();
		if (hour < 12)
			return "Good Morning...!";
		else if (hour < 16)
			return "Good Afternoon...!";
		else if (hour < 20)
			return "Good Evening...!";
		else
			return "Good Night...!";
	}

}
