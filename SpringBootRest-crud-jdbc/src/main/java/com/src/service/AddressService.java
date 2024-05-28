package com.src.service;

import java.util.List;

import com.src.entity.Address;


public interface AddressService {
	
	public void add(Address address);

	public void update(Address address);

	public void deletebyid(Integer a_id);

	public List<Address> findall();

	public Address findbyid(Integer a_id);
}
