package com.src.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.src.entity.Employe;

public interface EmployeeRepository extends JpaRepository<Employe, Integer> {

}
