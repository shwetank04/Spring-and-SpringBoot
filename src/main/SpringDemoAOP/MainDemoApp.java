package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
		
		MembershipDao membershipdao = context.getBean("membershipDao",MembershipDao.class);
		//call the business methods
		Account myact = new Account();
		accountDao.addAccount(myact);
		
		membershipdao.addAccount();
		
		//close the context
		context.close();

	}

}
