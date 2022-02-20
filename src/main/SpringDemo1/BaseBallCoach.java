package com.luv2code.springdemo;

public class BaseBallCoach implements Coach {

	//define a private field for dependency
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseBallCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWokout() {
		return "Spend 30 mins on batting practice";
	}

	@Override
	public String getDailyFortunes() {	
		//use my fortune service
		return fortuneService.getFortune();
	}
	
}
