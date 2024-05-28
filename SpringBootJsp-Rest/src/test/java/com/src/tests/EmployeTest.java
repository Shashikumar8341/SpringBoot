package com.src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.src.entity.Employe;
import com.src.service.EmployeService;

@SpringBootTest
public class EmployeTest {

	@Autowired
	private EmployeService employeService;

	@Test
	public void insertvalue() {
		Employe employe = new Employe();
		employe.setEmploye_id(79);
		employe.setAddress("knr");
		employe.setFname("bargav");
		employe.setLname("p");
		employe.setPostralcode(35656L);

		employeService.save(employe);
		assertEquals("bargav", employe.getFname());
	}

	@Test
	public void update() {
		Employe employe = employeService.findbyid(152);
		employe.setAddress("knr");
		employe.setFname("bargav");
		employe.setLname("p");
		employe.setPostralcode(000000L);

		employeService.update(employe);
		employe = employeService.findbyid(152);
		assertEquals("bargav", employe.getFname());
		System.out.println(getClass());
	}

}
