package com.src.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.labrepository.Addressrepository;
import com.src.modal.Address;

@Service
public class AddressServiceImp implements AddressService {

	@Autowired
	private Addressrepository addressrepository;

	@Override
	public void add(Address address) {
		addressrepository.save(address);
	}

}