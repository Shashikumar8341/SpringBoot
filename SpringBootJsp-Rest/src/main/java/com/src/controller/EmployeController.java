package com.src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.entity.Employe;
import com.src.responseobj.ResponseObject;
import com.src.service.EmployeService;

@RestController
@RequestMapping("/employes")
@CrossOrigin(origins = "*")
public class EmployeController {
	@Autowired
	private EmployeService employeService;

	@GetMapping
	public ResponseObject findall() {
		return new ResponseObject(200, employeService.findall());

	}

	@GetMapping("{employe_id}")
	public ResponseObject findbyid(@PathVariable("employe_id") Integer employe_id) {
		return new ResponseObject(200, employeService.findbyid(employe_id));
	}

	@PostMapping
	public ResponseObject save(@RequestBody Employe employe) {
	Employe employeobj=	employeService.save(employe);
		return new ResponseObject(200, employeobj);
	}

	@PutMapping
	public ResponseObject update(@RequestBody Employe employe) {
		employeService.update(employe);
		return new ResponseObject(200, "inserted is success");
	}

	@DeleteMapping("{employe_id}")
	public ResponseObject deletebyid(@PathVariable("employe_id") Integer employe_id) {
		employeService.deletebyid(employe_id);
		return new ResponseObject(200, "Deleted is success");
	}
}
