package com.src.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.entity.GeekEmploye;
import com.src.repositroy.EmployeRepositroy;

@Service
public class EmployeServiceImp implements EmployeService {

	@Autowired
	private EmployeRepositroy employeRepositroy;

	@Override
	public List<GeekEmploye> findall() {
		return employeRepositroy.findAll();
	}

	@Override
	public GeekEmploye findbyid(Integer emp_id) {
		GeekEmploye geekEmploye = null;
		Optional<GeekEmploye> optional = employeRepositroy.findById(emp_id);
		if (optional.isPresent()) {
			geekEmploye = optional.get();
		}
		return geekEmploye;
	}

	@Override
	public GeekEmploye update(GeekEmploye geekEmploye) {
		return employeRepositroy.save(geekEmploye);

	}

	@Override
	public void deletebyid(Integer emp_id) {
		employeRepositroy.deleteById(emp_id);
	}

	@Override
	public GeekEmploye add(GeekEmploye geekEmploye) {
	return	employeRepositroy.save(geekEmploye);

	}
}
