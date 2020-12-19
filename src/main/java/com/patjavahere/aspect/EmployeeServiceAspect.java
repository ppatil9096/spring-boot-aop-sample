package com.patjavahere.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.patjavahere.model.Employee;

@Aspect
@Component
public class EmployeeServiceAspect {
	@Before(value = "execution(* com.patjavahere.service.EmployeeService.*(..)) and args(employeeId)")
	public void beforeAdvice(final JoinPoint joinPoint, final String employeeId) {
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println("Deleting Employee with id - " + employeeId);
	}

	@After(value = "execution(* com.patjavahere.service.EmployeeService.*(..)) and args(empId, firstName)")
	public void afterAdvice(final JoinPoint joinPoint, final String empId, final String firstName) {
		System.out.println("After method:" + joinPoint.getSignature());
		System.out.println("Creating employee with id - " + empId);
	}

	@Pointcut(value = "execution(* com.patjavahere.service.EmployeeService.*(..))")
	public void getEmployeeDept() {
		System.out.println("in getEmployeeDept pointCut");
	}

	@Around(value = "getEmployeeDept()")
	public void aroundAdvice(final ProceedingJoinPoint jp) throws Throwable {
		System.out.println(
				"The method aroundAdvice() before invokation of the method " + jp.getSignature().getName() + " method");
		try {
			jp.proceed();
		} finally {

		}
		System.out.println(
				"The method aroundAdvice() after invokation of the method " + jp.getSignature().getName() + " method");
	}

	@AfterReturning(value = "execution(* com.patjavahere.service.EmployeeService.*(..))", returning = "employee")
	public void afterReturningAdvice(final JoinPoint joinPoint, final Employee employee) {
		System.out.println("After Returing method:" + joinPoint.getSignature());
		System.out.println(employee);
	}

	@AfterThrowing(value = "execution(* com.patjavahere.service.EmployeeService.*(..))", throwing = "ex")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
		System.out.println("After Throwing exception in method:" + joinPoint.getSignature());
		System.out.println("Exception is:" + ex.getMessage());
	}
}
