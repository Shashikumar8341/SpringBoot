package com.src.service;

import java.util.List;

import com.src.entity.Address;


public interface AddressService {
	
	public void add(Address address);

	public void update(Address address);

	public void deletebyid(String a_area);

	public List<Address> findall();

	public Address findbyid(String a_area);
}
