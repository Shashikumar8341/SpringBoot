package com.ciq.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciq.entity.Student;
import com.ciq.repository.StudentRepository;

@Service
public class ServiceIMP implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Integer Id) {
		Optional<Student> optional = studentRepository.findById(Id);
		return optional.get();
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student update(Student student) {
		Student existingStudent = studentRepository.findById(student.getId()).get();
		existingStudent.setName(student.getName());
		existingStudent.setFathername(student.getFathername());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setAge(student.getAge());
		Student updatedStudent = studentRepository.save(existingStudent);
		return updatedStudent;
	}

	@Override
	public void deletebyid(Integer Id) {
		studentRepository.deleteById(Id);
	}

}
