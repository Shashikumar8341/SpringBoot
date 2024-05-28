package com.src.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.src.entity.GeekEmploye;

public interface EmployeRepositroy extends JpaRepository<GeekEmploye, Integer> {

}
