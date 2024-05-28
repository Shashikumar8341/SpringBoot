package com.src.dao;

import java.util.List;

import com.src.entity.Address;

public interface AddressDao {
	public void add(Address address);

	public void update(Address address);

	public void deletebyid(Integer a_id);

	public List<Address> findall();

	public Address findbyid(Integer a_id);
}
