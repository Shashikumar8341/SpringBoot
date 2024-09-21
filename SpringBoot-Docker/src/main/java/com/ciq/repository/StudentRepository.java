package com.ciq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

}