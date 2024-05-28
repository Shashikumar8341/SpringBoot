package com.src.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.entity.Employe;
import com.src.service.EmployeService;

@RestController
@RequestMapping("/employes")
//@CrossOrigin(origins = "*")
public class EmployeController {
	@Autowired
	private EmployeService employeService;

	@GetMapping
	public ResponseEntity<?> findall() {
		return new ResponseEntity<List<Employe>>(employeService.findall(), HttpStatus.OK);

	}

	@GetMapping("{employe_id}")
	public ResponseEntity<?> findbyid(@PathVariable("employe_id") Integer employe_id) {
		return new ResponseEntity<Employe>(employeService.findbyid(employe_id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Employe employe) {
		employeService.save(employe);
		return new ResponseEntity<String>("inserted success", HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Employe employe) {
		employeService.update(employe);
		return new ResponseEntity<String>("update success", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{employe_id}")
	public ResponseEntity<?> deletebyid(@PathVariable("employe_id") Integer employe_id) {
		employeService.deletebyid(employe_id);
		return new ResponseEntity<String>("update success", HttpStatus.OK);
	}
}
