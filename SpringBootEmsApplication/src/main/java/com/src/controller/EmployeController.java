package com.src.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.entity.GeekEmploye;
import com.src.service.EmployeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/GeekEmploye")
//@CrossOrigin(origins = "*")
public class EmployeController {
	@Autowired
	private EmployeService employeService;

	@GetMapping
	public ResponseEntity<?> findall() {
		return new ResponseEntity<List<GeekEmploye>>(employeService.findall(), HttpStatus.OK);

	}

	@GetMapping("{emp_id}")
	public ResponseEntity<?> findbyid(@PathVariable("emp_id") Integer emp_id) {
		return new ResponseEntity<GeekEmploye>(employeService.findbyid(emp_id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody GeekEmploye geekEmploye) {
	GeekEmploye geekEmployeop=	employeService.add(geekEmploye);
		return new ResponseEntity<GeekEmploye>(geekEmployeop, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody GeekEmploye geekEmploye) {
	GeekEmploye geekEmploye2=employeService.update(geekEmploye);
		return new ResponseEntity<GeekEmploye>(geekEmploye2, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{emp_id}")
	public ResponseEntity<?> deletebyid(@PathVariable("emp_id") Integer emp_id) {
		employeService.deletebyid(emp_id);
		return new ResponseEntity<String>("delete success", HttpStatus.OK);
	}
}
