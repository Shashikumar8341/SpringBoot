package com.src.service;

import java.util.List;


import com.src.entity.Employe;
import com.src.repository.EmployeeRepository;

public interface EmployeService {
	public List<Employe> findall();

	public Employe findbyid(Integer employe_id);

	public Employe save(Employe employe);

	public void update(Employe employe);

	public void deletebyid(Integer employe_id);
}
