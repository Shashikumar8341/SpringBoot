package com.src.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.src.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
