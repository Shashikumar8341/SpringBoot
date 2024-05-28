package com.src.service;

import java.util.List;

import com.src.entity.GeekEmploye;


public interface EmployeService {
	
	public GeekEmploye add(GeekEmploye geekEmploye);

	public GeekEmploye update(GeekEmploye geekEmploye);

	public void deletebyid(Integer emp_id);

	public List<GeekEmploye> findall();

	public GeekEmploye findbyid(Integer emp_id);
}
