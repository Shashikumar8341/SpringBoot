package com.src.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.dao.AddressDao;
import com.src.entity.Address;


@Service
public class AddressRestService implements AddressService{
	
	@Autowired
	private AddressDao addressDao;

	@Override
	public void add(Address address) {
		addressDao.add(address);
	}

	@Override
	public List<Address> findall() {
		return addressDao.findall();
	}

	@Override
	public void deletebyid(String a_area) {
		addressDao.deletebyid(a_area);
	}

	@Override
	public Address findbyid(String a_area) {
		return addressDao.findbyid(a_area);
	}

	@Override
	public void update(Address address) {
		addressDao.update(address);
		
	}
}
