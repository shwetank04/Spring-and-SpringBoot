package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/luv2code/springdemo/applicationContext.xml");
		
		//retrieve bean from spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		
		//call methodon the bean
		System.out.println(coach.getDailyWokout());
		
		//calling new method for coach
		System.out.println(coach.getDailyFortunes());
		
		//close the context
		context.close();
	}

}
