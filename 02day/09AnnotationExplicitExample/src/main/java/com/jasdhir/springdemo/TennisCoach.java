package com.jasdhir.springdemo;

import org.springframework.stereotype.Component;

@Component("thatAnnotatedCoach")
public class TennisCoach implements Coach {

	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
