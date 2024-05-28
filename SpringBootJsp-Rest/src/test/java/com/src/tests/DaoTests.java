package com.src.tests;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.src.entity.Employe;
import com.src.repository.EmployeeRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void testCreateReadDelete() {
		Employe empl = new Employe();

		empl.setEmploye_id(29);
		empl.setFname("V");
		empl.setPostralcode(2000L);
		empl.setLname("smrt");
		empl.setAddress("bl");

		empl = employeeRepository.save(empl);
//		assertThat(empl, employeeRepository.findAll());
		Optional<Employe> found = employeeRepository.findById(empl.getEmploye_id());
		assertThat(found).isPresent();
		assertThat(found.get().getFname()).isEqualTo("V");
		
		 
		List<Employe> empls = employeeRepository.findAll();
		System.out.println(empls);
	    assertThat(empls.size());
//		employeeRepository.deleteAll();
//		Assertions.assertEquals(employeeRepository.findAll().isEmpty(), empls);
//		Assertions.assertEquals(employeeRepository.findAll().isEmpty(), empls);
	}
	 @Test
	    public void testFindByIdNotFound() {
	        Optional<Employe> found = employeeRepository.findById(29);
	        assertThat(found).isNotPresent();
	    }
}