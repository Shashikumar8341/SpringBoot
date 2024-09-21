package com.ciq.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ciq.entity.Student;
import com.ciq.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping("/saves")
	public Student save(@RequestBody Student student) {
		return service.save(student);

	}

	@GetMapping("/{id}")
	public Student getUserById(@PathVariable Integer Id) {
		return service.getStudentById(Id);

	}

	@GetMapping("/findAll")
	public List<Student> getAllStudent() {
		return 	service.getAllStudent();
	}

	@PutMapping
	public Student Update(@RequestBody Student student) {
		return service.update(student);

	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Integer Id) {
		service.deletebyid(Id);;
	}

}
