package com.src.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.src.entity.Student;

@RestController
public class StudentController {
    
	@GetMapping("/hello")
	public String Sayhello() {
		return "hello Bhargav";
		
	}
	@GetMapping("/studs")
	public List<Student>getStudents(){
		List<Student> stud=new ArrayList<>();
		stud.add(new Student("Bhargav", "Sklm"));
		stud.add(new Student("tommy", "vizag"));
		stud.add(new Student("jerry", "ts"));
		return stud;
		
	}
	@GetMapping("/{fname}/{lname}")
	public  Student Setpathvariable(@PathVariable("fname")String fname,@PathVariable("lname")String lname) {
		return new Student(fname, lname);
		
	}
	
	@GetMapping("/param")
	public  Student Setrequestparam(@RequestParam("fname")String fname,@RequestParam("lname")String lname) {
		return new Student(fname, lname);
		
	}
	
}
