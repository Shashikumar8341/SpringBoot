package com.src.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.entity.Employe;
import com.src.repository.EmployeRepository;

@Service
public class EmployeServiceImp implements EmployeService {

	@Autowired
	public EmployeRepository employeRepository;

	@Override
	public List<Employe> findall() {
		return employeRepository.findAll();
	}

	@Override
	public Employe findbyid(Integer employe_id) {
		Employe employe = null;
		Optional<Employe> optional = employeRepository.findById(employe_id);
		if (optional.isPresent()) {
			employe = optional.get();
		}
		return employe;
	}

	@Override
	public void save(Employe employe) {
		employeRepository.save(employe);
	}

	@Override
	public void update(Employe employe) {
		employeRepository.save(employe);

	}

	@Override
	public void deletebyid(Integer employe_id) {
		employeRepository.deleteById(employe_id);
	}
}
