package com.ciq.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciq.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Serializable>{

}
