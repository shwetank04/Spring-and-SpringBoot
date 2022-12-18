package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	@Pointcut("execution(public void add*(com.luv2code.aopdemo.Account))")
	private void forDaopackage() {}
	
	
	@Before("forDaopackage()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		//display method signature
		MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
		System.out.println("method signature"+methodSig);
		//display method arguments
		Object[] args = theJoinPoint.getArgs();
		for(Object temp: args) {
			if(temp instanceof Account) {
			Account theaccount = (Account)temp;
			System.out.println(theaccount.getName());
			}
		}
		System.out.println("Aspect before the method");
	}

}
