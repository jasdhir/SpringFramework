package com.jasdhir.springdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}




