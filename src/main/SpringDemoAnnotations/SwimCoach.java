package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;

public class SwimCoach implements Coach {

	@Autowired
	private FortuneService theFortuneService;

	public SwimCoach(FortuneService sadFortuneService) {
		// TODO Auto-generated constructor stub
		sadFortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swin 1k meters";
	}

	@Override
	public String getFortune() {
		return theFortuneService.getFortune();
	}

}
