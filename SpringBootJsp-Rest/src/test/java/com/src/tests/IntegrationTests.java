package com.src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.src.controller.EmployeController;
import com.src.entity.Employe;
import com.src.responseobj.ResponseObject;

@SpringBootTest
public class IntegrationTests {

	@Autowired
	EmployeController controller;

	@Test
	public void testCreateReadDelete() {
		Employe employe = new Employe(100, "shashi", "kumar", 7032000L, "nepal");
		ResponseObject object = controller.save(employe);
		assertEquals(200, object.getStatuscode());
		Employe employeobj = (Employe) object.getResult();
		assertEquals("shashi", employeobj.getFname());

		Employe employeread = (Employe) controller.findbyid(employeobj.getEmploye_id()).getResult();
		assertEquals("shashi", employeread.getFname());
		assertEquals("kumar", employeread.getLname());
		assertEquals(7032000L, employeread.getPostralcode());
		assertEquals("nepal", employeread.getAddress());
//		ResponseObject objectdelete = controller.deletebyid(employeobj.getEmploye_id());
//		assertEquals("delete", objectdelete.getResult().toString());
		
	}

}
