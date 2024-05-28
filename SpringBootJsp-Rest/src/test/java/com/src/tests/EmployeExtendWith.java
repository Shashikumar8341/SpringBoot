package com.src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.src.entity.Employe;
import com.src.repository.EmployeeRepository;
import com.src.service.EmployeServiceImp;

@ExtendWith(MockitoExtension.class)
public class EmployeExtendWith {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeServiceImp employeServiceImp;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(employeServiceImp);

	}

	@Test
	public void findall() {
		List<Employe> e = new ArrayList<Employe>();
		Employe employe = new Employe();
		employe.setEmploye_id(89);
		employe.setFname("lopi");
		employe.setLname("ends");
		employe.setPostralcode(89765L);
		Employe employe1 = new Employe();
		employe1.setEmploye_id(89);
		employe1.setFname("lopi");
		employe1.setLname("ends");
		employe1.setPostralcode(89765L);
		e.add(employe1);
		e.add(employe);
		when(employeServiceImp.findall()).thenReturn(e);
		List<Employe> employes = employeServiceImp.findall();
		assertEquals(2, employes.size());
		verify(employeeRepository, times(1)).findAll();

	}

	@Test
	public void update() {
		Employe employe = new Employe();
		employe.setEmploye_id(152);
		employe.setFname("lopi");
		employe.setLname("ends");
		employe.setPostralcode(89765L);
		employeServiceImp.update(employe);
		verify(employeeRepository, times(1)).save(employe);
	}

	@Test
	public void add() {
		Employe employe = new Employe();
		employe.setEmploye_id(12);
		employe.setFname("lopi");
		employe.setLname("ends");
		employe.setPostralcode(89765L);
		employeServiceImp.save(employe);
		verify(employeeRepository, times(1)).save(employe);
	}

	@Test
	public void delete() {
		employeServiceImp.deletebyid(152);
		verify(employeeRepository, times(1)).deleteById(152);
	}
}
