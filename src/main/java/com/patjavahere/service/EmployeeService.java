package com.patjavahere.service;

import org.springframework.stereotype.Service;

import com.patjavahere.model.Employee;

@Service
public class EmployeeService {
	public Employee createEmployee(final String empId, final String firstName) {
		final var emp = new Employee();
		emp.setEmpId(empId);
		emp.setFirstName(firstName);
		System.out.println("Employee created...");
		return emp;
	}

	public void deleteEmployee(final String empId) throws Exception {
		if (empId.length() == 0) {
			throw new Exception();
		}
	}
}
