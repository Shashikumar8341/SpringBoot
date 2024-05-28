package com.src.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.src.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}