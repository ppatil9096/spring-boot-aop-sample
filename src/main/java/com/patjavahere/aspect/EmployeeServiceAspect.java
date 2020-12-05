package com.patjavahere.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {
	@Before(value = "execution(* com.patjavahere.service.EmployeeService.*(..)) and args(employeeId)")
	public void beforeAdvice(final JoinPoint joinPoint, final String employeeId) {
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println("Deleting Employee with id - " + employeeId);
	}
}
