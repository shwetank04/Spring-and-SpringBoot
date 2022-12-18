package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect2 {
	
	
	@Pointcut("execution(public void add*(com.luv2code.aopdemo.Account))")
	private void forDaopackage() {}
	
	@Before("forDaopackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("Aspect before the method second");
	}

}
