package com.src.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.src.entity.Student;

@RestController
public class TestController {

	@GetMapping("/student/{name}/{age}/")
	public Student save(@PathVariable("name") String name, @PathVariable("age") Integer age) {
		return new Student(name, age);
	}
}
