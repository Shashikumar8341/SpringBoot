package com.ciq.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.entity.UserDetailsRequestModel;

public interface UserRepo extends JpaRepository<UserDetailsRequestModel, Integer>{

}
