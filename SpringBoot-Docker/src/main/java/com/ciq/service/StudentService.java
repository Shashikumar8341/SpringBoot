package com.ciq.service;

import java.util.List;

import com.ciq.entity.Student;


public interface StudentService {
	public Student save(Student sudent);

	public Student getStudentById(Integer Id);

	public List<Student> getAllStudent();

	public Student update(Student student);

	public void deletebyid(Integer Id);
}