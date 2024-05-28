package com.src.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.src.controller.EmployeController;
import com.src.repository.EmployeeRepository;
import com.src.service.EmployeService;

@SpringBootTest
public class EmployeApplication {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeService employeService;
	@Autowired 
	private EmployeController controller;
	
	@Test
	public void applicationTest() {
		Assertions.assertNotNull(controller, "controller");
		Assertions.assertNotNull(employeeRepository, "repository");
		Assertions.assertNotNull(employeService, "service");
	}
}
