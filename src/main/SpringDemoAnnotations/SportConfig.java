package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
public class SportConfig {
	
	//define bean for sad fortune services
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//define bean for swim coach and inject dependency for swim coach
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
