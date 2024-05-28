package com.src.labrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.src.entity.Address;

public interface Addressrepository extends JpaRepository<Address, Integer>{

	void save(com.src.modal.Address address);



}
