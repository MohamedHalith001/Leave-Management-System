package com.mohamed.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mohamed.model.Employee;


public class TestEmployeeValidator {

	@Test
	public void testGetEmployeeList() {
		List<Employee> employeeList = EmployeeManager.getEmployeeList();
		assertEquals(2,employeeList.size());
	}
	
	@Test
	public void testGetEmployeeWithFirstEmployee() {
		String username = "moha2627";
		Employee employee = EmployeeManager.getEmployee(username);
		assertEquals("Mohamed",employee.getName());
		assertEquals("2627moha",employee.getPassword());
		assertEquals(2,employee.getSickLeave());
		assertEquals(2,employee.getCasualLeave());
		assertEquals(1,employee.getEarnedLeave());
	}
	@Test
	public void testGetEmployeeWithSecondEployee() {
		String username = "hali2628";
		Employee employee = EmployeeManager.getEmployee(username);
		assertEquals("Halith",employee.getName());
		assertEquals("2628hali",employee.getPassword());
		assertEquals(2,employee.getSickLeave());
		assertEquals(2,employee.getCasualLeave());
		assertEquals(1,employee.getEarnedLeave());
	}
}
