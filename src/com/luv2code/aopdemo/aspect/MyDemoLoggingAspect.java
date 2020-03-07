package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void forSetterMethods() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void forGetterMethods() {}
	
	@Pointcut("forDaoPackage() && !(forSetterMethods() || forGetterMethods())")
	private void forDaoPackageNoGetterNoSetter() {}
	
	
	@Before("forDaoPackageNoGetterNoSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ===========> @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterNoSetter()")
	public void performApiAnalytics() {
		System.out.println("\n ===========> Performing API Analytics");
	}

}
