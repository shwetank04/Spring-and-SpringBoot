package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from container
		Coach coach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		context.close();
		
	}
}
